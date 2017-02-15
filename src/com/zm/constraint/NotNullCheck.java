package com.zm.constraint;

/**
 * 
 * TODO ²»Îª¿Õ¼ì²â.<br>
 * @author zengmiao <br>
 * @version 1.0.0 2014-4-3<br>
 * @see 
 * @since JDK 1.4.2.6
 */
public class NotNullCheck  extends AbstractCheck<NotNull> {
	
	@Override
	public boolean check(final Object msg) {
		if (msg == null || "".equals(msg.toString().trim())) {
			return false;
		}		
		return true;
	}

}
