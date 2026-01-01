package com.project.E_Commerce.ServiceLayer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.project.E_Commerce.DTO.AddProductDto;
import com.project.E_Commerce.DTO.AdminDTO;
import com.project.E_Commerce.DTO.CarrierDTO;
import com.project.E_Commerce.DTO.CarrierOrderDTO;
import com.project.E_Commerce.DTO.CustomerDTO;
import com.project.E_Commerce.Entities.Address;
import com.project.E_Commerce.Entities.Admin;
import com.project.E_Commerce.Entities.Carrier;
import com.project.E_Commerce.Entities.Customer;
import com.project.E_Commerce.Entities.Orders;
import com.project.E_Commerce.Entities.Products;
import com.project.E_Commerce.Exceptions.AddressNotFoundException;
import com.project.E_Commerce.Exceptions.AdminNotFoundException;
import com.project.E_Commerce.Exceptions.CarrierCapacityException;
import com.project.E_Commerce.Exceptions.CarrierNotFoundException;
import com.project.E_Commerce.Exceptions.CustomerNotFoundException;
import com.project.E_Commerce.Exceptions.InvalidOtpException;
import com.project.E_Commerce.Exceptions.OrderNotFoundException;
import com.project.E_Commerce.Exceptions.PendingOrderNotFoundException;
import com.project.E_Commerce.Exceptions.ProductNotFoundException;
import com.project.E_Commerce.Repo.AddressRepo;
import com.project.E_Commerce.Repo.AdminRepo;
import com.project.E_Commerce.Repo.CarrierRepo;
import com.project.E_Commerce.Repo.CustomerRepo;
import com.project.E_Commerce.Repo.OrderRepo;
import com.project.E_Commerce.Repo.Productrepo;
import com.project.E_Commerce.Response.ResponseStructure;
import jakarta.persistence.criteria.Order;
import jakarta.transaction.Transactional;

@Service
public class ServiceLayer {
	
	@Autowired
	private AdminRepo adminrepo;

	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(AdminDTO a) {
		Admin a1=new Admin();
		a1.setName(a.getName());
		a1.setMob(a.getMob());
		a1.setEmail(a.getMail());
		adminrepo.save(a1);
		ResponseStructure<Admin> rs = new ResponseStructure<>();
		rs.setstatuscode(HttpStatus.CREATED.value());
		rs.setMessage("Admin saved successfully");
		rs.setData(a1);
		return new ResponseEntity<>(rs,HttpStatus.CREATED);

	}
	
	@Autowired
	private CarrierRepo carrierrepo;

	public ResponseEntity<ResponseStructure<Carrier>> saveCarrier(CarrierDTO carrier) {
	Carrier c=new Carrier();
	c.setName(carrier.getName());
	c.setMob(carrier.getMob());
	c.setEmail(carrier.getMail());
	carrierrepo.save(c);	
	ResponseStructure<Carrier> rs = new ResponseStructure<>();
	rs.setstatuscode(HttpStatus.CREATED.value());
	rs.setMessage("Carrier saved successfully");
	rs.setData(c);
	return new ResponseEntity<>(rs,HttpStatus.CREATED);
	
	}
	public ResponseEntity<ResponseStructure<List<Carrier>>> seeAllcarrier() {
		List<Carrier> clist=carrierrepo.findAll();
		ResponseStructure<List<Carrier>> rs = new ResponseStructure<>();
		rs.setstatuscode(HttpStatus.CREATED.value());
		rs.setMessage("Carriers");
		rs.setData(clist);
		return new ResponseEntity<>(rs,HttpStatus.CREATED);
	}

	
	public ResponseEntity<ResponseStructure<Carrier>> findCarrier(long mob) {		
		Carrier c=carrierrepo.findByMob(mob).orElseThrow(()->new CarrierNotFoundException());
		ResponseStructure<Carrier> rs=new ResponseStructure<>();
		rs.setstatuscode(HttpStatus.OK.value());
		rs.setMessage("Carrier Found");
		rs.setData(c);
		return new ResponseEntity<ResponseStructure<Carrier>>(rs,HttpStatus.FOUND);
		
	
}
	
	
	  @Transactional
	public ResponseEntity<ResponseStructure<Admin>> addAdminAddress(long mob, List<Address> add) {
		Admin a=adminrepo.findByMob(mob)
				.orElseThrow(()-> new AdminNotFoundException());
	    if (a.getAdd() == null) {
	        a.setAdd(add);
	    } else {
	        a.getAdd().addAll(add);
	    } 
		adminrepo.save(a);
		ResponseStructure<Admin> rs = new ResponseStructure<>();
		rs.setstatuscode(HttpStatus.ACCEPTED.value());
		rs.setMessage("Carrier saved successfully");
		rs.setData(a);
		return new ResponseEntity<>(rs,HttpStatus.ACCEPTED);
		
	}
	
	
	public ResponseEntity<ResponseStructure<Admin>> getAdminByMob(long mob) {
		Admin a=adminrepo.findByMob(mob).orElseThrow(()->new AdminNotFoundException());
		ResponseStructure<Admin> rs = new ResponseStructure<>();
		rs.setstatuscode(HttpStatus.OK.value());
		rs.setMessage("Admin Found");
		rs.setData(a);
		return new ResponseEntity<>(rs,HttpStatus.FOUND);
	}

