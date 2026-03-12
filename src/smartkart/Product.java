package smartkart;

public abstract class Product {
	/**
	 * Product Parent Class Done by Adah Holt
	 * Abstract parent class 
	 * Stores common product information and behavior
	 */
	protected String productID;
	protected String name;
	protected double price;
	protected int quantity;
	
	
	
	/**
	 * Constructor
	 */
	public Product(String productID, String name, double price, int quantity)
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
	public double getPrice()
	{
		return price;
	}
	public int getQuantity()
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
		if(amount <= 0 || amount > quantity)
		{
			return false;
		}
		quantity -= amount;
		return true;
	}
	
	/**
	 * Restocks amount to stock
	 */
	public void restock(int amount)
	{
		if(amount> 0)
			quantity += amount;
	}
	
	

}
