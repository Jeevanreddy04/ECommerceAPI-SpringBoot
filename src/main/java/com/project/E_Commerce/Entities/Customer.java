package com.project.E_Commerce.Entities;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotBlank
	private String name;
	@Min(6000000000L)
	@Max(9999999999L)
	@Positive
	private long mob;
	@Email
	private String email;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Address> address=new ArrayList<>();
	@OneToMany
	private List<Orders> orders=new ArrayList<>();
	@OneToMany
	private List<Products> cart;
	public Customer(String name, long mob, String email, List<Address> address, List<Orders> orders,
			List<Products> cart) {
		super();
		this.name = name;
		this.mob = mob;
		this.email = email;
		this.address = address;
		this.orders = orders;
		this.cart = cart;
	}
	public Customer() {
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
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(Address address ) {
		this.address.add(address);
	}
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	public List<Products> getCart() {
		return cart;
	}
	public void setCart(List<Products> cart) {
		this.cart = cart;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", mob=" + mob + ", email=" + email + ", address=" + address
				+ ", Orders=" + orders + ", cart=" + cart + "]";
	}
	
 
}
