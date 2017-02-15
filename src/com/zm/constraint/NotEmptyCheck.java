package com.zm.constraint;

/**
 * 
 * TODO 不为空检查类.<br>
 * @author zengmiao <br>
 * @version 1.0.0 2014-4-3<br>
 * @see 
 * @since JDK 1.4.2.6
 */
public class NotEmptyCheck  extends AbstractCheck<NotEmpty> {

	@Override
	public boolean check(final Object msg) {
		if (msg == null) {
			return false;
		}
		return true;
	}

}
