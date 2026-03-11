package smartkart;

public abstract class Product {
	/**
	 * Product Parent Class Done by Adah Holt
	 */
	protected String productID;
	protected String name;
	protected double price;
	protected int quantity;
	
	//Constructor
	
	/**
	 * Constructor
	 */
	public Product(String productID, String name, double price, int quatity)
	{
		this.productID = productID;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	/**
	 * Getters
	 */
	public String getProductID()
	{
		return productID;
	}
	public String getName()
	{
		return name;
	}
	public double price()
	{
		return price;
	}
	public int quantity()
	{
		return quantity;
	}
	
	/**
	 * Abstract method for calculating tax
	 */
	public abstract double calculateTax(int quantity);
	
	/**
	 * Purchase method which reduces stock(quantity) when an item is purchased
	 */
	public boolean purchase(int amount)
	{
		if(amount <= 0)
		{
			return false;
		}
		if(amount<=quantity) {
			quantity-=amount;
			return true;
		}
		return false;
	}
	
	/**
	 * Restocks amount to stock
	 */
	public void restock(int amount)
	{
		if(quantity == 0)
			quantity += amount;
	}
	
	

}
