package assign_2_;

/**
 * SmallItem class holds small items in form of items with
 * added SmallItem elements
 * @author Danielle Fernandez
 *
 */

public class SmallItem extends Item{	
	
	private static final long serialVersionUID = 1L;
	private String category;
	
	public void setCategory(String c) { category = c; }
	public String getCategory() { return category; }
	
	/**
	 * This method displays information of SmallItem in one line
	 * in chart format
	 */
	@Override
	public void display() {
    		System.out.printf("|%6s ", String.valueOf(idNumber));
		System.out.printf("|%13s |", name);
		System.out.printf("%10s |", quantity);
		System.out.printf("%8.2f |", price);
		System.out.printf("%16s |", category);
		System.out.printf("%16s |", " ");
		System.out.println();
	}
}