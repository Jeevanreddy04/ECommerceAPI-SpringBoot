package com.project.E_Commerce.Entities;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
public class Carrier {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotBlank
	private String name;
	@Positive
	@Min(6000000000L)
	@Max(9999999999L)
	private long mob;
	@Email
	private String email;
	private int capacity=5;
	 @JsonManagedReference
	@OneToMany
	private List<Orders> orders;
	public Carrier(String name, long mob, String email, int capacity, List<Orders> orders) {
		super();
		this.name = name;
		this.mob = mob;
		this.email = email;
		this.capacity = capacity;
		this.orders = orders;
	}
	public Carrier() {
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
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "Carrier [id=" + id + ", name=" + name + ", mob=" + mob + ", email=" + email + ", capacity=" + capacity
				+ ", orders=" + orders + "]";
	}
	

}
