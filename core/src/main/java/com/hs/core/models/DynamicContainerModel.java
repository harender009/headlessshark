/**
 * 
 */
package com.hs.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.day.cq.commons.inherit.HierarchyNodeInheritanceValueMap;
import com.day.cq.commons.inherit.InheritanceValueMap;
import com.day.cq.tagging.TagManager;
import com.day.cq.wcm.api.Page;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hs.core.services.ContentFragmentJSONService;
import com.hs.core.utils.TagUtility;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;

@Model(
        adaptables = {SlingHttpServletRequest.class},
        adapters = {DynamicContainerModel.class,ComponentExporter.class},
        resourceType = DynamicContainerModel.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, 
extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class DynamicContainerModel implements ComponentExporter {

	
	public static final String RESOURCE_TYPE = "headless-shark/components/content/components/dynamiccontainer";
	
	@Self
	SlingHttpServletRequest request;
	
	@ValueMapValue
	private String component;
	
	@ValueMapValue
	private String fragmentPath;
	
	@ValueMapValue
	private String variationName;
	
	@ScriptVariable
	private Page currentPage;
	
	@ValueMapValue
	private String jsonData;
	
	@ValueMapValue
	private String[] personas;
	
	@Inject
	private TagManager tagManager;
	
	@Inject
	ResourceResolver resolver;
	
	@OSGiService
	private ContentFragmentJSONService cfService;
	
	private InheritanceValueMap valueMap;
	
	@PostConstruct
	protected void init() {
		
		valueMap = new HierarchyNodeInheritanceValueMap(currentPage.getContentResource());

		tagManager = resolver.adaptTo(TagManager.class);

	}
	
	
	public String getComponent() {
		return TagUtility.getTagName(tagManager,component);
		}
	
	public String getPageType() {
		return TagUtility.getTagName(tagManager, valueMap.getInherited("pagetype",String.class));
		}
	
	public String getPersona() {
		return TagUtility.getTagName(tagManager, valueMap.getInherited("persona",String.class));
		}
	
	public List<String> getEligiblePersona(){
		 return this.personas == null ? null : TagUtility.getTags(tagManager, personas);
	}
	
	
	public String getCfPath() {
		return fragmentPath;
	}

	public String getCfJson() {
		if(jsonData != null && jsonData.equalsIgnoreCase("true")) {
			return cfService.getCFJson(resolver, fragmentPath, variationName);
		}
		else return StringUtils.EMPTY;
	}


	public String getJsonData() {
		return jsonData;
	}
	
	@JsonIgnore
	@Override
	public String getExportedType() {
		return RESOURCE_TYPE;
	}
	
	

}
