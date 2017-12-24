package client.app;

import java.io.Serializable;
import java.util.Date;

public interface Item extends Serializable {

	/**
	 * Get the name of the Item.
	 * @return the name
	 */
	String getName();
	
	/**
	 * Get the description of the Item.
	 * @return the description
	 */
	String getDescription();
	
	/**
	 * Get the leader of the bid for the Item.
	 * @return the leader
	 */
	IClient getLeader();
	
	/**
	 * Get the current price of the Item.
	 * @return the price
	 */
	double getPrice();
	
	/**
	 * Get the status of the Item (available or sold).
	 * @return false is available; true if sold.
	 */
	boolean isSold();
	
	/**
	 * Set the leader of the bid for the Item.
	 * @params leader the leader
	 */
	void setLeader(IClient leader);
	
	/**
	 * Set the new price of the Item.
	 * @return the price
	 */
	void setPrice(double price);
	
	/**
	 * Set the status of the Item (available or sold).
	 * @return false is available; true if sold.
	 */
	void setSold(boolean status);

	Date getTime();
		
}
