package assign_2_;

/**
 * Customer holds information in form of user with added Customer elements
 * @author Danielle Fernandez
 *
 */

public class Customer extends User{
	
	private static final long serialVersionUID = 1L;
	private String phoneNum;
	private String address; 
	
	public void setPhoneNum(String p) { phoneNum = p; }
	public void setAddress(String a) { address = a; }
	public String getPhoneNum() {return phoneNum; }
	public String getAddress() {return address; }
	
	/**
	 * This method displays information of Customer in one line
	 * in chart format
	 */
	@Override
	public void display() {
		System.out.printf("|%6s ", id);
		System.out.printf("|%13s |", firstName);
		System.out.printf("%13s |", lastName);
		System.out.printf("%15s |", phoneNum);
		System.out.printf("%23s |%n", address);
	}

}