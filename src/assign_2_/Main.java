package assign_2_;

/**
* The Hardware program implements an application that
* allows easy updating and tracks records of stock, users,
* and sales.
*
* @author Danielle Fernandez
*/
import java.io.*;
import java.util.*;

public class Main {

	/**
	* This is the main method which makes use of the HardwareDriver Class.
	* @param args Unused.
	* @exception IOException for HardwareDriver
	* @see IOException
	*/
	public static void main(String[] args) throws IOException{
		
		Scanner in = new Scanner(System.in);
		HardwareDriver hardware = new HardwareDriver();
		
		String itemId, itemName;
		int input, index;
		
		do {
			System.out.println("1. Show all existing items in stock and their quantities.");
			System.out.println("2. Add new item (or quantity) to the database.");
			System.out.println("3. Delete an item from a database.");
			System.out.println("4. Search for an item given its name.");
			System.out.println("5. Show a list of users in the database.");
			System.out.println("6. Add new user to the database.");
			System.out.println("7. Update user info (given their id).");
			System.out.println("8. Complete a sale transaction.");
			System.out.println("9. Show completed sale transactions.");
			System.out.println("10. Exit program");
			System.out.println("Select an option: ");
			 
			input = in.nextInt();
			in.nextLine();
			 
			switch(input) {
			case 1:
				hardware.displayItems();
				break;
			case 2:
				System.out.println("Please enter ID of item to add: ");
				itemId = in.nextLine();
				
				while(itemId.length() != 5) {
					System.out.println("Please enter a 5 character itemId");
					itemId = in.nextLine();
				}
				
				index = hardware.checkItemExistence(itemId);
				if (index == -1) {
					System.out.println("Item does not exist.");
					hardware.addItem(itemId);
				}
				else
					hardware.addQuantity(index);
				break;
			case 3: 
				System.out.println("Please enter ID of item to remove: ");
				itemId = in.nextLine();
				
				while(itemId.length() != 5) {
					System.out.println("Please enter a 5 character itemId");
					itemId = in.nextLine();
				}
				
				index = hardware.checkItemExistence(itemId);
				if (index == -1)
					System.out.println("Item does not exit and therefore cannot be removed");
				else
					hardware.deleteItem(index);
				break;
			case 4:
				System.out.println("Enter an item's name or part of it's name");
				itemName = in.nextLine();
				hardware.searchName(itemName);
				break;
			case 5:
				hardware.displayUsers();
				break;
			case 6:
				System.out.println("Please enter ID of user to add: ");
				itemId = in.nextLine();
				index = hardware.checkUserExistence(itemId);
				if (index == -1) 
					hardware.addNewUser(itemId);
				else
					System.out.println("User already exists.");
				break;
			case 7: 
				System.out.println("Please enter ID of user to update: ");
				itemId = in.nextLine();
				index = hardware.checkUserExistence(itemId);
				if (index == -1) 
					System.out.println("User does not exist. Add user first.");
				else
					hardware.updateUser(index);
				break;
			case 8:
				System.out.println("Please enter Id of item being sold: ");
				itemId = in.nextLine();
				
				while(itemId.length() != 5) {
					System.out.println("Please enter a 5 character itemId");
					itemId = in.nextLine();
				}
				
				index = hardware.checkItemExistence(itemId);
				if (index == -1)
					System.out.println("Item does not exist.");
				else
					hardware.completeSale(itemId, index);
				break;
			case 9:
				hardware.displaySales();
				break;
			case 10:
				System.out.println("Saving data...");
				hardware.exitToFile();
				System.out.println("Successfully saved. Goodbye.");
				break;
			}
		}while (input != 10);
		in.close();
	}
}
