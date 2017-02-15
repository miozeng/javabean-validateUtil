package com.zm.constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * TODO 关联的对象是否做验证标签.<br>
 * 此注解只适用于1、Object对象类型.<br>
 * 2、 Collection集合对象类型或其子类.<br>
 * @author zengmiao <br>
 * @version 1.0.0 2014-3-12<br>
 * @see 
 * @since JDK 1.4.2.6
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD })
@Constraint(checkWith = RelateCheck.class)
public @interface Relate {
	
	/**
	 * 默认错误信息.
	 * @return
	 */
	String errmsg() default "子对象部分属性格式不正确";

}
