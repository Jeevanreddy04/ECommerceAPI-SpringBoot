package com.project.E_Commerce.DTO;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.project.E_Commerce.Entities.Address;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
public class CustomerDTO {
	@NotBlank
	private String name;
	@Min(6000000000L)
	@Max(9999999999L)
	@Positive
	private long mob;
	@Email
	private String email;
	private Address address;
	public CustomerDTO(String name, long mob, String email, Address address) {
		super();
		this.name = name;
		this.mob = mob;
		this.email = email;
		this.address = address;
	}
	public CustomerDTO() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMob() {
		return mob;
	}
	public void setMob(long mob) {
		this.mob = mob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "CustomerDTO [name=" + name + ", mob=" + mob + ", email=" + email + ", address=" + address + "]";
	}
	
	
	
	
}
