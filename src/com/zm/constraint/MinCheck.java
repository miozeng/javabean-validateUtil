package com.zm.constraint;

/**
 * 
 * TODO最小值检查.<br>
 * @author zengmiao <br>
 * @version 1.0.0 2014-4-3<br>
 * @see 
 * @since JDK 1.4.2.6
 */
public class MinCheck  extends AbstractCheck<Min> {

	/**
	 * 最小值.
	 */
	private int min;
	
	/**
	 * set 方法.
	 * @param newmin  
	 */
	public void setMin(final int newmin) {
		this.min = newmin;
	}

	/**
	 * 
	 * {@inheritDoc}
	 * @see com.ygsoft.constraint.AbstractCheck#configure(java.lang.annotation.Annotation)
	 */
	public void configure(final Min constraintAnnotation) {
		super.configure(constraintAnnotation);
		setMin(constraintAnnotation.min());
	}
	
	@Override
	public boolean check(final Object msg) {
		if (msg != null) {
			final Integer msgInt = Integer.parseInt(msg.toString());
			if ((Object) min != null && msgInt < min) {
				return false;
			}
		}
		return true;
	}
}
