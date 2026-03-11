package smartkart;

import java.time.LocalDate;

/**
 * Groceries Class Done by Adah Holt
 */
public class Groceries extends Product{

	private LocalDate expirationDate;
	private boolean expired;
	
	
	/**
	 * Constructor
	 */
	public Groceries(String productID, String name, double price, int quantity)
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
			System.out.println("its expired brah");
			return false;
		}
		return true;
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
			return false;
		}
		return super.purchase(amount);
	}

}
