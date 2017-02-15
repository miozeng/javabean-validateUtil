package com.zm.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * TODO �����ļ���֤,ֻ������Ϊ�յ���֤.<br>
 * 
 * @author zengmiao <br>
 * @version 1.0.0 2014-3-21<br>
 * @see
 * @since JDK 1.4.2.6
 */
public class PropertiesConfig {

	/**
	 * ��Ҫ��֤������.
	 */
	private String[] validateVal;

	/**
	 * properties�ļ�.
	 */
	private Properties configProperties = null;

	/**
	 * ���췽��.
	 * 
	 * @param newvalidateVal
	 *            ��Ҫ��֤������
	 * @param path
	 *            �����ļ�·��
	 */
	public PropertiesConfig(final String[] newvalidateVal, final String path) {
		super();
		this.validateVal = newvalidateVal;
		configProperties = new Properties();
		try {
			final InputStream in = PropertiesConfig.class.getClassLoader().getResourceAsStream(path);
			configProperties.load(in);
		} catch (IOException e) {
			throw new RuntimeException("����properties�ļ�ʧ��" + e);
		}

	}



	/**
	 * ��֤����ֵ�Ƿ�Ϊ��.
	 * 
	 * @return Ϊ���򷵻ش�����Ϣ�����򷵻ؿ��ַ���.
	 */
	public String validateProperties() {
		String retStr = "";
		for (int i = 0; i < validateVal.length; i++) {
			final String pro = validateVal[i];
			final String val = configProperties.getProperty(pro);
			if (val == null || "".equals(val)) {
				retStr = retStr + pro + "δ���ã�����ֵΪ�ա�";
			}
		}
		return retStr;
	}
	
}
