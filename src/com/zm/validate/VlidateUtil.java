package com.zm.validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;

import com.zm.constraint.AbstractCheck;
import com.zm.constraint.Constraint;
import com.zm.properties.PropertiesConfig;
import com.zm.util.ReflectionUtils;


/**
 * 
 * TODO 验证工具类，用来验证对象是否合法.<br>
 * @author zengmiao  <br>
 * @version 1.0.0 2014-3-11<br>
 * @see 
 * @since JDK 1.4.2.6
 */
public final class VlidateUtil {
    
	/**
	 * 构造器.
	 */
	private VlidateUtil() {
		
	}
	/**
	 * 验证对象.
	 * @param validateObj 需验证对象
	 * @param handler 验证处理
	 */
	public static void validate(final Object validateObj, 
			final ValidateHandler handler) {
		if (validateObj == null) {
			return;
		}

		if (handler == null) {
			return;
		}
		
		String msg = "";
		if (validateObj instanceof PropertiesConfig) {
			final PropertiesConfig pro = (PropertiesConfig) validateObj;
			msg = pro.validateProperties();
		} else {
			msg = getValidate(validateObj);
		}
		if ("".equals(msg)) {
			//验证成功
			handler.onSuccess(validateObj);
		} else {
			//验证失败
			 handler.onFailure(validateObj, msg);
		}
	}
	
	/**
	 * 验证对象.
	 * @param validateObj 需验证对象
	 * @return 验证成功返回""，验证失败返回原因
	 */
	public static String validate(final Object validateObj) {
		if (validateObj == null) {
			return "";
		}

		String msg = "";
		if (validateObj instanceof PropertiesConfig) {
			final PropertiesConfig pro = (PropertiesConfig) validateObj;
			msg = pro.validateProperties();
		} else {
			msg = getValidate(validateObj);
		}
		return msg;
	}
	/**
	 * 获取所有的get方法并对方法进行验证.
	 * @param validateObj 
	 * @return 验证通过则返回空字符串
	 */
	private static String getValidate(final Object validateObj) {
		final Class<?> classs = validateObj.getClass();
		// 获取get method
		final List<Method> getMethod = ReflectionUtils.getMethod(classs);
		 StringBuffer sb = new StringBuffer();
		for (int i = 0; i < getMethod.size(); i++) {
			final Method method = getMethod.get(i);
			final String methodName = method.getName();
			Object retValue = null;
			// 获取get方法获得的值
			try {
				retValue = method.invoke(validateObj);
			} catch (Exception e) {
				// 错误处理
				return methodName + "获取值失败";
			}

			// 获取get method上面的注解
			final Annotation[] annotations = method.getAnnotations();
			for (int j = 0; j < annotations.length; j++) {
				final Annotation annotation = annotations[j];
				sb = sb.append(annotationVal(annotation, retValue, methodName));
			}
			 
		}
		return sb.toString();
	}

	/**
	 * 根据注解和需要验证的值进行验证.
	 * @param annotation  需要验证的注解
	 * @param arg  需要验证的值
	 * @param methodName  方法名
	 * @return 验证通过则返回空字符串
	 */
	@SuppressWarnings("unchecked")
	private static String annotationVal(final Annotation annotation, 
			final Object arg, final String methodName) {
		final Class<? extends Annotation> type = annotation.annotationType();
		final Constraint desc = (Constraint) type.getAnnotation(Constraint.class);
		//如果desc为空，则证明注解非验证注解，不处理
		if(desc == null){
			return "";
		}
		final Class<?> checkClass = desc.checkWith();
		boolean a = false;
		try {
			final AbstractCheck t = (AbstractCheck) checkClass.newInstance();
			t.configure(annotation);
			a = t.check(arg);
		} catch (InstantiationException e) {
			return checkClass.getName() + "生成实例失败InstantiationException";
		} catch (IllegalAccessException e) {
			return checkClass.getName() + "生成实例失败IllegalAccessException";
		}
		if (!a) {
			//获取定义的错误信息
			String retValue = "";
			try {
				final Method method = annotation.getClass().getMethod("errmsg");
				if (method != null) {
					retValue = (method.invoke(annotation)).toString();
				}
			} catch (Exception e) {
				retValue = "retValue获取失败";
			}
			// 验证不通过
			return methodName + "的值【" + arg + "】验证失败：" + retValue + ";";
		} 
		return "";
	}

}
