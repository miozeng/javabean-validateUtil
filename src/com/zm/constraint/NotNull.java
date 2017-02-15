package com.zm.constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * TODO String����Ϊ���Ҳ��ǿ��ַ���.<br>
 * @author zengmiao <br>
 * @version 1.0.0 2014-3-12<br>
 * @see 
 * @since JDK 1.4.2.6
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD })
@Constraint(checkWith = NotNullCheck.class)
public @interface NotNull {
	/**
	 * ������Ϣ.
	 * @return
	 */
	String errmsg() default "�ַ���������Ϊ��";

}