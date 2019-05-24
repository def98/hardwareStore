package assign_2_;

/**
 * Item class holds information for every type of item
 * and is a type of item in itself.
 * @author Danielle Fernandez
 *
 */

import java.io.Serializable;

public class Item implements Serializable{
		
	private static final long serialVersionUID = 1L;
	protected int idLength = 5;
    protected char[] idNumber = new char[idLength];
    protected String name;
    protected int quantity;
    protected float price;
    
    
    public void setIdNumber(char[] i) { idNumber = i; }
    public void setName(String n) { name = n; }
    public void setQuantity(int q) { quantity = q; }
    public void setPrice(float p) { price = p; }
    public char[] getIdNumber() { return idNumber; }
    public String getName() { return name; }   
    public int getQuantity() { return quantity; }
    public float getPrice() { return price; }
    
    /**
	 * This method displays item info on one line in chart format
	 */
    public void display() {
    		System.out.printf("|%6s ", String.valueOf(idNumber));
		System.out.printf("|%13s |", name);
		System.out.printf("%10s |", quantity);
		System.out.printf("%8.2f |", price);
		System.out.printf("%16s |", " ");
		System.out.printf("%16s |", " ");
		System.out.println();
    }


}

