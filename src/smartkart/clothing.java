package SmartKart;

/**
 * clothing class by Aamna D.
 * Clothing is child class of product and also implements the Returnable interface
 */

public class clothing extends product implements Returnable {
	
	/**
	 * adds additional attributes of size and material
	 * Sets up the constructor w/ the super product classes 
	 * attributes as well 
	 */
	private String size;
	private String material;
	
	public clothing(String productID, String name, double price, int quantity, String size, String material) {
		super(productID, name, price, quantity);
		
		this.size= size;
		this.material = material;
		
	}
	
	/**
	 * Sets up the getter for the material and size
	 */

	public String getMaterial() {
		return material;
	}

	public String getSize() {
		return size;
	}
	
	/**
	 * Calculate the tax based on clothing 5%
	 */
	
	@Override
	double calculateTax(int quantity) {
		double totalPrice;
		double taxPercentage = 0.05;
		
		totalPrice = ((getPrice() * quantity) * taxPercentage);
		return totalPrice;
	}

	/*
	 * ○ Return window: 30 days
	   ○ If condition = "Worn" → no refund
	 */
	
	
	@Override
	public boolean isEligibleForReturn(int daysSincePurchase) {
		return (daysSincePurchase<=30);
	}
	
	@Override
	public double processRefund(int quantity, String condition) {
		
		double total = (getPrice()*quantity);
		
		if (condition.equalsIgnoreCase("New"))
			return total; // full refund if not worn
		else if (condition.equalsIgnoreCase("Worn"))
			return total * 0;  //no refund if worn
		return total;
			
	}
	
	/**
	 * Prints the receipt for the customer
	 */
	@Override
	public String generateReturnLabel(String customerName, String address) {
		String receipt = "Reciept for : "+ customerName + "adress : " + address;
		System.out.println(receipt);
		return receipt;
		

	}
}
