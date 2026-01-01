package com.project.E_Commerce.ControllerLayer;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.E_Commerce.DTO.AddProductDto;
import com.project.E_Commerce.DTO.AdminDTO;
import com.project.E_Commerce.DTO.CarrierDTO;
import com.project.E_Commerce.Entities.Address;
import com.project.E_Commerce.Entities.Admin;
import com.project.E_Commerce.Response.ResponseStructure;
import com.project.E_Commerce.ServiceLayer.ServiceLayer;

import jakarta.validation.Valid;

import com.project.E_Commerce.Entities.*;

@RestController
@RequestMapping("/admin")
public class Controller {

	@Autowired
	private ServiceLayer s;
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@Valid @RequestBody AdminDTO a) {
		return s.saveAdmin(a);
	}
	
	@PatchMapping("/addaddress/{mob}")
	public ResponseEntity<ResponseStructure<Admin>> addAdminAddress(@PathVariable long mob,@Valid @RequestBody List<Address> add) {
		return s.addAdminAddress(mob,add);
	}
	
	@GetMapping("/getadmin/{mob}")
	public ResponseEntity<ResponseStructure<Admin>> getadmin(@PathVariable long mob){
		return s.getAdminByMob(mob);	
	}
	
	@DeleteMapping("/deleteadd/{adminId}/address/{addressId}")
	public ResponseEntity<ResponseStructure<Admin>> deleteAdminAddress(@PathVariable int adminId,
	                                 @PathVariable int addressId) {
	    return s.deleteAdminAddress(adminId, addressId);
	}

	
	@PostMapping("/savecarrier")
	public ResponseEntity<ResponseStructure<Carrier>> saveCarrier(@Valid @RequestBody CarrierDTO carrier) {
		return s.saveCarrier(carrier);
	}
	
	@GetMapping("/seeallcarriers")
	
	public ResponseEntity<ResponseStructure<List<Carrier>>> seeAllCarrier(){
		return s.seeAllcarrier();
	}
	
	
	@GetMapping("/findcarrier/{mob}")
	
	public  ResponseEntity<ResponseStructure<Carrier>> findCarrier(@PathVariable long mob){
		return s.findCarrier(mob);
	}
	
	@DeleteMapping("/deletecarrier/{mob}")
	public ResponseEntity<ResponseStructure<String>> deleteCarrier(@PathVariable long mob){
		return s.deleteCarrier(mob);
	}
	
	@PostMapping("/addproduct")
	public ResponseEntity<ResponseStructure<Products>> addProduct(@RequestBody AddProductDto p){
		return s.addProduct(p);
	}
	
	@GetMapping("/getproducts")
	public ResponseEntity<ResponseStructure<List<Products>>> getProducts(){
	return 	s.getAllProducts();
	}
	
	
	@PatchMapping("/updateproduct/{id}/{status}")
	public ResponseEntity<ResponseStructure<Products>> updateProduct(@PathVariable int id,@PathVariable String status){
		return s.updateProduct(id,status);
	}
	
	@GetMapping("/seependingorders")
	public ResponseEntity<ResponseStructure<List<Orders>>> seePendingOrders(){
		return s.seePendingOrders();
	}
	@PatchMapping("/updatecarrier/assigncarrier/{ordid}/{carriermobno}/{addid}")
	public ResponseEntity<ResponseStructure<Carrier>> assignCarrier(@PathVariable int ordid,@PathVariable long carriermobno,@PathVariable int addid){
		return s.assignCarrier(ordid,carriermobno,addid);
	}
	
	
}
