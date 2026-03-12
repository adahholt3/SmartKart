package smartkart;

import java.time.LocalDate;
/**
 * Purchase Created by Adah Holt
 * Created to use for kiosk method
 * Represents a purchase record used for return history
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
	 * Reduces the recorded purchase quanttiy after a return
	 */
	public void reduceQuantity(int amount)
	{
		if(amount > 0 && amount <= quantity)
		quantity -= amount;
	}

}
