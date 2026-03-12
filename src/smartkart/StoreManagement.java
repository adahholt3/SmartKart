package smartkart;

import smartkart.Groceries;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;


public class StoreManagement {
	/**
	 * StoreManagement - created by Aamna D. 
	 * Sets up the attribute and arraylists for inventory and cart
	 */
	
	ArrayList<Product>inventory;
	ArrayList<Product>cart;
	private ArrayList<Purchase> purchaseHistory;
	
	public StoreManagement(ArrayList<Product>inventory,ArrayList<Product>cart) {
		
		this.cart = new ArrayList<>();
		this.inventory = new ArrayList<>();
		purchaseHistory = new ArrayList<>();
		
	}
	public void loadInventory(String fileName)
	{
		try
		{
			File file = new File(fileName);
			Scanner scanner = new Scanner(file);
			
			while(scanner.hasNextLine())
			{
				String line = scanner.nextLine();
				String[] parts = line.split("\t");
				
			}
			
			scanner.close();
		}
		catch(Exception e)
		{
			System.out.println("Error loading inventory");
		}
	}
	// 4.1 - View Inventory
	/** Aamna D.
	 * prints the product info inventory
	 */
	
	public void displayInventory() {
		System.out.println("Product ID , Name , Price, Quantity");
		for (product info : inventory) {
			System.out.println(info);
		}
	}
	// 4.2 - Add to Cart	
		/** Aamna D.
		 * @param productID
		 * @param quantity
		 * Checks if productID has a match and quantity is enough, by looping though the inventory.
		 */
		public void addtoCart(String productID, int quantity) {
			product match =null; 
			
			for(product p : inventory) {
			if ((p.getProductID()==productID) && (p.getquantity() <= quantity))
					match = p;
		 			break;		
			}
			if (match == null) {
				System.out.println("Product match not found");
				return;
			}
			/** Aamna D.
			 * checks if the product is apart of with instanceof groceries
			 * and if so checks if expired or not 
			 */
			if (match instanceof Groceries) {
				Groceries g = (Groceries) match;
				if (g.getExpirationDate().isAfter(LocalDate.now())) {
					System.out.println("Prodcut is expired");
					return;
				}
			}
			
			/**
			* Aamna D.
			 * Adds product to cart and removes from inventory if successful
			 */
			match.purchase(quantity);
			cart.add(match);
			inventory.remove(match);
			System.out.println("Added to cart");
			
			/**
			 * Prints the receipt, calculates the total for each item
			 * Aamna D.
			 */
		}
		public void receipt(ArrayList<product>cart) {
			double subTotal = 0.0;
			double taxTotal = 0.0;
			double Total = 0.0;
			
			for (product p : cart) {
				double productPrice = p.getPrice();
				double productTax = p.calculateTax(amount);
				
				System.out.printf(p.getName(),productPrice, "Quantity: " + 1,productTax);
				
				subTotal = subTotal + productPrice;
				taxTotal = taxTotal + productTax;
				Total = (subTotal + taxTotal);
				
			}
			System.out.println("Subtotal : " + subTotal + "Tax : " + taxTotal + "Total : " + (Total));
			 
		}
	
	
	// Pathname for tsv '/Users/adahholt/Downloads/TSV done by Adah - Sheet1 (1).tsv.zip'
	/**
	 * Return Kiosk Created by Adah Holt
	 */
	public void returnKiosk (Scanner scanner)
	{
		
		
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
		
		scanner.nextLine();
		System.out.println("Condition (New/worn): ");
		String condition = scanner.nextLine().toLowerCase();
		
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

	

	

