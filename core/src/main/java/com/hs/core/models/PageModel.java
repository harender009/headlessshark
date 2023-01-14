/**
 * 
 */
package com.hs.core.models;

import com.day.cq.commons.inherit.HierarchyNodeInheritanceValueMap;
import com.day.cq.commons.inherit.InheritanceValueMap;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;

/**
 * @author nidhigurani
 *
 */
@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class PageModel {
	
	/**
	 * Property for Requested Resource.
	 */
	@Inject
	private Resource resource;
	
	/***
	 * Theme
	 */
	@ValueMapValue
	private String theme;

	public String getTheme() {
		return getInheritedValue(resource,"theme");
	}
	
	public String getInheritedValue(Resource resource, String property){
		
		InheritanceValueMap ivm = new HierarchyNodeInheritanceValueMap(resource);

        Object currentValue = ivm.getInherited(property,String.class);
        
        return currentValue.toString();
    }

}
