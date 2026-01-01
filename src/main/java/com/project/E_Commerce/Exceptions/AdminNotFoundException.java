package com.project.E_Commerce.Exceptions;

public class AdminNotFoundException extends RuntimeException{
	
	public AdminNotFoundException() {
		super("Admin Not Found");
	}

}
