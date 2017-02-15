package com.zm.constraint;


import com.zm.util.PatternMatcherUtil;

/**
 * 
 * TODO email¼ì²é¹æ·¶..<br>
 * @author zengmiao <br>
 * @version 1.0.0 2014-4-3<br>
 * @see 
 * @since JDK 1.4.2.6
 */
public class EmailCheck extends AbstractCheck<Email> {

	@Override
	public boolean check(final Object msg) {
		if(msg == null || "".equals(msg.toString().trim() )){
			return true;
		}
		return PatternMatcherUtil.matcherValue(msg.toString().trim(),
				PatternMatcherUtil.EMAIL_REG);
	}

}
