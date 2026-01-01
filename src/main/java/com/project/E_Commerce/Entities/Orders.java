package com.project.E_Commerce.Entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Positive;

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToMany
	private List<Products> purchaselist;
	@JsonIgnore
	@ManyToOne
	private Customer cust;
	@ManyToOne
	 @JsonBackReference
	private Carrier carrier;
	private String orderStatus="Pending";
	private LocalDate date;
	@ManyToOne
	private Address pickuploc;
	@ManyToOne
	private Address deliveryloc;
	private LocalDate expecteddeliverydate;
	@Positive
	private int totalprice;
	@Positive
	private Integer otp;
	public Orders(List<Products> purchaselist, Customer cust, Carrier carrier, String orderStatus, LocalDate date,
			Address pickuploc, Address deliveryloc, LocalDate expecteddeliverydate, int totalprice, int otp) {
		super();
		this.purchaselist = purchaselist;
		this.cust = cust;
		this.carrier = carrier;
		this.orderStatus = orderStatus;
		this.date = date;
		this.pickuploc = pickuploc;
		this.deliveryloc = deliveryloc;
		this.expecteddeliverydate = expecteddeliverydate;
		this.totalprice = totalprice;
		this.otp = otp;
	}
	
	public Orders() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Products> getPurchaselist() {
		return purchaselist;
	}
	public void setPurchaselist(List<Products> purchaselist) {
		this.purchaselist = purchaselist;
	}
	public Customer getCust() {
		return cust;
	}
	public void setCust(Customer cust) {
		this.cust = cust;
	}
	public Carrier getCarrier() {
		return carrier;
	}
	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Address getPickuploc() {
		return pickuploc;
	}
	public void setPickuploc(Address pickuploc) {
		this.pickuploc = pickuploc;
	}
	public Address getDeliveryloc() {
		return deliveryloc;
	}
	public void setDeliveryloc(Address deliveryloc) {
		this.deliveryloc = deliveryloc;
	}
	public LocalDate getExpecteddeliverydate() {
		return expecteddeliverydate;
	}
	public void setExpecteddeliverydate(LocalDate expecteddeliverydate) {
		this.expecteddeliverydate = expecteddeliverydate;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", purchaselist=" + purchaselist + ", cust=" + cust + ", carrier=" + carrier
				+ ", OrderStatus=" + orderStatus + ", date=" + date + ", pickuploc=" + pickuploc + ", deliveryloc="
				+ deliveryloc + ", expecteddeliverydate=" + expecteddeliverydate + ", totalprice=" + totalprice
				+ ", otp=" + otp + "]";
	}
}