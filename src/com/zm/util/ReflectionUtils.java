package com.zm.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * TODO javaӳ�乤��.<br>
 * @author zengmiao <br>
 * @version 1.0.0 2014-3-11<br>
 * @see 
 * @since JDK 1.4.2.6
 */
public final class ReflectionUtils {
	
	/**
	 * ���췽��.
	 */
	private ReflectionUtils() {
		
	}
	/**
	 * �������ȡ������get����.
	 * @param classs ������������
	 * @return .
	 */
	public static List<Method> getMethod(final Class< ? >  classs) {
		final List<Method> getMethod = new ArrayList<Method>();
		final Method[] methods = classs.getMethods();
		for (int i = 0; i < methods.length; i++) {
			final String methodname = methods[i].getName();
			if (methodname.startsWith("get")) {
				getMethod.add(methods[i]);
			}
		}
		return getMethod;
	}
	
	

}
