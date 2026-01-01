package com.project.E_Commerce.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotBlank
	private String city;
	@Min(100000)
	@Max(999999)
	@Positive
	private int pincode;
	@NotBlank
	private String state;
	@NotBlank
	private String country;
	private String description;
	@Min(6000000000L)
	@Max(9999999999L)
	@Positive
	private long mob;
	private String addtype;
	public Address(String city, int pincode, String state, String country, String description, long mob,
			String addtype) {
		super();
		this.city = city;
		this.pincode = pincode;
		this.state = state;
		this.country = country;
		this.description = description;
		this.mob = mob;
		this.addtype = addtype;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Address() {
		super();
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getMob() {
		return mob;
	}
	public void setMob(long mob) {
		this.mob = mob;
	}
	public String getAddtype() {
		return addtype;
	}
	public void setAddtype(String addtype) {
		this.addtype = addtype;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", pincode=" + pincode + ", state=" + state + ", country="
				+ country + ", Description=" + description + ", mob=" + mob + ", Addtype=" + addtype + "]";
	}
	

}
