package com.project.E_Commerce.Exceptions;

public class OrderNotFoundException extends RuntimeException{
	public OrderNotFoundException() {
		super("Order Not Found");
	}

}