	@Autowired
	private AddressRepo addrepo;

	public ResponseEntity<ResponseStructure<Admin>>  deleteAdminAddress(int adminId, int addressId) {
		Admin admin = adminrepo.findById(adminId)
	            .orElseThrow(() -> new AdminNotFoundException());
	    Address address = addrepo.findById(addressId)
	            .orElseThrow(() -> new AddressNotFoundException());
	    admin.getAdd().remove(address);
	    adminrepo.save(admin);
	    addrepo.delete(address); 
	    ResponseStructure<Admin> rs = new ResponseStructure<>();
		rs.setstatuscode(HttpStatus.OK.value());
		rs.setMessage("Admin Found");
		rs.setData(admin);
		return new ResponseEntity<>(rs,HttpStatus.OK);
	   
	}

	

	public ResponseEntity<ResponseStructure<String>> deleteCarrier(long mob) {
		Carrier c=carrierrepo.findByMob(mob).orElseThrow(()->new CarrierNotFoundException());
		carrierrepo.delete(c);
		ResponseStructure<String> rs=new ResponseStructure<>();
		rs.setstatuscode(HttpStatus.OK.value());
		rs.setMessage("Carrier Deleted");
	    rs.setData("Deleted carrier with mobile: " + mob);
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.OK);	
	}
	
	@Autowired
	private Productrepo prodrepo;
	public ResponseEntity<ResponseStructure<Products>> addProduct(AddProductDto p) {
		Products p1=new Products();
		p1.setBrandName(p.getBrandName());
		p1.setCategory(p.getCategory());
		p1.setDescription(p.getDescription());
		p1.setName(p.getName());
		p1.setPriceperUnit(p.getPriceperUnit());
		p1.setQuantity(p.getQuantity());
		prodrepo.save(p1);
		ResponseStructure<Products> rs=new ResponseStructure<>();
		rs.setstatuscode(HttpStatus.OK.value());
		rs.setMessage("Product Added");
	    rs.setData(p1);
		return new ResponseEntity<ResponseStructure<Products>>(rs,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<Products>>> getAllProducts() {
		List<Products> plist=prodrepo.findAll();
		ResponseStructure<List<Products>> rs=new ResponseStructure<>();
		rs.setstatuscode(HttpStatus.OK.value());
		rs.setMessage("Products");
	    rs.setData(plist);
		return new ResponseEntity<ResponseStructure<List<Products>>>(rs,HttpStatus.OK);	
	}

	public ResponseEntity<ResponseStructure<Products>> updateProduct(int id, String status) {
		Products p=prodrepo.findById(id).orElseThrow(()->new ProductNotFoundException());
		p.setAvailableStatus(status);
		prodrepo.save(p);
		ResponseStructure<Products> rs=new ResponseStructure<>();
		rs.setstatuscode(HttpStatus.OK.value());
		rs.setMessage("Products");
	    rs.setData(p);
		return new ResponseEntity<ResponseStructure<Products>>(rs,HttpStatus.OK);
	}

	
	@Autowired
	private CustomerRepo custrepo;
	
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(CustomerDTO c) {
		Customer c1=new Customer();
		c1.setName(c.getName());
		c1.setMob(c.getMob());
		c1.setEmail(c.getEmail());
		c1.setAddress(c.getAddress());
		custrepo.save(c1);
		ResponseStructure<Customer> rs=new ResponseStructure<>();
		rs.setstatuscode(HttpStatus.OK.value());
		rs.setMessage("Customer Added");
	    rs.setData(c1);
		return new ResponseEntity<ResponseStructure<Customer>>(rs,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Customer>> addCustAddress(long mob, Address a) {
		Customer c=custrepo.findByMob(mob).orElseThrow(()->new CustomerNotFoundException());
		c.setAddress(a);
		custrepo.save(c);
		ResponseStructure<Customer> rs=new ResponseStructure<>();
		rs.setstatuscode(HttpStatus.OK.value());
		rs.setMessage("Address Added");
	    rs.setData(c);
		return new ResponseEntity<ResponseStructure<Customer>>(rs,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<Address>>> getAllCustAdd(long mob) {
		Customer c=custrepo.findByMob(mob).orElseThrow(()->new CustomerNotFoundException());
		
		List<Address> alist=c.getAddress();
		
		ResponseStructure<List<Address>> rs=new ResponseStructure<>();
		rs.setstatuscode(HttpStatus.OK.value());
		rs.setMessage("Addressess");
	    rs.setData(alist);
		return new ResponseEntity<ResponseStructure<List<Address>>>(rs,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<String>> deleteAdd(long mob, int id) {
		Customer c=custrepo.findByMob(mob).orElseThrow(()->new CustomerNotFoundException());
		
		Address a=addrepo.findById(id).orElseThrow(()->new AddressNotFoundException());
		c.getAddress().remove(a);
		
		custrepo.save(c);
		addrepo.delete(a);
		ResponseStructure<String> rs=new ResponseStructure<>();
		rs.setstatuscode(HttpStatus.OK.value());
		rs.setMessage("Address Deleted");
	    rs.setData("Address deleted");
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<Products>>> seeAllProducts(String status) {
		
		List<Products> plist=(List<Products>) prodrepo.findAllByAvailableStatus(status);
		if(plist.isEmpty()) {
			throw new ProductNotFoundException();
		}
		ResponseStructure<List<Products>> rs=new ResponseStructure<>();
		rs.setstatuscode(HttpStatus.OK.value());
		rs.setMessage("Available Products");
	    rs.setData(plist);
		return new ResponseEntity<ResponseStructure<List<Products>>>(rs,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Customer>> addProdToCart(long mob, int id) {
		Customer c=custrepo.findByMob(mob).orElseThrow(()->new CustomerNotFoundException());
		Products p=prodrepo.findById(id).orElseThrow(()->new ProductNotFoundException());
		c.getCart().add(p);
		custrepo.save(c);
		ResponseStructure<Customer> rs=new ResponseStructure<>();
		rs.setstatuscode(HttpStatus.OK.value());
		rs.setMessage("Product Added to cart");
	    rs.setData(c);
		return new ResponseEntity<ResponseStructure<Customer>>(rs,HttpStatus.OK);	
	}

	public ResponseEntity<ResponseStructure<List<Products>>> seeCart(long mob) {
		Customer c=custrepo.findByMob(mob).orElseThrow(()->new CustomerNotFoundException());
		
		List<Products> cart=c.getCart();
		ResponseStructure<List<Products>> rs=new ResponseStructure<>();
		rs.setstatuscode(HttpStatus.OK.value());
		rs.setMessage("Cart");
	    rs.setData(cart);
		return new ResponseEntity<ResponseStructure<List<Products>>>(rs,HttpStatus.OK);
		
	}

	public ResponseEntity<ResponseStructure<List<Products>>> removeProdFromCart(long mob, int id) {
		Customer c=custrepo.findByMob(mob).orElseThrow(()->new CustomerNotFoundException());
		Products p=prodrepo.findById(id).orElseThrow(()->new ProductNotFoundException());
		c.getCart().remove(p);
		custrepo.save(c);
		ResponseStructure<List<Products>> rs=new ResponseStructure<>();
		rs.setstatuscode(HttpStatus.OK.value());
		rs.setMessage("Product Removed from cart");
	    rs.setData(c.getCart());
		return new ResponseEntity<ResponseStructure<List<Products>>>(rs,HttpStatus.OK);
		
	}
	@Autowired
	private OrderRepo orepo;
	
	public ResponseEntity<ResponseStructure<List<Orders>>> placeOrder(long mob, int addid) {
		Customer c=custrepo.findByMob(mob).orElseThrow(()->new CustomerNotFoundException());
		List<Address> alist=c.getAddress();
		Address add=new Address();
		for(Address a:alist) {
			if(a.getId()==addid) {
				add=a;
			}
		}
		
		if (c.getCart().isEmpty()) {
		    throw new RuntimeException("Cart is empty. Cannot place order.");
		}
		
		List<Products> plist = new ArrayList<>(c.getCart());
		for(Products p1:plist) {
			Products p=prodrepo.findById(p1.getId()).orElseThrow(()->new ProductNotFoundException());
			p.setQuantity(p.getQuantity()-1);
			prodrepo.save(p);
		}
		
		int sum=0;
		for(Products p:plist) {
			sum+=p.getPriceperUnit();
		}
		Orders o=new Orders();
		o.setCust(c);
		o.setDate(LocalDate.now());
		o.setDeliveryloc(add);
		o.setExpecteddeliverydate(LocalDate.now().plusDays(3));
		o.setPurchaselist(plist);
		o.setTotalprice(sum);
		
		//OTP
		Random random=new Random();
		int otp=999+random.nextInt(9000);
		o.setOtp(otp);
		orepo.save(o);
		c.getOrders().add(o);
		c.getCart().clear();
		custrepo.save(c);
		
		
		ResponseStructure<List<Orders>> rs=new ResponseStructure<>();
		rs.setstatuscode(HttpStatus.OK.value());
		rs.setMessage("Order Placed");
	    rs.setData(c.getOrders());
		return new ResponseEntity<ResponseStructure<List<Orders>>>(rs,HttpStatus.OK);
		
	}
	
	public ResponseEntity<ResponseStructure<Customer>> getCustDetails(long mob) {
		Customer c=custrepo.findByMob(mob).orElseThrow(()->new CustomerNotFoundException());
		
		ResponseStructure<Customer> rs=new ResponseStructure<>();
		rs.setstatuscode(HttpStatus.OK.value());
		rs.setMessage("Customer Details");
		rs.setData(c);
		return new ResponseEntity<ResponseStructure<Customer>>(rs,HttpStatus.FOUND);
	}
	
	public ResponseEntity<ResponseStructure<List<Orders>>> seePendingOrders() {
		 List<Orders> plist = orepo.findByOrderStatus("Pending");

		    if (plist.isEmpty()) {
		        throw new PendingOrderNotFoundException();
		    }
		    
		    ResponseStructure<List<Orders>> rs = new ResponseStructure<>();
		    rs.setstatuscode(HttpStatus.OK.value());
		    rs.setMessage("Pending Orders");
		    rs.setData(plist);

		    return new ResponseEntity<>(rs, HttpStatus.OK);
		    
	}
	
	public ResponseEntity<ResponseStructure<Carrier>> assignCarrier(int ordid, long carriermobno, int addid)  {
		Carrier c=carrierrepo.findByMob(carriermobno).orElseThrow(()->new CarrierNotFoundException());
		Address a=addrepo.findById(addid).orElseThrow(()->new AddressNotFoundException());
		Orders o=orepo.findById(ordid).orElseThrow(()->new OrderNotFoundException());
		if(!o.getOrderStatus().equals("Pending")){
			throw new PendingOrderNotFoundException();
			}
		
		 if (c.getCapacity() <= 0) {
		        throw new CarrierCapacityException();
		    }
		o.setCarrier(c);
		o.setOrderStatus("Confirmed");
		o.setPickuploc(a);
		c.getOrders().add(o);
		c.setCapacity(c.getCapacity()-1);
		carrierrepo.save(c);
		orepo.save(o);
		
		ResponseStructure<Carrier> rs = new ResponseStructure<>();
	    rs.setstatuscode(HttpStatus.OK.value());
	    rs.setMessage("Carrier Details");
	    rs.setData(c);

	    return new ResponseEntity<>(rs, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<List<CarrierOrderDTO>>> seeActiveOrders(long mob){
		Carrier c=carrierrepo.findByMob(mob).orElseThrow(()->new CarrierNotFoundException());
		List<CarrierOrderDTO> confirmedlist=new ArrayList<>();
		for(Orders o:c.getOrders()) {
			if(o.getOrderStatus().equals("Confirmed"));
			CarrierOrderDTO dto=new CarrierOrderDTO();
			dto.setCustname(o.getCust().getName());
			dto.setCustmobno(o.getCust().getMob());
			dto.setDeliveryloc(o.getDeliveryloc());
			dto.setId(o.getId());
			dto.setPickuploc(o.getPickuploc());
			confirmedlist.add(dto);
		}
		
		ResponseStructure<List<CarrierOrderDTO>> rs = new ResponseStructure<>();
	    rs.setstatuscode(HttpStatus.OK.value());
	    rs.setMessage("Active Orders");
	    rs.setData(confirmedlist);
	    return new ResponseEntity<>(rs,HttpStatus.OK);	   
		}
	
	public ResponseEntity<ResponseStructure<String>> confirmDelivery(int ordid, int otp) {
		Orders o=orepo.findById(ordid).orElseThrow(()->new OrderNotFoundException());
		if (otp != o.getOtp()) {
	        throw new InvalidOtpException();
	    }
		 o.setOrderStatus("Delivered");
		    Carrier carrier = o.getCarrier();
		    carrier.setCapacity(carrier.getCapacity() + 1);
		    orepo.save(o);
		    carrierrepo.save(carrier);
		ResponseStructure<String> rs = new ResponseStructure<>();
	    rs.setstatuscode(HttpStatus.OK.value());
	    rs.setMessage("Order Delivered");
	    rs.setData("Order Delivered of id :"+ordid);
	    return new ResponseEntity<>(rs,HttpStatus.OK);	   
		}

		
		
	}

	
	






