/* File Name: MedicalClinicInterface.java
 * Course Name: Object Oriented Programming 
 * Lab Section: 18F_CST8284
 * Student Name: Youssef Rizk
 * Date: Nov 28, 2018
 */
package assign4;

import java.util.Scanner;


/*
 * Represents a MedicalClinic interface for all user interaction with the program and keep track of
 * appointments between doctors and patients.
 */
public class MedicalClinicUserInterface {
	/*
	 * Static final constant variables declarations 
	 */
	private static final int ADD_PATIENT=1;
	private static final int ADD_APPOINTMENT=2;
	private static final int CANCEL_APPOINTMENT=3;
	private static final int LIST_APPOINTMENTS=4;
	private static final int WRITE_TO_FILE=5;
	private static final int LOAD_FROM_FILE=6;
	private static final int QUIT=7;
	/*
	 * Declaration of reference variable of MedicalClinic class
	 */
	private MedicalClinic clinic;
	/*
	 * Scanner class variable declaration for user interaction
	 */
	private Scanner in;
	/*
	 * default constructor
	 */
	public MedicalClinicUserInterface() {
		clinic=new MedicalClinic();
		in= new Scanner(System.in);
	}
	
	/*
	 * main method that initializing an object of this class MedicalClinicInterface and call menu method
	 */
	public static void main(String[] args) {
		MedicalClinicUserInterface example = new MedicalClinicUserInterface();
		example.menu();
	}

	/*
	 * menu method that has the menu list and deal with user choices
	 */
	public void menu () {
		int choice;
		do {
			System.out.println("Please make a choice:");
			System.out.println("1 Enter a new patient");
			System.out.println("2 Make an appointment for a patient");
			System.out.println("3 Cancel an appointment for a patient");
			System.out.println("4 List all appointments");
			System.out.println("5 Write Patient data to file");
			System.out.println("6 Load Patient data");
			System.out.println("7 Quit");
			choice=in.nextInt();
			switch (choice) {
			case ADD_PATIENT:
				addPatient();
				break; 
			case ADD_APPOINTMENT:
				addAppointment();
				break;
			case CANCEL_APPOINTMENT:
				cancelAppointment();
				break;
			case LIST_APPOINTMENTS: 
				listAppointment();
				break;
			case WRITE_TO_FILE: 
				writePatientsOut();
				break;
			case LOAD_FROM_FILE: 
				readPatientsIn();
				break;
			case 9:
				printPatients();
				break;
			case QUIT:
				System.out.println("Goodbye");
			}
		} while (choice !=QUIT);
	}

	/*
	 * writePatientsOut method that invoke filePatientsOut method from MedicalClinic class to write patients data to PatientData.ser file
	 */
	public void writePatientsOut() {
		clinic.filePatientsOut();
		
	}
	/*
	 * readPatientsIn method that invoke filePatientsIn method from MedicalClinic class to load patients data from PatientData.ser file and load them into patients ArrayList
	 */
	public void readPatientsIn() {
		clinic.filePatientsIn();
	}
	
	/*
	 * theDate method that passes the input String date and returns new OurDate object.
	 */
	public OurDate theDate(String date) {

		int day = Integer.parseInt(date.substring(0,2));
		int month = Integer.parseInt(date.substring(2,4));
		int year = Integer.parseInt(date.substring(4,8));
		return new OurDate (day,month,year);
	}

