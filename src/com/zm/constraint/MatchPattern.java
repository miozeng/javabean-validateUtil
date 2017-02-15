package com.zm.constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * TODO 自定义正则验证标签.reg：自定义正则表达式,.<br>
 * @author zengmiao <br>
 * @version 1.0.0 2014-3-12<br>
 * @see 
 * @since JDK 1.4.2.6
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD })
@Constraint(checkWith = MatchPatternCheck.class)
public @interface MatchPattern {
	
	/**
	 * 正则.
	 * @return
	 */
	String reg() default "";
	
	/**
	 * 错误信息.
	 * @return
	 */
	String errmsg() default "对象不符合设定正则表达式";
}
