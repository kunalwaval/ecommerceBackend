package com.kunal.Backend.dao;

import java.util.List;

import com.kunal.Backend.model.Cart;
import com.kunal.Backend.model.CustomerOrder;

public interface OrderDAO {

	public CustomerOrder list(String username);
	public void saveOrder(CustomerOrder order);
	void removeAllOrderItem(String username);
	
}
