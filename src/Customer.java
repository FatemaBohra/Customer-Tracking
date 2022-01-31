import java.util.ArrayList;

/**
 * Represents a customer with name, ID and geography
 * @author fatemabohra
 *
 */
public class Customer {
	
	//Static variables
	//Shared across all instances of Customer
	
	/**
	 * Company for all customer
	 */
	static final String COMPANY = "CVS";
	
	/**
	 * Stores list of all customer
	 */
	static ArrayList<Customer> CUSTOMERS = new ArrayList<Customer>();
	
	/**
	 * To generate and keep track of customer IDs.
	 */
	static Counter COUNTER;
	
	//instance variables
	/**
	 * Name of customer
	 */
	String name;
	
	
	/**
	 * Geography of customer
	 */
	String geography;
	
	/**
	 * ID of customer
	 */
	int ID;
	
	public Customer(String name, String geography) {
		this.name = name;
		this.geography = geography;
		
		//gets unique ID from counter
		this.ID = Customer.COUNTER.getCount();
		
		//increment counter
		Customer.COUNTER.increment();
		
		//adds this customer to list of all customers.
		Customer.CUSTOMERS.add(this);
	}
	
	/**
	 * Prints all the customer for the company.
	 */
	public static void printAllCustomer() {
		System.out.println("All customer: ");
		
		//iterate over statically references list of customer
		for (Customer c : Customer.CUSTOMERS) {
			System.out.println(c);
		}
		
		System.out.println("\n");
	}
	
	/**
	 * Compares two customer for equality.
	 * If they have same name and geography, they are equal.
	 */
	public boolean equals(Object obj) {
		
		//cast Object to Customer
		Customer otherCustomer = (Customer) obj;
		
		if ((this.name.equals(otherCustomer.name) && this.geography.equals(otherCustomer.geography))) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Returns ID, name of customer, company and geography of customer
	 */
	public String toString() {
		return "ID: " + this.ID + ", name: " + this.name + ", Company: " + Customer.COMPANY + ", Location: " + this.geography;
	}
	
	/**
	 * Locates the given customer to the list of customers.
	 * @param customer to look up
	 * @return index of the given customer in the list, otherwise -1
	 */
	public static int findCustomer(Customer customer) {
		
		//set default index
		int index = -1;
		
		//iterate over customer list and locate given customer.
		for (int i = 0; i < Customer.CUSTOMERS.size(); i++) {
			if(Customer.CUSTOMERS.get(i).equals(customer)) { //will call equals method in customer class.
				index = i;
				break;
			}
		}
		
		return index;
	}
	
	/**
	 * Removes the given customer from the list of customers.
	 * @param customer
	 */
	public static void removeCustomer(Customer customer) {
		
		//find the customer
		int removeIndex = Customer.findCustomer(customer);
		
		//check if index is valid, then remove customer
		if (removeIndex >= 0) {
			Customer.CUSTOMERS.remove(removeIndex);
		}
	}
	

	public static void main(String[] args) {
		
		//initialize the counter for generating unique IDs for each customer.
		Customer.COUNTER = new Counter(1);
		
		//create customer
		Customer c1 = new Customer("Chenyun", "Los Angles");
		
		//print all customers
		Customer.printAllCustomer();
		
		//create another customer 
		Customer c2 = new Customer("Mulan", "China");
		
		//print all customers
		Customer.printAllCustomer();
		
		//create another customer 
		Customer c3 = new Customer("Fatema", "India");
		
		//print all customers
	    Customer.printAllCustomer();
//	    
//	    //create another customer 
//	  	Customer c4 = new Customer("Fatema", "India");
//	  	
//	    //print all customers
//	    Customer.printAllCustomer();
	    
	    //remove customer
	    Customer.removeCustomer(c1);
	    
	    //print all customers 
	    Customer.printAllCustomer();
	}
}
