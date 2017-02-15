package com.zm.constraint;

/**
 * 
 * TODO ���ȼ��.<br>
 * @author zengmiao <br>
 * @version 1.0.0 2014-4-3<br>
 * @see 
 * @since JDK 1.4.2.6
 */
public  class LengthCheck  extends AbstractCheck<Length> {
	

	/**
	 * ��С����.
	 */
	private int minlength;
	
	/**
	 * ��С����.
	 */
	private int maxlength;
	
	/**
	 * set ����.
	 * @param newminlength 
	 */
	public void setMinlength(final int newminlength) {
		this.minlength = newminlength;
	}

	/**
	 * set ����.
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
