package com.kunal.Backend.dao;

import java.util.List;

import com.kunal.Backend.model.Cart;

public interface CartDAO {
	public void saveCart(Cart cart);

	public List<Cart> getCartByUsername(String username);

	void removeCartItem(int cartitemid);

	void removeAllCartItem(String username);

}