	/*
	 * addPatient method to insert and save new patient details in the system.
	 */
	public void addPatient() {
		System.out.print("Enter first name: ");
		String f = in.next();
		System.out.print("Enter last name: ");
		String l = in.next();
		boolean goodData=false; 
		String hcn;
		do {
			System.out.print("\nEnter Health Card Number: ");
			hcn = in.next();
			try { new HealthCard(hcn);
			goodData=true;
			}
			catch (MedicalClinicException e)
			{
				System.out.println(e.getMessage());
			}
		} while (!goodData);

		goodData=false; 
		String date;
		do {
			System.out.print("\nEnter birth date DDMMYYYY:");
			date = in.next();
			try { theDate(date);
		System.out.println("Enter the type of patient: ");
		System.out.println("1.  Maternity Patient ");
		System.out.println("2.  OutPatient ");
		System.out.println("3.  Regular Patient ");
		int patientType=in.nextInt();
		switch (patientType) {
		case 1: 
			goodData=false; 
			String dDate;
			do {
				System.out.print("Enter the due date DDMMYYYY: ");
				dDate= in.next();
				try { theDate(dDate);
				
			System.out.println("Enter Nutrition testing \nEnter 1 for true\nEnter 2 for false");
			int nt = in.nextInt();
			boolean nutritionTesting =false;
			if (nt == 1) nutritionTesting = true;
			if (nt==2) nutritionTesting = false;
			while (nt != 1 && nt != 2 ) 
			{
				System.out.println("Invalid Nutrition Testing \n");
				return;
			}
				
			clinic.addPatient(f, l, new HealthCard(hcn), theDate(date), theDate(dDate), nutritionTesting);
			goodData=true;
				}
				catch (MedicalClinicException e)
				{
					System.out.println(e.getMessage());
				}
			} while (!goodData);
			break;
		case 2:
			System.out.println("Patient's mobility is available? \nEnter 1 for true\nEnter 2 for false");
			int mb = in.nextInt();
			boolean mobility=false;
			if (mb == 1) mobility = true;
			if (mb==2) mobility = false;
			while (mb != 1 && mb != 2 ) 
			{
				System.out.println("Invalid mobility \n");
				return;
			}
			System.out.println("What is the distance from clinic [KM]?");
			double dist = in.nextDouble();
			clinic.addPatient(f, l, new HealthCard(hcn), theDate(date), mobility, dist);

			break;
		case 3:
			clinic.addPatient(f, l, new HealthCard(hcn), theDate(date));

			break;
		default: 
			System.out.println("Wrong patient type\n");
			return;
		}
		goodData=true;
			}
			catch (MedicalClinicException e)
			{
				System.out.println(e.getMessage());
			}
		} while (!goodData);

	}

	/*
	 * addAppointment method to insert and save new appointment details in the system
	 */
	public void addAppointment() {
		boolean goodData=false; 
		String hcn;
		do {
			System.out.print("Enter Health Card Number: ");
			hcn = in.next();
			try { new HealthCard(hcn);
			goodData=true;
			}
			catch (MedicalClinicException e)
			{
				System.out.println(e.getMessage());
			}
		} while (!goodData);
		int patientIndex=0;
		boolean check = false;
		for (Patient p : clinic.getPatients()) {
			if (p.getHealthCardNumber().equals(new HealthCard(hcn))) {
				check = true;
				System.out.println(p.toString()+"\n");
				patientIndex=clinic.getPatients().indexOf(p);
			}
		}
		if  (!check) {System.out.println("Patient not in clinic database - first add patient to database before an appointment is made\n");
		return;
		}
		printDoctors();
		System.out.print("Enter number for doctor selection:");
		int doctorChoice=in.nextInt();
		if (doctorChoice>clinic.getMaxDoctors()) 
		{
			System.out.println("Invalid Doctor selection\n");
			return;
		}
		goodData=false; 
		String date;
		do {
			System.out.print("Enter desired appointment date DDMMYYYY: ");
			date= in.next();
			try { theDate(date);
			
			
			
		
		for (int i=0; i<clinic.getAppointments().size() ; i++) {
			if (clinic.getAppointments().get(i).getPatient().getHealthCardNumber().equals(new HealthCard(hcn)))
			{
				System.out.println("Patient already has an appointment");
				System.out.println();
				return;
			}
			if ((clinic.getAppointments().get(i).getDoctor().getFirstName() ==clinic.getDoctors().get(doctorChoice-1).getFirstName()&&
					clinic.getAppointments().get(i).getAppointmentDate().equals(theDate(date))))
			{
				System.out.println("Doctor already has an appointment that day");
				System.out.println();
				return;
			}
		}	
		clinic.addAppointment(clinic.getPatients().get(patientIndex),clinic.getDoctors().get(doctorChoice-1),theDate(date));
		System.out.println();
		goodData=true;
			}
		catch (MedicalClinicException e)
		{
			System.out.println(e.getMessage());
		}
		} while (!goodData);
	}

