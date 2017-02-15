package com.zm.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * TODO 配置文件验证,只做不可为空的验证.<br>
 * 
 * @author zengmiao <br>
 * @version 1.0.0 2014-3-21<br>
 * @see
 * @since JDK 1.4.2.6
 */
public class PropertiesConfig {

	/**
	 * 需要验证的属性.
	 */
	private String[] validateVal;

	/**
	 * properties文件.
	 */
	private Properties configProperties = null;

	/**
	 * 构造方法.
	 * 
	 * @param newvalidateVal
	 *            需要验证的属性
	 * @param path
	 *            配置文件路径
	 */
	public PropertiesConfig(final String[] newvalidateVal, final String path) {
		super();
		this.validateVal = newvalidateVal;
		configProperties = new Properties();
		try {
			final InputStream in = PropertiesConfig.class.getClassLoader().getResourceAsStream(path);
			configProperties.load(in);
		} catch (IOException e) {
			throw new RuntimeException("加载properties文件失败" + e);
		}

	}



	/**
	 * 验证属性值是否为空.
	 * 
	 * @return 为空则返回错误信息，否则返回空字符串.
	 */
	public String validateProperties() {
		String retStr = "";
		for (int i = 0; i < validateVal.length; i++) {
			final String pro = validateVal[i];
			final String val = configProperties.getProperty(pro);
			if (val == null || "".equals(val)) {
				retStr = retStr + pro + "未配置，或者值为空。";
			}
		}
		return retStr;
	}
	
}
