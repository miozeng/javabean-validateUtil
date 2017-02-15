package com.zm.constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * TODO 整数数字的最小值设定标签.<br>
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
	 * 最小值.
	 * @return
	 */
	int min();
	/**
	 * 错误信息.
	 * @return
	 */
	String errmsg() default "整数超过设定最小值范围";
}
