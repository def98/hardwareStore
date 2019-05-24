package assign_2_;

/**
 * User class holds information for every type of User, but
 * is not a type of User in itself.
 * @author Danielle Fernandez
 */

import java.io.Serializable;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	protected int id;
	protected String firstName;
	protected String lastName;
	
	public void setIdNumber(int i) { id = i; }
	public void setFirstName(String fn) { firstName = fn; }
	public void setLastName(String ln) { lastName = ln; }
	public int getIdNumber() { return id; }
	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	
	/**
	 * This method displays User info on one line in chart format
	 */
	public void display() {
		System.out.printf("|%6s ", id);
		System.out.printf("|%13s |", firstName);
		System.out.printf("%13s |", lastName);
	}
}