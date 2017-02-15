package com.zm.constraint;

/**
 * 
 * TODO 数字最大值检查.<br>
 * @author zengmiao <br>
 * @version 1.0.0 2014-4-3<br>
 * @see 
 * @since JDK 1.4.2.6
 */
public class MaxCheck  extends AbstractCheck<Max> {
	/**
	 * .
	 */
	private int max;
	

	/**
	 * set方法.
	 * @param newmax 
	 */
	public void setMax(final int newmax) {
		this.max = newmax;
	}

	/**
	 *.
	 * {@inheritDoc}
	 * @see com.ygsoft.constraint.AbstractCheck#configure(java.lang.annotation.Annotation)
	 */
	public void configure(final Max constraintAnnotation) {
		super.configure(constraintAnnotation);
		setMax(constraintAnnotation.max());
	}
	
	@Override
	public boolean check(final Object msg) {
		if (msg != null) {
			final Integer msgInt = Integer.parseInt(msg.toString());
			if ((Object) max != null && msgInt > max) {
				return false;
			}
		}
		return true;
	}

}
