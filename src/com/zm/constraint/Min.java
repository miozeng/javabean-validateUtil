package com.zm.constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * TODO �������ֵ���Сֵ�趨��ǩ.<br>
 * @author zengmiao <br>
 * @version 1.0.0 2014-3-13<br>
 * @see 
 * @since JDK 1.4.2.6
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD })
@Constraint(checkWith = MinCheck.class)
public @interface Min {
	
	/**
	 * ��Сֵ.
	 * @return
	 */
	int min();
	/**
	 * ������Ϣ.
	 * @return
	 */
	String errmsg() default "���������趨��Сֵ��Χ";
}
