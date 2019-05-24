package assign_2_;

/**
 * Sales class holds all information on all Sales
 * @author Danielle Fernandez
 */

import java.io.Serializable;
import java.util.Date;

public class Sales implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String itemId;
	private Date saleDate = new Date();
	private int quantity;
	private int customerId;
	private int employeeId;	
	
	
	public void setItemId(String i) { itemId = i; }
	public void setQuantity(int q) { quantity = q; }
	public void setCustomerId(int c) { customerId = c; }
	public void setEmployeeId(int e) { employeeId = e; }
	public String getItemId() { return itemId; }
	public int getQuantity() { return quantity; }
	public int getCustomerId() { return customerId; }
	public int getEmployeeId() { return employeeId; }
	
	/**
	 * This method displays information of Sales in one line
	 * in chart format
	 */
	void display(){
		System.out.printf("|%8s ", itemId);
		System.out.printf("|%14s |", quantity);
		System.out.printf("%12s |", customerId);
		System.out.printf("%13s |", employeeId);
		System.out.printf("%18s |", saleDate.toString());
		System.out.println();
	}
	
}

