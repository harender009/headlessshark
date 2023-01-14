package com.hs.core.utils;

import com.hs.core.constants.GenericConstants;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * @author nibeditanandi
 *
 */

public class LinkUtility {

	private static final Logger LOGGER = LoggerFactory.getLogger(LinkUtility.class);
	
	/*
	 * @param url the URL
	 * 
	 * @return the full URL
	 */
	public static String getFullAEMPath(String url) {
		if (Objects.nonNull(url) && url.contains(GenericConstants.CONTENT_PREFIX)) {
			try {
				if (Boolean.TRUE.equals(isXFath(url))) {
					url = getXFRootPath(url);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return url;
	}
	
	/**
	 * Returns the root content path of experience fragment.
	 *
	 * @param xfPath the XF Path
	 * @return the xf root Path
	 */
	public static String getXFRootPath(String xfPath) {

		if (StringUtils.isNotBlank(xfPath) && !StringUtils.endsWith(xfPath, GenericConstants.JCR_CONTENT_ROOT)) {
			return xfPath + GenericConstants.JCR_CONTENT_ROOT;
		}
		return xfPath;

	}
	
	/**
	 * Check whether url is an experience fragment.
	 *
	 * @param url the url
	 * @return boolean value
	 */
	public static Boolean isXFath(String url) {
		return url.contains(GenericConstants.EXPERIENCE_FRAGMENTS);

	}
}
