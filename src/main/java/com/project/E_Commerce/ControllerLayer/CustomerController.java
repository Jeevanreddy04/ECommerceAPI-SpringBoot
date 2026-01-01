package com.project.E_Commerce.ControllerLayer;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.E_Commerce.DTO.CustomerDTO;
import com.project.E_Commerce.Entities.Address;
import com.project.E_Commerce.Entities.Carrier;
import com.project.E_Commerce.Entities.Customer;
import com.project.E_Commerce.Entities.Orders;
import com.project.E_Commerce.Entities.Products;
import com.project.E_Commerce.Response.ResponseStructure;
import com.project.E_Commerce.ServiceLayer.ServiceLayer;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private ServiceLayer s;
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(@Valid @RequestBody CustomerDTO c){
		return s.saveCustomer(c);
	}
	
	@PatchMapping("/addaddress/{mob}")
	public ResponseEntity<ResponseStructure<Customer>> addAddress(@PathVariable long mob,@RequestBody Address a){
		return s.addCustAddress(mob,a);
	}
	
	@GetMapping("/getallcustadd/{mob}")
	public ResponseEntity<ResponseStructure<List<Address>>> getallcustadd(@PathVariable long mob){
		return s.getAllCustAdd(mob);
	}
	
	@DeleteMapping("/deleteadd/{mob}/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteAdd(@PathVariable long mob,@PathVariable int id){
		return s.deleteAdd(mob,id);
	}
	
	@GetMapping("/seeallproducts/{status}")
	public ResponseEntity<ResponseStructure<List<Products>>> seeAllProducts(@PathVariable String status){
		return s.seeAllProducts(status);
	}
	
	@PatchMapping("/addprodtocart/{mob}/{id}")
	public ResponseEntity<ResponseStructure<Customer>> addProdToCart(@PathVariable long mob,@PathVariable int id){
		return s.addProdToCart(mob,id);
	}
	
	@GetMapping("/seecart/{mob}")
	public ResponseEntity<ResponseStructure<List<Products>>> seeCart(@PathVariable long mob){
		return s.seeCart(mob);
	}
	
	@DeleteMapping("/removeprodfromcart/{mob}/{id}")
	public ResponseEntity<ResponseStructure<List<Products>>> removeProdFromCart(@PathVariable long mob,@PathVariable int id){
		return s.removeProdFromCart(mob,id);
	}
	
	@PatchMapping("/placeorder/{mob}/{addid}")
	public ResponseEntity<ResponseStructure<List<Orders>>> placeOrder(@PathVariable long mob,@PathVariable int addid){
		return s.placeOrder(mob,addid);
	}
	
	@GetMapping("/getcust/{mob}")
	 public ResponseEntity<ResponseStructure<Customer>> getCustomerdetails(@PathVariable long mob){
		return s.getCustDetails(mob);
		
	}
}
