/**
 * 
 */
package com.hs.core.utils;

import com.day.cq.search.QueryBuilder;
import com.hs.core.constants.ErrorResponseCode;
import com.hs.core.constants.GenericConstants;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @author nidhigurani
 *
 */
public class CommonUtils {
	@Reference
	private static QueryBuilder builder;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CommonUtils.class);

	/**
	 * @param format
	 * @param value
	 * @param locale
	 * @return
	 */
	public static Map<String, Boolean> isValidDate(String format, String date) {

		Map<String, Boolean> dateCheck = new HashMap<>();

		boolean valid = false;
		boolean expired = true;
		if(date != null) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				sdf.setLenient(false);
				sdf.parse(date);
				valid=true;
				Date dateObj = new Date();
				String currentDate = sdf.format(dateObj);
				DateTimeFormatter format2 = DateTimeFormatter.ofPattern(format);
				LocalDate expdate = LocalDate.parse(date, format2);
				LocalDate curDate = LocalDate.parse(currentDate, format2);
				if(expdate.isAfter(curDate) || expdate.isEqual(curDate)) {
					expired = false;
				}

			} catch (ParseException e) {
				LOGGER.error("Error code : {} with message {} ", ErrorResponseCode.ERROR_2000.toString() ,e.getMessage());
				valid = false;
			}

		}
		
		dateCheck.put("validDate", valid); 
		dateCheck.put("expiredDate", expired);
		return dateCheck;
	}
	
	 /**
	 * @param target
	 * @return
	 */
	public static String checkURL(final String linkUrl) {
		
		 final String target = linkUrl;
		 
		 if(target!=null) {
			 
			 if (target.startsWith("http:") || target.startsWith("https:")
		                || target.startsWith("#") || target.startsWith("//")) {

		            return target;
		        }

		       
		        if (target.startsWith(GenericConstants.FORWARD_SLASH)
		                && target.startsWith(GenericConstants.CONTENT_PREFIX)
		                && !target.contains(".")) {
		            return target +GenericConstants.URL_EXT_HTML;
		        }
			 
		 }
	        
	        return null;
	    }
	
	
	
}
