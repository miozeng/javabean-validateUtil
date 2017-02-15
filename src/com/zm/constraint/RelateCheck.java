package com.zm.constraint;

import java.util.Collection;

import com.ygsoft.validate.ValidateHandler;
import com.ygsoft.validate.VlidateUtil;

/**
 * 
 * TODO ����������֤.<br>
 * @author zengmiao <br>
 * @version 1.0.0 2014-4-3<br>
 * @see 
 * @since JDK 1.4.2.6
 */
public class RelateCheck   extends AbstractCheck<Relate> {

	/**
	 * ��֤���.
	 */
	boolean sigleRet = true;
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean check(final Object msg) {
		//�ж��Ƿ��Ǽ��϶���
		if (msg != null && (msg instanceof Collection)) {
			//msg��һ�����϶��󣬶Լ������б�����֤
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
				//����֤������ֱ�ӷ���false
				if (!sigleRet) {
					return false;
				}
			}
		} else {
			//�Ǽ��϶���
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
