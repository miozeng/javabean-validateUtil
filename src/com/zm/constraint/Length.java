package com.zm.constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * TODO 字符串长度验证标签 minlength<=length<=maxlength.<br>
 * 不配置则默认不验证，可单独配置minlength或者maxlength.<br>
 * 都不配置则不验证，数据为空则返回false.<br>
 * @author zengmiao <br>
 * @version 1.0.0 2014-3-12<br>
 * @see 
 * @since JDK 1.4.2.6
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD })
@Constraint(checkWith = LengthCheck.class)
public @interface Length {
	
	/**
	 * 最小长度.
	 * @return
	 */
	int minlength() default -1;
	
	/**
	 * 最大长度.
	 * @return
	 */
	int maxlength() default -1;
	
	/**
	 * 错误信息.
	 * @return
	 */
	String errmsg() default "字符串长度超过设定长度";

}
