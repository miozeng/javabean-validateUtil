package com.zm.constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * TODO 时间验证yyyy-MM-dd hh:mm:ss.<br>
 * @author zengmiao <br>
 * @version 1.0.0 2014-3-13<br>
 * @see 
 * @since JDK 1.4.2.6
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD })
@Constraint(checkWith = SimpleDateCheck.class)
public @interface SimpleDate {
	
	/**
	 * 默认错误信息.
	 * @return
	 */
	String errmsg() default "时间格式不正确";

}
