/* File Name: Doctor.java
 * Course Name: Object Oriented Programming 
 * Lab Section: 18F_CST8284
 * Student Name: Youssef Rizk
 * Date: Nov 28, 2018
 */
package assign4;

import java.io.Serializable;

/*
 * Represents a doctor that store the details of the doctor.
 */
public class Doctor implements Serializable {
	/*
	 * fields declaration for first name, last name and specialty.
	 */
	private String firstName=new String();
	private String lastName=new String();
	private String specialty=new String();

	/*
	 * Default constructor.
	 */
	public Doctor () {
		this("unknown","unknown","unknown");
	}
	/*
	 * Initial constructor.
	 */
	public Doctor (String firstName, String lastName, String specialty) {
		setFirstName(firstName);
		setLastName(lastName);
		setSpecialty(specialty);
	}

	/*
	 * Get first name method.
	 */
	public String getFirstName() {
		return firstName;
	}
	/*
	 * set first name method.
	 */
	private void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/*
	 * get last name method.
	 */
	public String getLastName() {
		return lastName;
	}
	/*
	 * set last name method.
	 */
	private void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/*
	 * get specialty method .
	 */
	public String getSpecialty() {
		return specialty;
	}
	/*
	 * set specialty method .
	 */
	private void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	@Override
	public String toString() {
		return (firstName +" "+ lastName  + " "+specialty);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((specialty == null) ? 0 : specialty.hashCode());
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
		Doctor other = (Doctor) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (specialty == null) {
			if (other.specialty != null)
				return false;
		} else if (!specialty.equals(other.specialty))
			return false;
		return true;
	}

}
