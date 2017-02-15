package com.zm.constraint;

import java.lang.annotation.Annotation;

/**
 * 
 * TODO 检查类的抽象类.<br>
 * @author zengmiao <br>
 * @version 1.0.0 2014-3-11<br>
 * @param <ConstraintAnnotation>
 */
public abstract class AbstractCheck<ConstraintAnnotation extends Annotation> {


	/**
	 * Annotation获取.
	 * @param constraintAnnotation 
	 */
	public void configure(final ConstraintAnnotation constraintAnnotation) {
	}
	/**
	 * 抽象检查方法.
	 * @param msg 
	 * @return .
	 */
	public abstract boolean check(Object msg);
	
}
