package com.project.E_Commerce.DTO;

import java.time.LocalDate;
import java.util.List;

import com.project.E_Commerce.Entities.Address;
import com.project.E_Commerce.Entities.Carrier;
import com.project.E_Commerce.Entities.Customer;
import com.project.E_Commerce.Entities.Products;

public class CarrierOrderDTO {
	private int id;
	private String custname;
	private long custmobno;
	private Address pickuploc;
	private Address deliveryloc;
	public CarrierOrderDTO(int id, String custname, long custmobno, Address pickuploc, Address deliveryloc) {
		super();
		this.id = id;
		this.custname = custname;
		this.custmobno = custmobno;
		this.pickuploc = pickuploc;
		this.deliveryloc = deliveryloc;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public long getCustmobno() {
		return custmobno;
	}
	public void setCustmobno(long custmobno) {
		this.custmobno = custmobno;
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
	public CarrierOrderDTO() {
		super();
	}
	@Override
	public String toString() {
		return "CarrierOrderDTO [id=" + id + ", custname=" + custname + ", custmobno=" + custmobno + ", pickuploc="
				+ pickuploc + ", deliveryloc=" + deliveryloc + "]";
	}
}