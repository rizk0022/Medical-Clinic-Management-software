/* File Name: MedicalClinic.java
 * Course Name: Object Oriented Programming 
 * Lab Section: 18F_CST8284
 * Student Name: Youssef Rizk
 * Date: Nov 28, 2018
 */
package assign4;
import java.awt.List;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/*
 * Represents a MedicalClinic to keep track of
 * appointments between doctors and patients.
 */
public class MedicalClinic implements Serializable{
	/*
	 * array lists appointments, patients & doctors declarations.
	 */
	private ArrayList<Appointment> appointments;
	private ArrayList<Patient> patients;
	private ArrayList<Doctor> doctors;
	/*
	 * static fields numberAppointments, numberPatients, numberDoctors declarations.
	 */
	private static int numberAppointments;
	private static int numberPatients;
	private static int numberDoctors;
	/*
	 * final constant fields MAX_APPOINTMENTS, MAX_PATIENTS, MAX_DOCTORS declarations.
	 */
	private final int MAX_APPOINTMENTS=5;
	private final int MAX_PATIENTS=5000;
	private final int MAX_DOCTORS=5;

	/*
	 * default constructor. initializing ArrayLists & add pre-existed doctors and patients elements to their ArrayList.
	 */
	public MedicalClinic () {
		appointments= new ArrayList<>(MAX_APPOINTMENTS);
		patients=new ArrayList<>(MAX_PATIENTS);
		doctors=new ArrayList<>(MAX_DOCTORS);

		doctors.add(0, new Doctor("Singh","Vikash","endocrinologist"));
		doctors.add(1, new Doctor("Miller","Susan","cardiologist"));
		doctors.add(2, new Doctor("Do","Thanh","neurologist"));
		doctors.add(3, new Doctor("DaSilva","Francois","internist"));
		doctors.add(4, new Doctor("Chin","Judy","Family Physician"));
//		patients.add(0, new Patient("Brolin","Josh",new HealthCard("123456789"), new OurDate (12,04,1987)));
//		patients.add(1, new Patient("Dunstd","Brack",new HealthCard("222222222"), new OurDate (12,12,2007)));
	}
	
	/*
	 * filePatientsOut method to write patients data to PatientData.ser file
	 */
	public void filePatientsOut() {
		try{
            FileOutputStream writeData = new FileOutputStream("C:\\Users\\Youssef Rizk\\Desktop\\PatientData.ser");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(patients);
            writeStream.flush();
            writeStream.close();
            System.out.println("Writing Patients data to PatientData.ser file is DONE\n");
        }catch (IOException e) {
            e.printStackTrace();
        }
	}
	/*
	 * filePatientsIn method to load patients data from PatientData.ser file and load them into patients ArrayList
	 */
	public void filePatientsIn() {
		try{
	            FileInputStream readData = new FileInputStream("C:\\Users\\Youssef Rizk\\Desktop\\PatientData.ser");
	            ObjectInputStream readStream = new ObjectInputStream(readData);

	             patients = (ArrayList<Patient>) readStream.readObject();
	            readStream.close();
	            
	            System.out.println("null END OF FILE REACHED\n");
	        }catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	}
	
	/*
	 * addPatient method, to add a regular patient to system.
	 */
	public void addPatient(String firstName, String lastName, HealthCard healthCardNumber, OurDate date) {
		for (Patient p : patients ){
			if (p.getHealthCardNumber().equals(healthCardNumber)) {
				System.out.println(firstName + " "+lastName + " is already in the system\n");
				return;
			}
		}
		if (patients.size()>=getMaxPatients()) {
			System.out.println("Cannot add this patient, Max Number of Patients reached\n");
		}
		else if (  patients.size()<getMaxPatients()) {
			patients.add(new Patient( firstName,  lastName,  healthCardNumber, date));
			System.out.println("patient "+ firstName +  " "+lastName + " was added\n");
		}
	}


	/*
	 * addPatient method, to initialize fields of subclass OutPatient and add OutPatient to system
	 */
	public void addPatient(String firstName, String lastName, HealthCard healthCardNumber, OurDate date, boolean mobility, double distance) {
		for (Patient p : patients ){
			if (p.getHealthCardNumber().equals(healthCardNumber)) {
				System.out.println(firstName + " "+lastName + " is already in the system\n");
				return;
			}
		}
		if (patients.size()>=getMaxPatients()) {
			System.out.println("Cannot add this patient, Max Number of Patients reached\n");
		}
		else if (  patients.size()<getMaxPatients() ) {
			patients.add(new OutPatient(firstName,lastName,healthCardNumber,date,distance,mobility));
			System.out.println("patient "+ firstName +  " "+lastName + " was added\n");
		}
	}


	/*
	 * addPatient method, to initialize fields of subclass MaternityPatient and add MaternityPatient to system
	 */
	public void addPatient(String firstName, String lastName, HealthCard healthCardNumber, OurDate date, OurDate dueDate, boolean nutritionTesting) {
		for (Patient p : patients ){
			if (p.getHealthCardNumber().equals(healthCardNumber)) {
				System.out.println(firstName + " "+lastName + " is already in the system\n");
				return;
			}
		}

		if (patients.size()>=getMaxPatients()) {
			System.out.println("Cannot add this patient, Max Number of Patients reached\n");
		}
		else if (  patients.size()<getMaxPatients()) {
			patients.add(new MaternityPatient(firstName,lastName,healthCardNumber,date,dueDate,nutritionTesting));
			System.out.println("patient "+ firstName +  " "+lastName + " was added\n");
		}
	}


	/*
	 * addAppointment method to add appointment to the system.
	 */
	public void addAppointment(Patient patient, Doctor doctor, OurDate date) {

		appointments.add(new Appointment(patient,doctor,date));
	}
	/*
	 * cancelAppointment method to cancel appointment from system.
	 */
	public void cancelAppointment(int index) {
		appointments.remove(index);
	}
	/*
	 * getAppointments method return appointment ArrayList.
	 */
	public ArrayList<Appointment> getAppointments() {
		return appointments;
	}
	/*
	 * getPatients method return patients ArrayList.
	 */
	public ArrayList<Patient> getPatients() {
		return patients;
	}
	/*
	 * getDoctors method return doctors ArrayList.
	 */
	public ArrayList<Doctor> getDoctors() {
		return doctors;
	}
	/*
	 * getNumberAppointments method return numberAppointment.
	 */
	public static int getNumberAppointments() {
		return numberAppointments;
	}
	/*
	 * getNumberPatients method return numberPatients.
	 */
	public static int getNumberPatients() {
		return numberPatients;
	}
	/*
	 * getNumberDoctors method return numberDoctors.
	 */
	public static int getNumberDoctors() {
		return numberDoctors;
	}
	/*
	 * getMaxAppointments method return constant MAX_APPOINTMENTS.
	 */
	public int getMaxAppointments() {
		return MAX_APPOINTMENTS;
	}
	/*
	 * getMaxPatients method return constant MAX_PATIENTS.
	 */
	public int getMaxPatients() {
		return MAX_PATIENTS;
	}
	/*
	 * getMaxDoctors method return constant MAX_DOCTORS.
	 */
	public int getMaxDoctors() {
		return MAX_DOCTORS;
	}

}


