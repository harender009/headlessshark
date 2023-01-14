/**
 * 
 */
package com.hs.core.utils;

import com.day.cq.tagging.Tag;
import com.day.cq.tagging.TagManager;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author nidhigurani
 *
 */
public class TagUtility {
	
	/**
	 * @param tagManager
	 * @param tagId
	 * @return
	 */
	public static Tag getTag(TagManager tagManager, String tagId) {
		if (tagManager != null && StringUtils.isNotBlank(tagId)) {
			return tagManager.resolve(tagId.trim());
		}
		return null;
	}

	/**
	 * @param tagManager
	 * @param tagStr
	 * @return
	 */
	public static String getTagName(TagManager tagManager, String tagStr) {
		if (StringUtils.isNotBlank(tagStr)) {
			Tag tag = getTag(tagManager, tagStr);
			if (tag != null) { 
				return tag.getName();
			}
		}
		return null;
	}
	
	public static List<String> getTags(TagManager tagManager, String[] tagIds) {
		return Stream.<String>of(tagIds).filter(Objects::nonNull).map(tagId -> getTagName(tagManager, tagId))
				.filter(Objects::nonNull).collect(Collectors.toList());
	}


}
