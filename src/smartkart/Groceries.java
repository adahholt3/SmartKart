package smartkart;

import java.time.LocalDate;

/**
 * Groceries Class Done by Adah Holt
 * Child Class of Product
 */

public class Groceries extends Product{

	/**
	 * I used ChatGPT to look up how to use the additional field LocalDate
	 */
	private LocalDate expirationDate;
	
	
	
	/**
	 * Constructor
	 */
	public Groceries(String productID, String name, double price, int quantity, LocalDate expirationDate)
	{
		super(productID, name, price, quantity);
		this.expirationDate = expirationDate;
	}
	
	/**
	 * Returns 0 for tax on groceries
	 */
	@Override
	public double calculateTax(int quantity)
	{
		return 0;
	}
	
	/**
	 * Uses boolean and local date to check if it's expired
	 */
	public boolean isExpired()
	{
		if(LocalDate.now().isAfter(expirationDate))
		{
			System.out.println("This product is expired");
			return true;
		}
		return false;
	}
	
	/**
	 * Getter for expiration date
	 */
	public LocalDate getExpirationDate()
	{
		return expirationDate;
	}
	
	/**
	 * Checks if its expired before purchase
	 */
	@Override
	public boolean purchase(int amount)
	{
		if(isExpired())
		{
			System.out.println("Cannot purchase because it is expired");
			return false;
		}
		return super.purchase(amount);
	}

}
