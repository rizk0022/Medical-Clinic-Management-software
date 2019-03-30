/* File Name: Patient.java
 * Course Name: Object Oriented Programming 
 * Lab Section: 18F_CST8284
 * Student Name: Youssef Rizk
 * Date: Nov 28, 2018
 */
package assign4;

import java.io.Serializable;
import java.util.Calendar;

/*
 * Represents a Patient to store the searchable data for the patient.
 */
public class Patient implements Serializable{
	/*
	 * firstName, lastName & healthCardNumber fields declaration
	 */
	private String firstName= new String();
	private String lastName= new String();
	/*
	 * declaration of HealthCard reference variable of HealthCard class
	 */
	private HealthCard healthCardNumber;
	
	/*
	 * declaration of birthDate reference variable of OurDate class.
	 */
	private OurDate birthDate;

	/*
	 * default constructor
	 */
	public Patient() {
		this("unknown","unknown",new HealthCard(),new OurDate());
	}
	/*
	 * initial constructor
	 */
	public Patient(String firstName, String lastName, HealthCard healthCardNumber, OurDate birthDate) {

		setFirstName(firstName);
		setLastName(lastName);
		setHealthCardNumber(healthCardNumber);
		setBirthDate(birthDate);
	}

	
	@Override
	public String toString() {
		return "Patient [firstName=" + firstName + ", lastName=" + lastName + ", healthCardNumber=" + healthCardNumber
				+ ", birthDate=" + birthDate + "]";
	}
	
	/*
	 * get First Name method, return firstName.
	 */
	public String getFirstName() {
		return firstName;
	}
	/*
	 * set First Name method.
	 */
	private void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/*
	 * getter Last Name method, return lastName.
	 */
	public String getLastName() {
		return lastName;
	}
	/*
	 * set Last Name method.
	 */
	private void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/*
	 * get Health Card Number method, return healthCardNumber.
	 */
	public HealthCard getHealthCardNumber() {
		return healthCardNumber;
	}
	/*
	 * set health card number method.
	 */
	private void setHealthCardNumber(HealthCard healthCardNumber) {
			this.healthCardNumber = healthCardNumber;
			
	}

	/*
	 * get birth date method, return birthDate.
	 */
	public OurDate getBirthDate() {
		return birthDate;
	}
	/*
	 * set birth date method.
	 */
	private void setBirthDate(OurDate birthDate) {
		this.birthDate = birthDate;
		Calendar current = Calendar.getInstance();
		Calendar xDate = Calendar.getInstance();
		current.set(current.get(Calendar.YEAR), current.get(Calendar.MONTH)+1, current.get(Calendar.DATE));
		xDate.set(birthDate.getYear(), birthDate.getMonth(), birthDate.getDay());
		if (current.compareTo(xDate)==-1) throw new MedicalClinicException("Birthdate cannot be in the future");
		if (current.equals(xDate)) throw new MedicalClinicException("Birthdate cannot be today");
		if (birthDate.getYear()<1900) throw new MedicalClinicException("CONGRATULATIONS CENTENARIAN! PLEASE SIGN UP WITH GERIATRICS");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((healthCardNumber == null) ? 0 : healthCardNumber.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		Patient other = (Patient) obj;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (healthCardNumber == null) {
			if (other.healthCardNumber != null)
				return false;
		} else if (!healthCardNumber.equals(other.healthCardNumber))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

}
