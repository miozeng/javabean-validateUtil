package com.zm.constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * TODO �Զ���������֤��ǩ.reg���Զ���������ʽ,.<br>
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
	 * ����.
	 * @return
	 */
	String reg() default "";
	
	/**
	 * ������Ϣ.
	 * @return
	 */
	String errmsg() default "���󲻷����趨������ʽ";
}
