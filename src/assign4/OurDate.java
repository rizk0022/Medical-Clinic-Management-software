/* File Name: OurDate.java
 * Course Name: Object Oriented Programming 
 * Lab Section: 18F_CST8284
 * Student Name: Youssef Rizk
 * Date: Nov 28, 2018
 */

package assign4;

import java.io.Serializable;
import java.util.Calendar;


/*
 * Represents a date to set and get the birthday, the appointment date and due date.
 */
public class OurDate implements Serializable{
	/*
	 * static final CALENDAR field declaration.
	 */
	private static final Calendar CALENDAR = Calendar.getInstance();

	/*
	 * fields day, month & year declaration.
	 */
	private int day;
	private int month;
	private int year;

	/*
	 * default constructor.
	 */
	public OurDate() {
		this(CALENDAR.get(Calendar.DATE), CALENDAR.get(Calendar.MONTH)+1, CALENDAR.get(Calendar.YEAR));

	}
	/*
	 * initial constructor.
	 */
	public OurDate(int day, int month, int year) {
		setYear(year);
		setMonth(month);
		setDay(day);

	}

	/*
	 * get day method return day.
	 */
	public int getDay() {
		return day;
	}
	/*
	 * set day method.
	 */
	private void setDay(int day) {
		this.day = day;
		if (getMonth()==02 && (((getYear() % 4 != 0) || (getYear() % 100 == 0)) && (getYear() % 400 != 0)) && (day>28||day<1)) 
			throw new MedicalClinicException(getYear() +" is not a leap year, February must be between 1 - 28");
		if (getMonth()==02 && (((getYear() % 4 == 0) && (getYear() % 100 != 0)) || (getYear() % 400 == 0)) && (day>29||day<1)) 
			throw new MedicalClinicException(getYear() +" is a leap year, February must be between 1 - 29");
		if ((getMonth()==01 || getMonth()==03 || getMonth()==05 || getMonth()==07 || getMonth()==8 || getMonth()==10 || getMonth()==12) 
				&& (day>31||day<1)) 
			throw new MedicalClinicException("This month is 31 days, day must be between 1 - 31");
		if ((getMonth()==04 || getMonth()==06 || getMonth()==9 || getMonth()==11) 
				&& (day>30||day<1)) 
			throw new MedicalClinicException("This month is 30 days, day must be between 1 - 30");
	}
	/*
	 * get month method return month.
	 */
	public int getMonth() {
		return month;
	}
	/*
	 * set month method.
	 */
	private void setMonth(int month) {
		this.month = month;
		if (month <1 || month >12) throw new MedicalClinicException("Month should be 1 - 12");
	}

	/*
	 * get year method return year.
	 */
	public int getYear() {
		return year;
	}
	/*
	 * set year method.
	 */
	private void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return (day + "/"+ month + "/"+ year);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + month;
		result = prime * result + year;
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
		OurDate other = (OurDate) obj;
		if (day != other.day)
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}


}
