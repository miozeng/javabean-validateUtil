package com.zm.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * TODO ������֤������.<br>
 * @author zengmiao <br>
 * @version 1.0.0 2014-3-11<br>
 * @see 
 * @since JDK 1.4.2.6
 */
public final class PatternMatcherUtil {
	
	/**
	 * ���췽��.
	 */
	private PatternMatcherUtil() {
		
	}
	/**
	 * ipport����.
	 */
	public static final String IPPORT_REG = "^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})(:\\d{3,5})?$";
	/**
	 * email����.
	 */
	public static final String EMAIL_REG = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+" 
		+ "(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
	/**
	 * date����.
	 */
	public static final String DATE_REG = "^\\d{4}-(0?[1-9]|1[0-2])-((0?[1-9])|((1|2)[0-9])|30|31)"
		+ "( ([01]\\d{1}|2[0-3]):[0-5]\\d{1}:[0-5]\\d{1})$";
	/**
	 * ��������.
	 */
	public static final String NUM_REG = "^[0-9]+$";
	
	/**
	 * ������֤����.
	 * @param value ��Ҫ��֤��ֵ
	 * @param reg ������ʽ
	 * @return .
	 */
	public static boolean matcherValue(final String value,
			final String reg) {
		final Pattern p = Pattern.compile(reg);
		final Matcher m = p.matcher(value);
		return m.matches();
	}
	
}
