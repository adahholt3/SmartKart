package playground;

import smartkart.*;
import java.util.Scanner;
public class main {

	public static void main(String[] args) {
		
		StoreManagement store = new StoreManagement();
		Scanner scanner = new Scanner(System.in);
		
		//Load inventory file
		store.loadInventory("/Users/adahholt/Downloads/TSV done by Adah - Sheet1 (1).tsv");
		
				int choice = 0;
				
				while(choice !=5)
				{
					System.out.println("\nSMARTKART MENU");
					System.out.println("1. View Inventory");
					System.out.println("2. Add to Cart");
					System.out.println("3. Checkout");
					System.out.println("4. Return Kiosk");
					System.out.println("5. Exit");
					
					System.out.println("Enter choice: ");
					choice = scanner.nextInt();
					scanner.nextLine();
					
					switch(choice)
					{
					case 1:
						store.displayInventory();
						break;
					case 2:
						store.addtoCart();
						break;
					case 3:
						store.checkout();
						break;
					case 4:
						store.returnKiosk();
						break;
					case 5:
						System.out.println("Exiting SmartKart");
						break;
					default:
						System.out.println("Invalid choice");
					}
					
				}
				scanner.close();
		
	}

}
