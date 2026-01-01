package com.project.E_Commerce.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotBlank
	private String name;
	@Positive
	private int quantity;
	private String category;
	@Positive
	private int priceperUnit;
	private String brandName;
	private String description;
	private String availableStatus;
	public Products(String name, int quantity, String category, int priceperUnit, String brandName,
			String description, String availableStatus) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.category = category;
		this.priceperUnit = priceperUnit;
		this.brandName = brandName;
		this.description = description;
		this.availableStatus = availableStatus;
	}
	public Products() {
		super();
	}
	public int getId() {
		return id;
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
	public String getAvailableStatus() {
		return availableStatus;
	}
	public void setAvailableStatus(String availableStatus) {
		this.availableStatus = availableStatus;
	}
	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", quantity=" + quantity + ", category=" + category
				+ ", PriceperUnit=" + priceperUnit + ", brandName=" + brandName + ", description=" + description
				+ ", availableStatus=" + availableStatus + "]";
	}
	

}
