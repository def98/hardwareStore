package assign_2_;

/**
 * Employee holds information in form of user with added Employee elements
 * @author Danielle Fernandez
 *
 */

public class Employee extends User {
	
	private static final long serialVersionUID = 1L;
	private int social;
	private float monthlySalary;
	
	public void setSocial(int s) { social = s; }
	public void setMonthlySalary(float m) { monthlySalary = m;}
	public int getSocial() {return social; }
	public float getMonthlySalary() { return monthlySalary; }
	
	/**
	 * This method displays information of Employee in one line
	 * in chart format
	 */
	@Override
	public void display() {
		System.out.printf("|%6s ", id);
		System.out.printf("|%13s |", firstName);
		System.out.printf("%13s |", lastName);
		System.out.printf("%15s |", social);
		System.out.printf("%23.2f |%n", monthlySalary);
	}
	
}