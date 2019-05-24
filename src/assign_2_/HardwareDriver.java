package assign_2_;

/**
 * This class implements all classes to be the driver for Main function
 * @author Danielle Fernandez
 *
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class HardwareDriver {
	
	private ArrayList<Item> itemList = new ArrayList<Item>();
	private ArrayList<User> userList = new ArrayList<User>();
	private ArrayList<Sales> salesList = new ArrayList<Sales>();
	Scanner in = new Scanner(System.in);
		
	@SuppressWarnings("unchecked")
	
	/**
	 * Class constructor imports serialized ArrayLists from file
	 * @throws IOException if files has issues
	 */
	HardwareDriver() throws IOException{
		InputStream inFile = null, buff = null;
		ObjectInput inObj = null;
		
		File f = new File("Hardware.ser");
		try {
			if(!f.exists()) {
				return;
			}
			inFile = new FileInputStream(f);
			buff = new BufferedInputStream(inFile);
			inObj = new ObjectInputStream(buff);
			
			itemList = (ArrayList<Item>)inObj.readObject();
			userList = (ArrayList<User>)inObj.readObject();
			salesList = (ArrayList<Sales>)inObj.readObject();
			
			inFile.close();
			inObj.close();
			buff.close();
			
		}catch(Exception e) {
			System.out.println("File currently empty");
		}
	}
	
	/**
	 * This method is used to display all Items in itemList
	 */
	void displayItems() {
		System.out.println("--------------------------------------" +
				"--------------------------------------------");
		System.out.println("|  ID # |         NAME |  QUANTITY |" 
				+ "  PRICE  |  BRAND/CATEGORY |            TYPE |");
		System.out.println("--------------------------------------" +
				"--------------------------------------------");
		for (int i = 0; i < itemList.size(); i++)
			itemList.get(i).display();
		System.out.println("--------------------------------------" +
				"--------------------------------------------");
	}
	/**
	 * This method checks if an Item exists based on given id
	 * @param id is idNumber of Item †o look for
	 * @return index of existing Item or -1 if non exists
	 */
	int checkItemExistence(String id) { 
		int itemMatchIndex = -1; //index assigned if item is found
		
		while(id.length() != 5) {
			System.out.println("Please enter a 5 character itemId");
			id = in.nextLine();
		}
			 
		for (int i = 0; i < itemList.size(); i++){
			if (id.equals(String.valueOf(itemList.get(i).getIdNumber())))
				itemMatchIndex = i;
		}
		return itemMatchIndex;
	}
	/**
	 * This method allows user to enter information of an Item and
	 * add to itemList
	 * @param id idNumber of non-existing item
	 */
	void addItem(String id) {
		int input;
		
		System.out.println("What kind of item would you like to add?");
		System.out.println("1. Appliance");
		System.out.println("2. Small Hardware");
		System.out.println("3. Other");
		
		input = in.nextInt();
		while (input < 1 || input > 3) {
			System.out.println("Please enter a valid choice.");
			input = in.nextInt();
			
		}
		switch(input) {
		case 1: 
			Appliance newAppliance = new Appliance();
			in.nextLine();
			newAppliance.setIdNumber(id.toCharArray());
			System.out.println("What is the name of this item?");
			newAppliance.setName(in.nextLine());
			System.out.println("What is the quantity of this item?");
			newAppliance.setQuantity(in.nextInt());
			System.out.println("What is the price of this item?");
			newAppliance.setPrice(in.nextFloat());
			in.nextLine();
			System.out.println("What is the brand of this item?");
			newAppliance.setBrand(in.nextLine());
			System.out.println("What is the type of this item?");
			newAppliance.setType(in.nextLine());
			while (!(newAppliance.getType().equals("Refridgerators")) && 
					!(newAppliance.getType().equals("Washers&Dryers")) &&
					!(newAppliance.getType().equals("Ranges&Ovens")) &&
					!(newAppliance.getType().equals("Small Appliances"))){
					System.out.println("Enter a valid type: (Refridgerators, Washers&Dryers, Ranges&Ovens"
							+ "Small Appliances");
					newAppliance.setType(in.nextLine());
			}
			
			itemList.add(newAppliance);
			System.out.println("Item has been added.");
			System.out.println("--------------------------------------" +
					"--------------------------------------------");
			System.out.println("|  ID # |         NAME |  QUANTITY |"
					+ "  PRICE  |  BRAND/CATEGORY |            TYPE |");
			System.out.println("--------------------------------------" +
					"--------------------------------------------");
			newAppliance.display();
			System.out.println("--------------------------------------" +
					"--------------------------------------------");
			break;
		case 2: 
			SmallItem newSmallItem = new SmallItem();
			in.nextLine();
			
			newSmallItem.setIdNumber(id.toCharArray());
			System.out.println("What is the name of this item?");
			newSmallItem.setName(in.nextLine());
			System.out.println("What is the quantity of this item?");
			newSmallItem.setQuantity(in.nextInt());
			System.out.println("What is the price of this item?");
			newSmallItem.setPrice(in.nextFloat());
			in.nextLine();
			System.out.println("What is the category of this item?");
			newSmallItem.setCategory(in.nextLine());
			while (!(newSmallItem.getCategory().equals("Door&Window")) && 
					!(newSmallItem.getCategory().equals("Fasteners")) &&
					!(newSmallItem.getCategory().equals("Cabinet&Furniture")) &&
					!(newSmallItem.getCategory().equals("Structural")) &&
					!(newSmallItem.getCategory().equals("Other"))){
					System.out.println("Enter a valid category: (Door&Window, Fasteners, Cabinet&Furniture,"
							+ " Structural, Other)");
					newSmallItem.setCategory(in.nextLine());
			}
			
			itemList.add(newSmallItem);
			System.out.println("Item has been added.");
			System.out.println("--------------------------------------" +
					"--------------------------------------------");
			System.out.println("|  ID # |         NAME |  QUANTITY |" 
					+ "  PRICE  |  BRAND/CATEGORY |            TYPE |");
			System.out.println("--------------------------------------" +
					"--------------------------------------------");
			newSmallItem.display();
			System.out.println("--------------------------------------" +
					"--------------------------------------------");
			break;
		case 3: 
			Item newItem = new Item();
			in.nextLine();
			
			newItem.setIdNumber(id.toCharArray());
			System.out.println("What is the name of this item?");
			newItem.setName(in.nextLine());
			System.out.println("What is the quantity of this item?");
			newItem.setQuantity(in.nextInt());
			System.out.println("What is the price of this item?");
			newItem.setPrice(in.nextFloat());
			
			itemList.add(newItem);
			System.out.println("Item has been added.");
			System.out.println("--------------------------------------" +
					"--------------------------------------------");
			System.out.println("|  ID # |         NAME |  QUANTITY |" 
					+ "  PRICE  |  BRAND/CATEGORY |            TYPE |");
			System.out.println("--------------------------------------" +
					"--------------------------------------------");
			newItem.display();
			System.out.println("--------------------------------------" +
					"--------------------------------------------");
			break;
		}
	}
	/**
	 * This method allows user to enter a quantity to add to the existing quantity
	 * @param index itemList index of Item quantity to increase
	 */
	void addQuantity(int index) {
		int addition;
		
		System.out.println("Current quantity: " + itemList.get(index).getQuantity());
		System.out.println("How much would you like to add to this quantity?");
		addition = in.nextInt();
		
		while (addition < 0) {
			System.out.println("Negative number invalid. Enter a new amount to add");
			addition = in.nextInt();
		}
		
		itemList.get(index).setQuantity(itemList.get(index).getQuantity() + addition);
		System.out.println("New quantity: " + itemList.get(index).getQuantity());

		
	}
	/**
	 * This method deletes all Item information from the itemList
	 * @param index itemList index of Item to be deleted
	 */
	void deleteItem(int index) {
		itemList.remove(index);
	}
	/**
	 * This method searches for a part of a name of an Item and displays all
	 * Items containing part of that given name
	 * @param name Item name to search for 
	 */
	void searchName(String name) {
		Boolean found = false; //assigned to true if part of name exists
		 
		for(int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getName().contains(name)) {
				if (found == false)
					found = true;
				System.out.println("--------------------------------------" +
						"--------------------------------------------");
				System.out.println("|  ID # |         NAME |  QUANTITY |" 
						+ "  PRICE  |  BRAND/CATEGORY |            TYPE |");
				System.out.println("--------------------------------------" +
						"--------------------------------------------");
				itemList.get(i).display();
				System.out.println("--------------------------------------" +
						"--------------------------------------------");
			}
		}
		if (found == false)
			System.out.println("item not found.");
	}
	/**
	 * This method checks if a User exists based on given id
	 * @param id is idNumber of User †o look for
	 * @return index of existing Item or -1 if non exists
	 */
	int checkUserExistence(String id) { 
		int itemMatchIndex = -1; //index assigned if item is found
		
		while(id.length() != 5) {
			System.out.println("Please enter a 5 character itemId");
			id = in.nextLine();
		}
			 
		for (int i = 0; i < userList.size(); i++){
			if (Integer.parseInt(id) ==(userList.get(i).getIdNumber()))
				itemMatchIndex = i;
		}
		return itemMatchIndex;
	}
	/**
	 * This method is used to display all Users in itemList
	 */
	void displayUsers() {
		System.out.println("------------------------------------" +
				"---------------------------------------------");
		System.out.println("|  ID # |   FIRST NAME |    LAST NAME | "
				+ "SOCIAL/PHONE # | MONTHLY SALARY/ADDRESS |");
		System.out.println("------------------------------------" +
				"---------------------------------------------");
		for (int i = 0; i < userList.size(); i++)
			userList.get(i).display();
		System.out.println("------------------------------------" +
                "---------------------------------------------");
	}
	/**
	 * This method allows user to enter information of an Employee or
	 * Customer and add to userList
	 * @param id idNumber of non-existing User
	 */
	void addNewUser(String id) {
		int input;
		
		System.out.println("What kind of user would you like to add?");
		System.out.println("1. Employee");
		System.out.println("2. Customer");
		
		input = in.nextInt();
		while (input < 1 || input > 2) {
			System.out.println("Please enter a valid choice.");
			input = in.nextInt();
		}
		switch(input) {
			case 1: 
				Employee newEmployee = new Employee();
				in.nextLine();
			
				newEmployee.setIdNumber(Integer.parseInt(id));
				System.out.println("What is the employee's first name?");
				newEmployee.setFirstName(in.nextLine());
				System.out.println("What is the employee's last name?");
				newEmployee.setLastName(in.nextLine());
				System.out.println("What is the employee's social?");
				newEmployee.setSocial(in.nextInt());
				System.out.println("What is the employee's monthly salary?");
				newEmployee.setMonthlySalary(in.nextFloat());
				
				userList.add(newEmployee);
				System.out.println("Employee has been added.");
				System.out.println("------------------------------------" +
						"---------------------------------------------");
				System.out.println("|  ID # |   FIRST NAME |    LAST NAME | "
						+ "        SOCIAL |         MONTHLY SALARY |");
				System.out.println("------------------------------------" +
						"---------------------------------------------");
				newEmployee.display();
				System.out.println("------------------------------------" +
						"---------------------------------------------");
				break;
			case 2:
				Customer newCustomer = new Customer();
				in.nextLine();
				
				newCustomer.setIdNumber(Integer.parseInt(id));
				System.out.println("What is the customer's first name?");
				newCustomer.setFirstName(in.nextLine());
				System.out.println("What is the customer's last name?");
				newCustomer.setLastName(in.nextLine());
				System.out.println("What is the customer's phone number?");
				newCustomer.setPhoneNum(in.nextLine());
				System.out.println("What is the customer's address?");
				newCustomer.setAddress(in.nextLine());
				
				userList.add(newCustomer);
				System.out.println("Customer has been added.");
				System.out.println("------------------------------------" +
						"---------------------------------------------");
				System.out.println("|  ID # |   FIRST NAME |    LAST NAME | "
						+ "       PHONE # |                ADDRESS |");
				System.out.println("------------------------------------" +
						"---------------------------------------------");
				newCustomer.display();
				System.out.println("------------------------------------" +
						"---------------------------------------------");
				break;
		}
	}
	/**
	 * This method allows the updating of any field for any type of user 
	 * @param index userList index of desired User to update
	 */
	void updateUser(int index) {
		int input;
		System.out.println("What would you like to update?");
		System.out.println("1. First Name");
		System.out.println("2. Last Name");
		
		if (userList.get(index) instanceof Employee) {
			System.out.println("3. Social");
			System.out.println("4. Monthly Salary");
			input = in.nextInt();
			
			while (input < 1 || input > 4) {
				System.out.println("Please enter a valid choice.");
				input = in.nextInt();
			}
			
			switch(input) {
				case 1:
					System.out.println("Current First Name: " + 
						userList.get(index).getFirstName());
					in.nextLine();
					System.out.println("Enter new First Name: ");
					String firstName = in.nextLine();
					userList.get(index).setFirstName(firstName);
					System.out.println("New First Name: " + 
						userList.get(index).getFirstName());
					break;
				case 2:
					System.out.println("Current Last Name: " + 
						userList.get(index).getLastName());
					in.nextLine();
					System.out.println("Enter new Last Name: ");
						userList.get(index).setLastName(in.nextLine());
					System.out.println("New Last Name: " + 
						userList.get(index).getLastName());
					break;
				case 3:
					System.out.println("Current Social: "+ 
						((Employee)userList.get(index)).getSocial());
					in.nextLine();
					System.out.println("Enter new Social: ");
						((Employee)userList.get(index)).setSocial(Integer.parseInt(in.nextLine()));
					System.out.println("New Social: " + 
						((Employee) userList.get(index)).getSocial());
					break;
				case 4:
					System.out.println("Current Montly Salary: "+ 
						((Employee) userList.get(index)).getMonthlySalary());
					in.nextLine();
					System.out.println("Enter new Monthly Salary: ");
						((Employee)userList.get(index)).setMonthlySalary(Float.parseFloat(in.nextLine()));
					System.out.println("New Monthly Salary: " + 
						((Employee)userList.get(index)).getMonthlySalary());
					break;
			}
		}
		else if(userList.get(index) instanceof Customer) {
			System.out.println("3. Phone Number");
			System.out.println("4. Address");
			input = in.nextInt();
				
			while (input < 1 || input > 4) {
					System.out.println("Please enter a valid choice.");
					input = in.nextInt();
			}
				
			switch(input) {
				case 1:
					System.out.println("Current First Name: " + 
						userList.get(index).getFirstName());
					in.nextLine();
					System.out.println("Enter new First Name: ");
						userList.get(index).setFirstName(in.nextLine());
					System.out.println("New First Name: " + 
						userList.get(index).getFirstName());
					break;
				case 2:
					System.out.println("Current Last Name: " + 
						userList.get(index).getLastName());
					in.nextLine();
					System.out.println("Enter new Last Name: ");
						userList.get(index).setLastName(in.nextLine());
					System.out.println("New Last Name: " + 
						userList.get(index).getLastName());
					break;
				case 3:
					System.out.println("Current Phone Number: " + 
						((Customer)userList.get(index)).getPhoneNum());
					in.nextLine();
					System.out.println("Enter new Phone Number: ");
						((Customer)userList.get(index)).setPhoneNum(in.nextLine());
					System.out.println("New Phone Number: " + 
						((Customer)userList.get(index)).getPhoneNum());
					break;
				case 4:
					System.out.println("Current Address: " + 
						((Customer)userList.get(index)).getAddress());
					in.nextLine();
					System.out.println("Enter new Address: ");
						((Customer)userList.get(index)).setAddress(in.nextLine());
					System.out.println("New Address: " + 
						((Customer)userList.get(index)).getAddress());
					break;
			}
		}
	}
	/**
	 * This method is used to display all Sales in itemList
	 */
	void displaySales() {
		System.out.println("--------------------------------------" +
				"------------------------------------------------");
		System.out.println("| ITEM ID | SALE QUANTITY | CUSTOMER ID | "
				+ " EMPLOYEE ID |                   SALE DATE |");
		System.out.println("--------------------------------------" +
				"------------------------------------------------");
		for (int i = 0; i < salesList.size(); i++)
			salesList.get(i).display();
		System.out.println("--------------------------------------" +
				"------------------------------------------------");
	}
	/**
	 * This method allows the adding of Sales to salesList
	 * @param id used to set Sales itemId 
	 * @param itemIndex itemList index of type of item to be sold
	 */
	void completeSale(String id, int itemIndex) {
		Sales newSale = new Sales();
		int saleQuantity, currentQuantity, customerIndex, employeeIndex;
		
		newSale.setItemId(id);
		
		System.out.println("How many items are being sold?");
		saleQuantity = in.nextInt();
		newSale.setQuantity(saleQuantity);
		in.nextLine();
		currentQuantity = itemList.get(itemIndex).getQuantity();
		itemList.get(itemIndex).setQuantity(currentQuantity - saleQuantity);
		
		System.out.println("What is the customer's Id?");
		customerIndex = checkUserExistence(in.nextLine());
		while (customerIndex == -1) {
			System.out.println("Invalid customer Id. Reenter: ");
			customerIndex = checkUserExistence(in.nextLine());
		}
		newSale.setCustomerId(userList.get(customerIndex).getIdNumber());
		
		System.out.println("What is the employee's Id?");
		employeeIndex = checkUserExistence(in.nextLine());
		while (customerIndex == -1) {
			System.out.println("Invalid employee Id. Reenter: ");
			employeeIndex = checkUserExistence(in.nextLine());
		}
		newSale.setEmployeeId(userList.get(employeeIndex).getIdNumber());
		
		salesList.add(newSale);
		System.out.println("Sale completed.");
		System.out.println("--------------------------------------" +
				"------------------------------------------------");
		System.out.println("| ITEM ID | SALE QUANTITY | CUSTOMER ID | "
				+ " EMPLOYEE ID |                   SALE DATE |");
		System.out.println("-------------------------------------" +
				"------------------------------------------------");
		newSale.display();
		System.out.println();
		System.out.println("--------------------------------------" +
				"------------------------------------------------");
	}
	/**
	 * This method writes all existing ArrayList in serializable file
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	void exitToFile() throws FileNotFoundException, IOException {
		OutputStream inFile = null, buff = null;
		ObjectOutput outObj = null;
		
		File f = new File("Hardware.ser");
		try {
			inFile = new FileOutputStream(f);
			buff = new BufferedOutputStream(inFile);
			outObj = new ObjectOutputStream(buff);
			
			outObj.writeObject(itemList);
			outObj.writeObject(userList);
			outObj.writeObject(salesList);
			
			outObj.close();
		}catch(IOException io) {
			System.err.println(io.toString());
		}
	}
	

}
