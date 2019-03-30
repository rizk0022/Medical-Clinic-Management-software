/* File Name: Appointment.java
 * Course Name: Object Oriented Programming 
 * Lab Section: 18F_CST8284
 * Student Name: Youssef Rizk
 * Date: Nov 28, 2018
 */
package assign4;
import java.io.Serializable;
import java.util.Calendar;

/*
 * Represents an Appointment that store the details of the appointment.
 */
public class Appointment implements Serializable {
	/*
	 * Declaration of reference variables for Doctor, Patient & OurDate classes.
	 */
	private Doctor doctor;
	private Patient patient;
	private OurDate appointmentDate;
	
	/*
	 * Default constructor.
	 */
	public Appointment () {
		this(new Patient(),new Doctor(),new OurDate());
	}
	/*
	 * Initial constructor
	 */
	public Appointment (Patient patient,Doctor doctor, OurDate appointmentDate) {
		setPatient(patient);
		setDoctor(doctor);
		setAppointmentDate(appointmentDate);
	}
	
	/*
	 * Get Doctor method, return doctor.
	 */
	public Doctor getDoctor() {
		return doctor;
	}
	/*
	 * Set Doctor method.
	 */
	private void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	/*
	 * Get Patient method, return patient.
	 */
	public Patient getPatient() {
		return patient;
	}
	/*
	 * Set Patient method.
	 */
	private void setPatient(Patient patient) {
		this.patient = patient;
	}

	/*
	 * Get Appointment Date method, return appointmentDate.
	 */
	public OurDate getAppointmentDate() {
		return appointmentDate;
	}
	/*
	 * Set Appointment Date method.
	 */
	private void setAppointmentDate (OurDate aDate) {
		this.appointmentDate = aDate;
		Calendar current = Calendar.getInstance();
		Calendar xDate = Calendar.getInstance();
		current.set(current.get(Calendar.YEAR), current.get(Calendar.MONTH)+1, current.get(Calendar.DATE));
		xDate.set(aDate.getYear(), aDate.getMonth(), aDate.getDay());
		if (current.compareTo(xDate)==1) throw new MedicalClinicException("Appointment Date Cannot be in the past\n");
		if (current.equals(xDate) ) throw new MedicalClinicException("Appointment Date Cannot be today\n");
	}

	@Override
	public String toString() {
		return "Appointemnt date: " + appointmentDate+ ", Dr. "+ doctor + ", " + patient;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appointmentDate == null) ? 0 : appointmentDate.hashCode());
		result = prime * result + ((doctor == null) ? 0 : doctor.hashCode());
		result = prime * result + ((patient == null) ? 0 : patient.hashCode());
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
		Appointment other = (Appointment) obj;
		if (appointmentDate == null) {
			if (other.appointmentDate != null)
				return false;
		} else if (!appointmentDate.equals(other.appointmentDate))
			return false;
		if (doctor == null) {
			if (other.doctor != null)
				return false;
		} else if (!doctor.equals(other.doctor))
			return false;
		if (patient == null) {
			if (other.patient != null)
				return false;
		} else if (!patient.equals(other.patient))
			return false;
		return true;
	}
	
	
	
	
	

}
