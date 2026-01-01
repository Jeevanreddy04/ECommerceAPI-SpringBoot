package com.project.E_Commerce.Exceptions;

public class CustomerNotFoundException extends RuntimeException {
	public CustomerNotFoundException() {
		super("Customer Not Found");
	}

}
