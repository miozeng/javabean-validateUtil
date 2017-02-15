package com.zm.constraint;

/**
 * 
 * TODO 长度检查.<br>
 * @author zengmiao <br>
 * @version 1.0.0 2014-4-3<br>
 * @see 
 * @since JDK 1.4.2.6
 */
public  class LengthCheck  extends AbstractCheck<Length> {
	

	/**
	 * 最小长度.
	 */
	private int minlength;
	
	/**
	 * 最小长度.
	 */
	private int maxlength;
	
	/**
	 * set 方法.
	 * @param newminlength 
	 */
	public void setMinlength(final int newminlength) {
		this.minlength = newminlength;
	}

	/**
	 * set 方法.
	 * @param newmaxlength 
	 */
	public void setMaxlength(final int newmaxlength) {
		this.maxlength = newmaxlength;
	}

	/**
	 *.
	 * {@inheritDoc}
	 * @see com.ygsoft.constraint.AbstractCheck#configure(java.lang.annotation.Annotation)
	 */
	public void configure(final Length constraintAnnotation) {
		super.configure(constraintAnnotation);
		setMinlength(constraintAnnotation.minlength());
		setMaxlength(constraintAnnotation.maxlength());
	}

	@Override
	public boolean check(final Object msg) {
		if (msg != null) {
			final String msgstr = msg.toString();
			if (minlength >= 0 && msgstr.length() < minlength) {
				return false;
			}
			if (maxlength >= 0 && msgstr.length() > maxlength) {
				return false;
			}
		} else {
			return false;
		}
		return true;
	}
	

}
