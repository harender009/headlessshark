/**
 * 
 */
package com.hs.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.day.cq.commons.Externalizer;
import com.day.cq.tagging.TagManager;
import com.day.cq.wcm.api.Page;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hs.core.configurations.HeadlessSharkConfigurationImpl;
import com.hs.core.constants.GenericConstants;
import com.hs.core.services.ContentFragmentJSONService;
import com.hs.core.utils.TagUtility;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.settings.SlingSettingsService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Locale;

/**
 * @author nidhigurani
 *
 */
@Model(adaptables = SlingHttpServletRequest.class, adapters = {
		ComponentExporter.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class HeadlessSharkConfigurationsModel implements ComponentExporter {
	
	private static final Logger LOG = LoggerFactory.getLogger(HeadlessSharkConfigurationsModel.class);
	
	
	@Self
	private SlingHttpServletRequest request;
	
	@Inject
	HeadlessSharkConfigurationImpl headlessSharkConfiguration;
	
	@OSGiService
	SlingSettingsService slingSettingService;
	
	@OSGiService
	Externalizer externalizer;
	
	@OSGiService
	ContentFragmentJSONService cfService;
	
	@ScriptVariable
	protected ResourceResolver resolver;
	
	@Inject
	private TagManager tagManager;

	@Inject
	private Resource resource;

	@Inject
	private Page currentPage;
	
	@PostConstruct
	protected void init() {
		
		resolver = resource.getResourceResolver();
		
		tagManager = resource.getResourceResolver().adaptTo(TagManager.class);

	}
	
	@JsonIgnore
	@Override
	public String getExportedType() {
		return request.getResource().getResourceType();
	}
	
	public String getGraphQLUrl() {
		return headlessSharkConfiguration.getGraphqlEndpoint();
	}

	public String getLocale() {
		Locale locale = currentPage.getLanguage();
		return locale.toString();
	}
	
	public String getMfApplicationName() {
		
		JSONObject mfApplicationName = new JSONObject();
		
		 String mfMappingObject = cfService.getCFJson(resolver, GenericConstants.MF_APPLICATION_TAG_PATH , "master");
		 
		 try {
			JSONObject jsonObject = new JSONObject(mfMappingObject);
			JSONArray mfApplicationArray =   jsonObject.getJSONArray("mfApplications");
			for (int i = 0; i < mfApplicationArray.length (); i++) {
				   
				   JSONObject mfApplicationObject = mfApplicationArray.getJSONObject(i);
				   String key = TagUtility.getTagName(tagManager, mfApplicationObject.getJSONArray("mfApplicationName").get(0).toString()); 
				   String value = mfApplicationObject.get("mfApplicationUrl").toString(); 
				   mfApplicationName.put(key, value);
				   
				}
		} catch (JSONException e) {
			LOG.error("Error parsing exception");
		}
		
		 
		return mfApplicationName.toString();
		
	}

}
