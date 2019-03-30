/* File Name: HealthCard.java
 * Course Name: Object Oriented Programming 
 * Lab Section: 18F_CST8284
 * Student Name: Youssef Rizk
 * Date: Nov 28, 2018
 */
package assign4;

import java.io.Serializable;

/* 
 * Represents a health card number for a patient 
 */
public class HealthCard implements Serializable {
	/* 
	 * private field String of the healthCardNumber
	 */
	private String healthCardNumber;
	/* 
	 * Initial constructor with one String parameter of healthCardNumber
	 */
	public HealthCard (String healthCardNumber) {
		setHealthCardNumber(healthCardNumber);
	}

	/* 
	 * Default constructor with no parameters
	 */
	public HealthCard () {
		this("111111111");
	}

	/* 
	 * getHealthCardNumber method return healthCardNumber
	 */
	public String getHealthCardNumber() {
		return healthCardNumber;
	}
	/* 
	 * setHealthCardNumber method to set a healthCardNumber
	 */
	private void setHealthCardNumber(String healthCardNumber) {
		this.healthCardNumber = healthCardNumber; 
		for (int i = 0; i < healthCardNumber.length(); i++) {
			if (Character.isDigit(healthCardNumber.charAt(i))==false) 
				throw new MedicalClinicException(healthCardNumber.charAt(i)+" is not a digit \n"+"Health Card Number should be digits");
		}
		if (healthCardNumber.length()!=9) throw new MedicalClinicException("Health Card number must be 9 digits in length");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((healthCardNumber == null) ? 0 : healthCardNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HealthCard other = (HealthCard) obj;
		if (healthCardNumber == null) {
			if (other.healthCardNumber != null)
				return false;
		} else if (!healthCardNumber.equals(other.healthCardNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return healthCardNumber;
	}
}
