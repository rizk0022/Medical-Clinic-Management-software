/* File Name: MedicalClinicException.java
 * Course Name: Object Oriented Programming 
 * Lab Section: 18F_CST8284
 * Student Name: Youssef Rizk
 * Date: Nov 28, 2018
 */
package assign4;
/*
 * A class inherited from the API class RuntimeException. Code throw a MedicalClinicException instead of a RuntimeException
 */

import java.io.Serializable;

public class MedicalClinicException extends RuntimeException implements Serializable{
/*
 * Initial constructor of MedicalClinicException class
 */
	public MedicalClinicException (String message) {
		super(message);
	}
/*
 * Default constructor of MedicalClinicException class
 */
	public MedicalClinicException () {
		super();
	}
}
