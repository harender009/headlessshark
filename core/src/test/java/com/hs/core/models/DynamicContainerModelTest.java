package com.hs.core.models;

import com.day.cq.commons.inherit.InheritanceValueMap;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.hs.core.services.ContentFragmentJSONService;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author nibeditanandi
 *
 */

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
class DynamicContainerModelTest {
	
	public static final String RESOURCE_TYPE = "headless-shark/components/content/components/dynamiccontainer";

	private final AemContext ctx = new AemContext();
	private DynamicContainerModel dynamiccontainer;
	
	@Mock
    private ContentFragmentJSONService cfService;
	
	@Mock
	Resource resource;
	
	@Mock
	ResourceResolver resolver;
	
	@Mock
	InheritanceValueMap valueMap;
	
	@Mock
	Resource currentResource;
	
	ObjectMapper mapper = new ObjectMapper();
	ObjectNode keyNode = mapper.createObjectNode();
	
	@BeforeEach
	void setUp() {
		ctx.addModelsForClasses(DynamicContainerModel.class);
		ctx.load().json("/com/indigo/skyplus6e/core/models/DynamicContainerModel.json", "/component");
		ctx.load().json("/com/indigo/skyplus6e/core/models/DynamicContainerTag.json", "/content/cq:tags/skyplus6e");
		ctx.load().json("/com/indigo/skyplus6e/core/models/HomePage.json", "/content/skyplus6e/language-masters/en/home/homepage");
		ctx.create().page("/content/skyplus6e/language-masters/en/home/homepage", "/conf/skyplus6e/settings/wcm/templates/page-content");
		ctx.currentPage("/content/skyplus6e/language-masters/en/home/homepage"); 
		mockCFJson(keyNode);
		Mockito.lenient().when(cfService.getCFJson(resolver, "/content/dam/skyplus6e/in/en/global-components/header/login/login-member", "master")).thenReturn(keyNode.toString());
		ctx.registerService(ContentFragmentJSONService.class,cfService,org.osgi.framework.Constants.SERVICE_RANKING, Integer.MAX_VALUE);
	}

	@Test
	void testDynamicModelTestCase_1() throws NoSuchFieldException {
		ctx.currentResource("/component/jcr:content/root/dynamiccontainer");
		dynamiccontainer = ctx.request().adaptTo(DynamicContainerModel.class);
		Mockito.lenient().when(resource.getResourceResolver()).thenReturn(resolver);
		dynamiccontainer.getCfJson();
		assertEquals("/content/dam/skyplus6e/in/en/global-components/header/login/login-member", dynamiccontainer.getCfPath());
		assertEquals("true", dynamiccontainer.getJsonData());
		assertEquals("mf-login",dynamiccontainer.getComponent());
		assertEquals("master",dynamiccontainer.getPageType());
		assertEquals("member", dynamiccontainer.getPersona());
		assertEquals("member", dynamiccontainer.getEligiblePersona().get(0));
		assertEquals("corpconnectuser", dynamiccontainer.getEligiblePersona().get(1));
		assertEquals(RESOURCE_TYPE, dynamiccontainer.getExportedType());
	}
	private void mockCFJson(ObjectNode keyNode) {
		keyNode.put("buttonLabel", "Login");
		keyNode.put("registrationLabel", "Sign Up");
		keyNode.put("hidePasswordLabel", "Hide");
	}

	
	

}