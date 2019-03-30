/* File Name: OutPatient.java
 * Course Name: Object Oriented Programming 
 * Lab Section: 18F_CST8284
 * Student Name: Youssef Rizk
 * Date: Nov 28, 2018
 */
package assign4;
/*
 * subclass of Patient class. Represents an out patient that store the details of the patient.
 */

import java.io.Serializable;

public class OutPatient extends Patient implements Serializable{
	/*
	 * distanceFromClinic & mobility fields declaration.
	 */
	private double distanceFromClinic=-1;
	private boolean mobility=false;

	/*
	 * default constructor, with the default birthdate to be the day before current date
	 */
	public OutPatient() {
		this("unknown","unknown",new HealthCard(),new OurDate(new OurDate().getDay()-1,new OurDate().getMonth(),new OurDate().getYear()),-1,false);
	}
	/*
	 * initial constructor.
	 */
	public OutPatient(String firstName, String lastName, HealthCard healthCardNumber, OurDate birthDate, double distanceFromClinic, boolean mobility) {

		super(firstName,lastName,healthCardNumber,birthDate);
		setDistanceFromClinic(distanceFromClinic);
		setMobility(mobility);
	}
	/*
	 * getter Distance from clinic method, return distanceFromClinic.
	 */
	public double getDistanceFromClinic() {
		return distanceFromClinic;
	}

	/*
	 * setter distance from clinic method.
	 */
	private void setDistanceFromClinic(double distanceFromClinic) {
		this.distanceFromClinic = distanceFromClinic;
	}
	/*
	 * getter mobility method, return mobility.
	 */
	public boolean isMobility() {
		return mobility;
	}
	/*
	 * setter mobility method.
	 */
	private void setMobility(boolean mobility) {
		this.mobility = mobility;
	}

	

	@Override
	public String toString() {
		return "OutPatient [firstName=" + super.getFirstName() + ", lastName=" + super.getLastName() + ", healthCardNumber=" + super.getHealthCardNumber() + 
								 ", birthDate=" + super.getBirthDate() +"distanceFromClinic=" + distanceFromClinic + ", mobility=" + mobility + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(distanceFromClinic);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (mobility ? 1231 : 1237);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		OutPatient other = (OutPatient) obj;
		if (Double.doubleToLongBits(distanceFromClinic) != Double.doubleToLongBits(other.distanceFromClinic))
			return false;
		if (mobility != other.mobility)
			return false;
		return true;
	}
	

}
