package com.zm.constraint;

import java.lang.annotation.Annotation;

/**
 * 
 * TODO �����ĳ�����.<br>
 * @author zengmiao <br>
 * @version 1.0.0 2014-3-11<br>
 * @param <ConstraintAnnotation>
 */
public abstract class AbstractCheck<ConstraintAnnotation extends Annotation> {


	/**
	 * Annotation��ȡ.
	 * @param constraintAnnotation 
	 */
	public void configure(final ConstraintAnnotation constraintAnnotation) {
	}
	/**
	 * �����鷽��.
	 * @param msg 
	 * @return .
	 */
	public abstract boolean check(Object msg);
	
}
