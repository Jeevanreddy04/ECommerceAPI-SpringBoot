package com.project.E_Commerce.Entities;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

@Entity
public class Admin {
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
	    @JoinColumn(name = "admin_id") 
	  @jakarta.validation.Valid// FK in Address table
	    private List<Address> add = new ArrayList<>();
	public Admin(String name, long mob, String email, List<Address> add) {
		super();
		this.name = name;
		this.mob = mob;
		this.email = email;
		this.add = add;
	}
	public Admin() {
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
	public List<Address> getAdd() {
		return add;
	}
	public void setAdd(List<Address> add) {
		this.add = add;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", mob=" + mob + ", email=" + email + ", add=" + add + "]";
	}
	
	

}
