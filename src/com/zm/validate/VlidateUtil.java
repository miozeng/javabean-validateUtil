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
 * TODO ��֤�����࣬������֤�����Ƿ�Ϸ�.<br>
 * @author zengmiao  <br>
 * @version 1.0.0 2014-3-11<br>
 * @see 
 * @since JDK 1.4.2.6
 */
public final class VlidateUtil {
    
	/**
	 * ������.
	 */
	private VlidateUtil() {
		
	}
	/**
	 * ��֤����.
	 * @param validateObj ����֤����
	 * @param handler ��֤����
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
			//��֤�ɹ�
			handler.onSuccess(validateObj);
		} else {
			//��֤ʧ��
			 handler.onFailure(validateObj, msg);
		}
	}
	
	/**
	 * ��֤����.
	 * @param validateObj ����֤����
	 * @return ��֤�ɹ�����""����֤ʧ�ܷ���ԭ��
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
	 * ��ȡ���е�get�������Է���������֤.
	 * @param validateObj 
	 * @return ��֤ͨ���򷵻ؿ��ַ���
	 */
	private static String getValidate(final Object validateObj) {
		final Class<?> classs = validateObj.getClass();
		// ��ȡget method
		final List<Method> getMethod = ReflectionUtils.getMethod(classs);
		 StringBuffer sb = new StringBuffer();
		for (int i = 0; i < getMethod.size(); i++) {
			final Method method = getMethod.get(i);
			final String methodName = method.getName();
			Object retValue = null;
			// ��ȡget������õ�ֵ
			try {
				retValue = method.invoke(validateObj);
			} catch (Exception e) {
				// ������
				return methodName + "��ȡֵʧ��";
			}

			// ��ȡget method�����ע��
			final Annotation[] annotations = method.getAnnotations();
			for (int j = 0; j < annotations.length; j++) {
				final Annotation annotation = annotations[j];
				sb = sb.append(annotationVal(annotation, retValue, methodName));
			}
			 
		}
		return sb.toString();
	}

	/**
	 * ����ע�����Ҫ��֤��ֵ������֤.
	 * @param annotation  ��Ҫ��֤��ע��
	 * @param arg  ��Ҫ��֤��ֵ
	 * @param methodName  ������
	 * @return ��֤ͨ���򷵻ؿ��ַ���
	 */
	@SuppressWarnings("unchecked")
	private static String annotationVal(final Annotation annotation, 
			final Object arg, final String methodName) {
		final Class<? extends Annotation> type = annotation.annotationType();
		final Constraint desc = (Constraint) type.getAnnotation(Constraint.class);
		//���descΪ�գ���֤��ע�����֤ע�⣬������
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
			return checkClass.getName() + "����ʵ��ʧ��InstantiationException";
		} catch (IllegalAccessException e) {
			return checkClass.getName() + "����ʵ��ʧ��IllegalAccessException";
		}
		if (!a) {
			//��ȡ����Ĵ�����Ϣ
			String retValue = "";
			try {
				final Method method = annotation.getClass().getMethod("errmsg");
				if (method != null) {
					retValue = (method.invoke(annotation)).toString();
				}
			} catch (Exception e) {
				retValue = "retValue��ȡʧ��";
			}
			// ��֤��ͨ��
			return methodName + "��ֵ��" + arg + "����֤ʧ�ܣ�" + retValue + ";";
		} 
		return "";
	}

}
