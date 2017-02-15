package com.zm.constraint;

import java.util.Collection;

import com.ygsoft.validate.ValidateHandler;
import com.ygsoft.validate.VlidateUtil;

/**
 * 
 * TODO 关联子类验证.<br>
 * @author zengmiao <br>
 * @version 1.0.0 2014-4-3<br>
 * @see 
 * @since JDK 1.4.2.6
 */
public class RelateCheck   extends AbstractCheck<Relate> {

	/**
	 * 验证结果.
	 */
	boolean sigleRet = true;
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean check(final Object msg) {
		//判断是否是集合对象
		if (msg != null && (msg instanceof Collection)) {
			//msg是一个集合对象，对几个进行遍历验证
			final Collection<?> msgs = (Collection<?>) msg;
			for (Object obj : msgs) {
				VlidateUtil.validate(obj, new ValidateHandler() {
					public void onSuccess(final Object paramObject) {
						sigleRet = true;
					}
					
					public void onFailure(final Object paramObject, 
							final String paramString) {
						sigleRet = false;
					}
				});
				//有验证错误则直接返回false
				if (!sigleRet) {
					return false;
				}
			}
		} else {
			//非集合对象
			VlidateUtil.validate(msg, new ValidateHandler() {
				public void onSuccess(final Object paramObject) {
					sigleRet = true;
				}
				
				public void onFailure(final Object paramObject, 
						final String paramString) {
					sigleRet = false;
				}
			});
		}
		return sigleRet;
	}
	


}
