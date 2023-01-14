/**
 * 
 */
package com.hs.core.services.impl;

import com.adobe.cq.dam.cfm.ContentElement;
import com.adobe.cq.dam.cfm.ContentFragment;
import com.adobe.cq.dam.cfm.ContentVariation;
import com.adobe.cq.dam.cfm.FragmentData;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.hs.core.services.ContentFragmentJSONService;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;

/**
 * @author nidhigurani
 *
 */
@Component(service = { ContentFragmentJSONService.class }, immediate = true)
public class ContentFragmentJSONServiceImpl implements ContentFragmentJSONService {

	private static final Logger LOG = LoggerFactory.getLogger(ContentFragmentJSONServiceImpl.class);
	public static final String CONTENT_FRAGMENT = "content-fragment";
	private static final String CF_INVALID_RESOURCE = "Please enter valid content fragment path";
	final ObjectMapper mapper = new ObjectMapper();

	/**
	 * To retrieve the content fragments elements in JSON format
	 *
	 * @param cfPath
	 */
	@Override
	public String getCFJson(ResourceResolver resolver, String cfPath, String variationName) {
		ObjectNode keyNode = mapper.createObjectNode();
		Resource fragmentResource = resolver.getResource(cfPath);

		if (fragmentResource != null) {
			ContentFragment fragment = fragmentResource.adaptTo(ContentFragment.class);
			if (fragment != null) {
				Iterator<ContentElement> elements = fragment.getElements();
				ObjectNode singleCFMarketingNode = mapper.createObjectNode();
				while (elements.hasNext()) {
					ContentElement element = elements.next();
					ContentVariation variation = element.getVariation(variationName);
					String elementSemanticType = element.getValue().getDataType().getTypeString();
					String elementContent = variation !=null ? variation.getContent() : element.getContent();
					Boolean isMultiValueElement = element.getValue().getDataType().isMultiValue();
					FragmentData fragmentData = variation !=null ? variation.getValue() :element.getValue();
					// call in case of multi field CF
					if (StringUtils.isNotEmpty(elementSemanticType) && elementSemanticType.equals(CONTENT_FRAGMENT)) {
						ObjectNode segmentNode = mapper.createObjectNode();
						fragmentReferenceSegmentation(element.getName(), elementContent, resolver, keyNode, segmentNode,
								fragmentData, isMultiValueElement, cfPath);
					} else {
						// call in case of cf single Cf
						setJSONKeyNode(isMultiValueElement, elementContent, element, fragmentData, keyNode,
								elementSemanticType, singleCFMarketingNode);
					}
				}
			} else {
				keyNode.put("errorMsg", CF_INVALID_RESOURCE);
			}
		} else {
			keyNode.put("errorMsg", CF_INVALID_RESOURCE);
		}
		return keyNode.toString();
	}

	/**
	 * This method will iterate the content fragment references to create a
	 * segmentation
	 *
	 * @param contentReference
	 * @param resolver
	 * @param keyNode
	 */
	// work in case of ContentFragment Multi field
	private void fragmentReferenceSegmentation(String propertyName, String contentReference, ResourceResolver resolver,
			ObjectNode keyNode, ObjectNode segmentNode, FragmentData fragmentData, Boolean isMultiValueRef,
			String cfPath) {
		if (StringUtils.isNotEmpty(contentReference)) {
			ArrayNode multiFragmentRefNode = mapper.createArrayNode();
			if (Boolean.TRUE.equals(isMultiValueRef)) {
				String[] contentArray = fragmentData.getValue(String[].class);
				if (contentArray != null) {
					for (final String s : contentArray) {
						ObjectNode innerNode = mapper.createObjectNode();
						fragmentReferenceSetSegmentation(propertyName, s, resolver, keyNode, innerNode, isMultiValueRef,
								multiFragmentRefNode, cfPath);
					}
				}
			} else {
				fragmentReferenceSetSegmentation(propertyName, contentReference, resolver, keyNode, segmentNode,
						isMultiValueRef, multiFragmentRefNode, cfPath);
			}
		}
	}

	/**
	 * This method set the segmentation for content fragment references
	 *
	 * @param contentReferencePath
	 * @param resolver
	 * @param keyNode
	 */
	private void fragmentReferenceSetSegmentation(String propertyName, String contentReferencePath,
			ResourceResolver resolver, ObjectNode keyNode, ObjectNode innerNode, Boolean isMultiValueRef,
			ArrayNode multiFragmentRefNode, String cfPath) {
		Resource refResource = resolver.getResource(contentReferencePath);
		if (refResource != null) {
			ContentFragment innerFragment = refResource.adaptTo(ContentFragment.class);
			if (innerFragment != null) {
				Iterator<ContentElement> innerElements = innerFragment.getElements();
				ObjectNode multiCfMarketingNode = mapper.createObjectNode();
				while (innerElements.hasNext()) {
					ContentElement elementInner = innerElements.next();
					Boolean isMultiValueInner = elementInner.getValue().getDataType().isMultiValue();
					FragmentData fragmentDataInner = elementInner.getValue();
					String elementSemanticTypeInner = elementInner.getValue().getDataType().getTypeString();
					String elementContentInner = elementInner.getContent();
					if (elementSemanticTypeInner.equals(CONTENT_FRAGMENT)) {
						ObjectNode recursiveNode = mapper.createObjectNode();
						fragmentReferenceSegmentation(elementInner.getName(), elementContentInner, resolver, innerNode,
								recursiveNode, fragmentDataInner, isMultiValueInner, cfPath);
					} else {
						setJSONKeyNode(isMultiValueInner, elementContentInner, elementInner, fragmentDataInner,
								innerNode, elementSemanticTypeInner, multiCfMarketingNode);
					}
					if (Boolean.FALSE.equals(isMultiValueRef)) {
						keyNode.set(refResource.getName(), innerNode);
					}
				}
				ConvertFragmentJsonToArray(cfPath, resolver, propertyName, isMultiValueRef, keyNode,
						multiFragmentRefNode, innerNode, refResource);

			}
		}
	}

