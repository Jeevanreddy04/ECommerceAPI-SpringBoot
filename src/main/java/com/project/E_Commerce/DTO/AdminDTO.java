package com.project.E_Commerce.DTO;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public class AdminDTO {
	@NotBlank
	private String name;
	@Min(6000000000L)
	@Max(9999999999L)
	@Positive
	private long mob;
	@Email
	private String mail;
	public AdminDTO(String name, long mob, String mail) {
		super();
		this.name = name;
		this.mob = mob;
		this.mail = mail;
	}
	public AdminDTO() {
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	@Override
	public String toString() {
		return "AdminDTO [name=" + name + ", mob=" + mob + ", mail=" + mail + "]";
	}
	

}
