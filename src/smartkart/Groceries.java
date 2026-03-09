package smartkart;

import java.time.LocalDate;

public class Groceries extends Product{
	
	private LocalDate expirationDate;
	private boolean expired;
	
	public Groceries(String productID, String name, double price, int quantity)
	{
		super(productID, name, price, quantity);
		this.expirationDate = expirationDate;
	}
	
	//Tax
	@Override
	public double calculateTax(int quantity)
	{
		return 0;
	}
	
	//Check expiration
	public boolean isExpired()
	{
		if(LocalDate.now().isAfter(expirationDate))
		{
			System.out.println("its expired brah");
			return false;
		}
		return true;
	}
	
	public LocalDate getExpirationDate()
	{
		return expirationDate;
	}
	
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
