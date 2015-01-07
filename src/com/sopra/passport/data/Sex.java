package com.sopra.passport.data;

/**
 * This enumeration represents the sex of the user.
 */
public enum Sex {
	MALE,
	FEMALE;
	
	/**
	 * Returns the string associated to each sex.
	 */
	@Override
	public String toString() {
		String str = null;
		
		switch(this) {
			case MALE: 
				str = "M";
				break;
			case FEMALE: 
				str = "F";
				break;
			default: 
				throw new IllegalArgumentException();
	    }
		
		return str;
	}
}
