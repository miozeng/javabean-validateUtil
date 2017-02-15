package com.zm.constraint;

import com.zm.util.PatternMatcherUtil;

/**
 * 
 * TODO ������.<br>
 * @author zengmiao <br>
 * @version 1.0.0 2014-4-3<br>
 * @see 
 * @since JDK 1.4.2.6
 */
public class MatchPatternCheck extends AbstractCheck<MatchPattern> {

	/**
	 * ������ʽ.
	 */
	private String reg = "";
	/**
	 * set ����.
	 * @param newreg 
	 */
	public void setReg(final String newreg) {
		this.reg = newreg;
	}

	/**
	 * 
	 * {@inheritDoc}
	 * @see com.ygsoft.constraint.AbstractCheck#configure(java.lang.annotation.Annotation)
	 */
	public void configure(final MatchPattern constraintAnnotation) {
		super.configure(constraintAnnotation);
		setReg(constraintAnnotation.reg());
	}

	@Override
	public boolean check(final Object msg) {
		if(msg == null || "".equals(msg.toString().trim())){
			return true;
		}
		return PatternMatcherUtil.matcherValue(msg.toString().trim(), reg);
	}
}
