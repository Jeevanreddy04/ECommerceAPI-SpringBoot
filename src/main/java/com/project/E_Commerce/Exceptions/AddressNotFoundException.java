package com.project.E_Commerce.Exceptions;

public class AddressNotFoundException extends RuntimeException {
	public AddressNotFoundException() {
		super("Address Not Found");
		
	}

}
