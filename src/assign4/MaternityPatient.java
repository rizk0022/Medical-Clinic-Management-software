/* File Name: MaternityPatient.java
 * Course Name: Object Oriented Programming 
 * Lab Section: 18F_CST8284
 * Student Name: Youssef Rizk
 * Date: Nov 28, 2018
 */
package assign4;

import java.io.Serializable;
import java.util.Calendar;

/*
 * subclass of Patient class. Represents a maternity patient that store the details of the patient.
 */
public class MaternityPatient extends Patient implements Serializable{
	/*
	 * reference variable of OurDate declaration.
	 */
	private OurDate dueDate;
	/*
	 * nutritionTesting field declaration.
	 */
	private boolean nutritionTesting=false;

	/*
	 * default constructor, with the default birthdate to be the day before current date and the default due date to be the day after current date.
	 */
	public MaternityPatient () {
		this("unknown","unknown",new HealthCard(),new OurDate(new OurDate().getDay()-1,new OurDate().getMonth(),new OurDate().getYear()),
				new OurDate(new OurDate().getDay()+1,new OurDate().getMonth()+1,new OurDate().getYear()),false);

	}
	/*
	 * Initial constructor .
	 */
	public MaternityPatient (String firstName, String lastName, HealthCard healthCardNumber, OurDate birthDate,OurDate dueDate, boolean nutritionTesting) {
		super(firstName,lastName,healthCardNumber,birthDate);
		setDueDate(dueDate);
		setNutritionTesting(nutritionTesting);
	}
	/*
	 * get Due Date method.
	 */
	public OurDate getDueDate() {
		return dueDate;
	}
	/*
	 * set Due Date method.
	 */
	private void setDueDate(OurDate dueDate) {
		this.dueDate = dueDate;
		Calendar current = Calendar.getInstance();
		Calendar xDate = Calendar.getInstance();
		current.set(current.get(Calendar.YEAR), current.get(Calendar.MONTH)+1, current.get(Calendar.DATE));
		xDate.set(dueDate.getYear(), dueDate.getMonth(), dueDate.getDay());
		if (current.compareTo(xDate)==1) throw new MedicalClinicException("Due Date should be in the future\n");
		if (current.equals(xDate)) throw new MedicalClinicException("Due Date cannot be today\n");
	}

	/*
	 * get Nutrition Testing method.
	 */
	public boolean isNutritionTesting() {
		return nutritionTesting;
	}

	/*
	 * set nutrition testing method.
	 */
	private void setNutritionTesting(boolean nutritionTesting) {
		this.nutritionTesting = nutritionTesting;
	}

	@Override
	public String toString() {
		return "MaternityPatient [firstName=" + super.getFirstName() + ", lastName=" + super.getLastName() + ", healthCardNumber=" + super.getHealthCardNumber() + 
											 ", birthDate=" + super.getBirthDate() +"dueDate=" + dueDate + ", nutritionTesting=" + nutritionTesting + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
		result = prime * result + (nutritionTesting ? 1231 : 1237);
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
		MaternityPatient other = (MaternityPatient) obj;
		if (dueDate == null) {
			if (other.dueDate != null)
				return false;
		} else if (!dueDate.equals(other.dueDate))
			return false;
		if (nutritionTesting != other.nutritionTesting)
			return false;
		return true;
	}

}
