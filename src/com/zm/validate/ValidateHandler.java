package com.zm.validate;

/**
 * 
 * TODO 在此写上类的相关说明.<br>
 * @author zengmiao <br>
 * @version 1.0.0 2014-4-3<br>
 * @see 
 * @since JDK 1.4.2.6
 */
public abstract interface ValidateHandler {

	/**
	 * .
	 * @param paramObject 
	 */
	 void onSuccess(Object paramObject);

	 /**
	  * .
	  * @param paramObject 
	  * @param paramString 
	  */
	 void onFailure(Object paramObject, String paramString);

}
