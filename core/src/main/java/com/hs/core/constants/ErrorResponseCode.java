/**
 * 
 */
package com.hs.core.constants;

/**
 * @author nidhigurani
 *
 */
public enum ErrorResponseCode {
	  ERROR_2000(2000, "Unparseable date"),
	  ERROR_20001(2001, "20001 error code");

	  private final int errorCode;
	  private final String description;

	  /**
	 * @param errorCode
	 * @param description
	 */
	ErrorResponseCode(int errorCode, String description) {
		this.errorCode = errorCode;
	    this.description = description;
	}

	  public String getDescription() {
	     return description;
	  }

	  public int getErrorCode() {
	     return errorCode;
	  }

	  @Override
	  public String toString() {
	    return errorCode + ": " + description;
	  }

}
