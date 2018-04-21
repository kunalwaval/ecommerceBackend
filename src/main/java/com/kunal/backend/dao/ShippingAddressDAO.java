package com.kunal.backend.dao;

import java.util.List;

import com.kunal.backend.model.ShippingAddress;

public interface ShippingAddressDAO {
	public void saveShippingAddress(ShippingAddress shippingAddress);

	public void delete(int shippingAddressId);

	public ShippingAddress getById(int shippingAddressId);

	public List<ShippingAddress> list(String username);
}
