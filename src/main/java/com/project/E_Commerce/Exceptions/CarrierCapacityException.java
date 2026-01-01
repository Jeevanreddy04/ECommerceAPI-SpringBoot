package com.project.E_Commerce.Exceptions;

public class CarrierCapacityException extends RuntimeException {

	public CarrierCapacityException() {
		super("Carrier capacity is not sufficient");
	}

}
