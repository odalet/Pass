package com.sopra.passport.data;

import java.io.Serializable;

/**
 * This enumeration represents the sex of the user.
 */
public enum Gender implements Serializable {
	FEMALE,
	MALE,
	ND;
	
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
			case ND: 
				str = "ND";
				break;
			default: 
				throw new IllegalArgumentException();
	    }
		
		return str;
	}
	
	public boolean equals(Gender gender){
		if(this == gender || this == ND)
			return true;

		return false;
	}
}
