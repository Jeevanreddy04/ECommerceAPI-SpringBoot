package com.project.E_Commerce.DTO;

public class AddProductDto {
	private String name;
	private int quantity;
	private String category;
	private int priceperUnit;
	private String brandName;
	private String description;
	public AddProductDto(String name, int quantity, String category, int priceperUnit, String brandName,
			String description) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.category = category;
		this.priceperUnit = priceperUnit;
		this.brandName = brandName;
		this.description = description;
	}
	public AddProductDto() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPriceperUnit() {
		return priceperUnit;
	}
	public void setPriceperUnit(int priceperUnit) {
		this.priceperUnit = priceperUnit;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "AddProductDto [name=" + name + ", quantity=" + quantity + ", category=" + category + ", priceperUnit="
				+ priceperUnit + ", brandName=" + brandName + ", description=" + description + "]";
	}
	
	

}