	/**
	 * This method will check the flag value and convert the json structure of Multi
	 * Content Fragment Reference into fragments Array or fragments Objects
	 * Accordingly.
	 *
	 * @param cfPath
	 * @param resolver
	 * @param propertyName
	 * @param isMultiValueRef
	 * @param keyNode
	 * @param multiFragmentRefNode
	 * @param innerNode
	 * @param refResource
	 */
	private void ConvertFragmentJsonToArray(String cfPath, ResourceResolver resolver, String propertyName,
			Boolean isMultiValueRef, ObjectNode keyNode, ArrayNode multiFragmentRefNode, ObjectNode innerNode,
			Resource refResource) {
		if (Objects.nonNull(cfPath)) {
			Resource globalResource = resolver.getResource(cfPath);
			Iterator<Resource> characteristicChild = globalResource.listChildren();
			while (characteristicChild.hasNext()) {
				Resource characteristicChildResource = characteristicChild.next();
				Resource masterResource = resolver.getResource(characteristicChildResource.getPath() + "/data/master");
				if (Objects.nonNull(masterResource)) {
					ValueMap properties = masterResource.adaptTo(ValueMap.class);
					if (Objects.nonNull(properties)) {
						if (isMultiValueRef) {
							setMultiFragmentKeyNode(propertyName, isMultiValueRef, keyNode, multiFragmentRefNode,
									innerNode);
						} else {
							keyNode.set(refResource.getName(), innerNode);
						}
					}
				}
			}
		}
	}

	/**
	 * This method will convert the content fragment elements into json structure
	 *
	 * @param isMultiValueElement
	 * @param elementContent
	 * @param element
	 * @param fragmentData
	 * @param keyNode
	 * @param elementSemanticType
	 */
	private void setJSONKeyNode(Boolean isMultiValueElement, String elementContent, ContentElement element,
			FragmentData fragmentData, ObjectNode keyNode, String elementSemanticType, ObjectNode marketingKeyNode) {
		String elementValueType = element.getValue().toString();
		String elementPropertyInitial = element.getName();
		String elementProperty = null;

		try {

			elementProperty = elementPropertyInitial;
			setFinalJson(isMultiValueElement, elementContent, fragmentData, keyNode, elementSemanticType,
					elementValueType, elementProperty);

		} catch (IOException e) {
			LOG.error("Exception while mapping the json {}", e.getMessage());
		}
	}

	private void setFinalJson(Boolean isMultiValueElement, String elementContent, FragmentData fragmentData,
			ObjectNode keyNode, String elementSemanticType, String elementValueType, String elementProperty)
			throws IOException {
		if (Boolean.TRUE.equals(isMultiValueElement)) {
			String[] contentArray = fragmentData.getValue(String[].class);
			ArrayNode multiValueElement = convertStrArrToJSONArr(contentArray);
			keyNode.set(elementProperty, multiValueElement);

		} else if (StringUtils.isNotEmpty(elementValueType) && elementValueType.equals("boolean")) {
			keyNode.put(elementProperty, Boolean.valueOf(elementContent));
		} else if ((StringUtils.isNotEmpty(elementSemanticType) && elementSemanticType.equals("json"))) {
			JsonNode actualObj = mapper.readTree(elementContent);
			keyNode.set(elementProperty, actualObj);
		} else {
			keyNode.put(elementProperty, elementContent);
		}
	}

	/**
	 * To convert string array to json array node
	 *
	 * @param contentArray
	 * @return
	 */
	private ArrayNode convertStrArrToJSONArr(String[] contentArray) {
		ArrayNode arrayNode = mapper.createArrayNode();
		if (contentArray != null) {
			for (final String s : contentArray) {
				arrayNode.add(s);
			}
		}
		return arrayNode;
	}

	/**
	 * This method will set the Array JSON Structure for Multi Content Fragment
	 * Reference
	 *
	 * @param propertyName
	 * @param isMultiValueRef
	 * @param keyNode
	 * @param multiFragmentRefNode
	 * @param innerNode
	 */
	private void setMultiFragmentKeyNode(String propertyName, Boolean isMultiValueRef, ObjectNode keyNode,
			ArrayNode multiFragmentRefNode, ObjectNode innerNode) {
		if (Boolean.TRUE.equals(isMultiValueRef)) {
			multiFragmentRefNode.add(innerNode);
			keyNode.set(propertyName, multiFragmentRefNode);
		}
	}

}