	/*
	 * cancelAppointment method to cancel an existing appointment in the system.
	 */
	public void cancelAppointment() {
		if (clinic.getAppointments().size()==0)	{
			System.out.println("\nThere is no Appointment in the system\n");
			return;
		}
		boolean goodData=false; 
		String hcn;
		do {
			System.out.print("Enter Health Card Number: ");
			hcn = in.next();
			try { new HealthCard(hcn);
			goodData=true;
			}
			catch (MedicalClinicException e)
			{
				System.out.println(e.getMessage());
			}
		} while (!goodData);
		boolean checkHcn = false;
		boolean checkDoctor = false;
		boolean checkAppDate = false;
		for (Appointment p : clinic.getAppointments()) {
			if (p.getPatient().getHealthCardNumber().equals(new HealthCard(hcn))) {
				checkHcn = true;
				System.out.println(p.getPatient().toString()+"\n");

				printDoctors();
				System.out.print("Enter number for doctor selection:");
				int doctorChoice=in.nextInt();

				for (Appointment a : clinic.getAppointments()) {
					if (a.getDoctor().equals(clinic.getDoctors().get(doctorChoice-1))) {
						checkDoctor = true;
						goodData=false; 
						String date;
						do {
							System.out.print("Enter appointment date DDMMYYYY: ");
							date= in.next();
							try { theDate(date);
							goodData=true;
							}
							catch (MedicalClinicException e)
							{
								System.out.println(e.getMessage());
							}
						} while (!goodData);
						for (Appointment d : clinic.getAppointments()) {
							if (d.getAppointmentDate().equals(theDate(date))) {
								checkAppDate=true;	
								if (checkHcn==true && checkDoctor == true && checkAppDate == true) {	
									int index = clinic.getAppointments().indexOf(new Appointment(p.getPatient(),a.getDoctor(),d.getAppointmentDate()));
									clinic.cancelAppointment(index);
									System.out.println("\nAppointment Cancelled \n");
									return;
								}
							}
						}
					}
				}
			}
		}
		if (checkHcn==false || checkDoctor == false || checkAppDate == false) {
			System.out.println("\nThis Appointment is not exist\n");
			return;
		}
	}

	/*
	 * listAppointment method to print a list of all saved appointments in the system.
	 */
	public void listAppointment() {
		for (int i =0; i<clinic.getAppointments().size();i++) {
			System.out.println(i+1+"-  " + clinic.getAppointments().get(i).toString());
		}
		System.out.println();
		if (clinic.getAppointments().size()==0)
			System.out.println("There is no Appointment in the system\n");
		return;
	}

	/*
	 * printDoctors method to print the list of all doctors in the system.
	 */
	public void printDoctors() {
		for (int i=0;i<clinic.getDoctors().size();i++) {
			System.out.println(i+1+"  " + clinic.getDoctors().get(i).toString());
		}
	}

	/*
	 * printPatients method to print the list of all saved patients in the system.
	 */
	public void printPatients() {
		for (Patient p : clinic.getPatients()) {
			if (p.equals((new MaternityPatient()))) {
				System.out.println(new MaternityPatient().toString());
			}
			if (p.equals((new OutPatient()))) {
				System.out.println(new OutPatient().toString());
			}
			System.out.println(p.toString());
		}
		System.out.println();
	}
}
