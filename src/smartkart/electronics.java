package smartkart;

/**
 * electronic class by Aamna D.
 * Child class of product class and also implements returnable interface
 */

public class electronics extends product implements Returnable {
	/**
	 * Sets up the additional attribute brand and also the super classes, and the constructor
	 */	
	
	private String brand;
	
	public electronics(String productID, String name, double price, int quantity,String brand) {
		super(productID, name, price, quantity);
		this.brand = brand;
	}
	
	
	// Getter for electronic brand
		public String getBrand() {
			return brand;
		}
	
		/**
		 * Sets up the tax for the electronic class
		 */
	@Override
	double calculateTax(int quantity) {
		// 
		double totalPrice;
		double tax = 0.15;
		totalPrice = ((getPrice() * quantity) * tax);
		return totalPrice;
		
	}

	/*
	 *  ○ Return window: 15 days - If less then 15 days returnable
	 *  ○ If condition = "Open Box" → 10% fee
	 */

	@Override
	public boolean isEligibleForReturn(int daysSincePurchase) {
		
		return (daysSincePurchase <= 15);

	}

	@Override
	public double processRefund(int quantity, String condition) {
		
		double total = (getPrice()* quantity);
		
		if (condition.equalsIgnoreCase("Open Box"))
			return total*0.90;
		else 
			return total;
		}
	
	/**
	 * creates the receipt for the customer with there name and address
	 */

	@Override
	public String generateReturnLabel(String customerName, String address) {
	
		String receipt = "Receipt for " + customerName + "and " + address;
		System.out.println(receipt);
		return receipt;
		
		
	}

}
