package smartkart;

import java.time.LocalDate;
/**
 * Purchase Created by Adah Holt
 * Created to use for purchase history for kiosk method
 */

public class Purchase {
	
	private Product product;
	private int quantity;
	private LocalDate purchaseDate;
	
	/**
	 * Constructor
	 */
	public Purchase(Product product, int quantity)
	{
		this.product = product;
		this.quantity= quantity;
		this.purchaseDate = LocalDate.now();
	}
	
	/**
	 * Getters from product class
	 */
	
	public Product getProduct()
	{
		return product;
	}
	
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public LocalDate getPurchaseDate()
	{
		return purchaseDate;
	}
	
	/**
	 * Reduces stock
	 */
	public void reduceQuantity(int amount)
	{
		quantity -= amount;
	}

}
