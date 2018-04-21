package com.kunal.backend.dao;

import com.kunal.backend.model.Order;

public interface OrderDAO {

	public Order list(String username);

	public void saveOrder(Order order);

	void removeAllOrderItems(String username);

}
