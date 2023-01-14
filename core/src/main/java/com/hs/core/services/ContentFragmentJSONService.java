/**
 * 
 */
package com.hs.core.services;

import org.apache.sling.api.resource.ResourceResolver;

/**
 * @author nidhigurani
 *
 */
public interface ContentFragmentJSONService {
	
	String getCFJson(ResourceResolver resolver, String cfPath, String variationName);

}
