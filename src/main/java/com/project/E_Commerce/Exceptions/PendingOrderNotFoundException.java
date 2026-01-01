package com.project.E_Commerce.Exceptions;

public class PendingOrderNotFoundException extends RuntimeException{
	public PendingOrderNotFoundException() {
		super("Pending Orders Not Found");
	}

}
