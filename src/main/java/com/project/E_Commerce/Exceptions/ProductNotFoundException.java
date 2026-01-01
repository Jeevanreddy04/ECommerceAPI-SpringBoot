package com.project.E_Commerce.Exceptions;

public class ProductNotFoundException extends RuntimeException {
	public ProductNotFoundException() {
		super("Product Not Found");
	}

}
