package com.project.E_Commerce.Exceptions;

public class CarrierNotFoundException extends RuntimeException {
	public CarrierNotFoundException() {
		super("Carrier Not Found");
	}

}
