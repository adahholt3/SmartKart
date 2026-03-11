package smartkart;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Return Kiosk Created by Adah Holt
 */

public class StoreManagment{
	
	private ArrayList<Product> inventory;
	private ArrayList<Product> cart;
	private ArrayList<Purchase> purchaseHistory;
	
	public StoreManagment()
	{
		inventory = new ArrayList<>();
		cart = new ArrayList<>();
		purchaseHistory = new ArrayList<>();
	}

	
	
	
	
	
	/**
	 * Return Kiosk Created by Adah Holt
	 */
	public void returnKiosk ()
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("ENTER PRODUCT ID: ");
		String id = scanner.nextLine();
		
		Purchase foundPurchase= null;
		
		/**
		 * Find the purchase record
		 */
		for(Purchase p : purchaseHistory)
		{
			if(p.getProduct().getProductID().equals(id))
			{
				foundPurchase = p;
				break;
			}
		}
	
		if(foundPurchase == null)
		{
			System.out.println("Product could not be found");
			return;
		}
		
		Product product = foundPurchase.getProduct();
		
		/**
		 * Checks if product is returnable by using instanceOf
		 */
		if(!(product instanceof Returnable))
		{
			System.out.println("Sorry, item can not be returned");
			return;
		} 
		
		Returnable r = (Returnable) product;
			
		/**
		 * Check if its valid for return using scanner
		 */
		System.out.println("Days since purchase: ");
		int days = scanner.nextInt();
		
		System.out.println("Quantity to return: ");
		int quantity = scanner.nextInt();
		
		if(quantity > foundPurchase.getQuantity())
		{
			System.out.println("cannot return more items than purchase");
			return;
		}
		
		System.out.println("Condition (New/worn): ");
		String condition = scanner.nextLine();
		
		/**
		 * Checks eligibility using method from interface
		 */
		if(!r.isEligibleForReturn(days))
		{
			System.out.println("return not eligible");
			return;
		}
		
		/**
		 * Calculates refund using method from interface
		 */
		double refund = r.processRefund(quantity, condition);
		
		if(refund == 0)
		{
			System.out.println("Item condition not eligible");
			return;
		}
		
		/**
		 * restocks using method from Product
		 */
		product.restock(quantity);
		
		foundPurchase.reduceQuantity(quantity);
		
		if(foundPurchase.getQuantity()==0)
			purchaseHistory.remove(foundPurchase);
		
		
		/**
		 * Prints calculated refund
		 */
		System.out.println("Refunded amount: " + refund);
		
		
		
		/**
		 * Ask for user input
		 * Uses input for return label
		 */
		System.out.println("Customer name: " );
		String name= scanner.nextLine();
		
		System.out.println("Customer address: ");
		String address = scanner.nextLine();
		
		
		/**
		 * Generates label and prints it
		 */
		String label = r.generateReturnLabel(name,  address);
		
		System.out.println("\nReturn Label:");
		System.out.println(label);
		
		
		
	}
}
