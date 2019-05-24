package assign_2_;

/**
 * Appliance class holds information in form of Item with added
 * Appliance elements
 * @author Danielle Fernandez
 *
 */

public class Appliance extends Item {	
	
	
	private static final long serialVersionUID = 1L;
	private String brand;
	private String type;
	
	public void setBrand(String b) { brand = b; }
	public void setType(String t) { type = t; }
	
	public String getBrand() { return brand; }
	public String getType() { return type; }
	
	/**
	 * This method displays appliance info on one line in chart format
	 */
	@Override
	public void display() {
	    	System.out.printf("|%6s ", String.valueOf(idNumber));
		System.out.printf("|%13s |", name);
		System.out.printf("%10s |", quantity);
		System.out.printf("%8.2f |", price);
		System.out.printf("%16s |", brand);
		System.out.printf("%16s |", type);
		System.out.println();
	}

}