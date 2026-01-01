package com.project.E_Commerce.ControllerLayer;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.E_Commerce.DTO.CarrierDTO;
import com.project.E_Commerce.DTO.CarrierOrderDTO;

import com.project.E_Commerce.Entities.Orders;
import com.project.E_Commerce.Response.ResponseStructure;
import com.project.E_Commerce.ServiceLayer.ServiceLayer;

@RestController
@RequestMapping("/carrier")
public class CarrierController {
	@Autowired
	private ServiceLayer s;
	@GetMapping("/seeactiveorders/{carriermob}")
	public ResponseEntity<ResponseStructure<List<CarrierOrderDTO>>> seeActiveOrders(@PathVariable long carriermob){
		return s.seeActiveOrders(carriermob);
	}

	@PatchMapping("/updateorder/confirmdelivery/{ordid}/{otp}")
	public ResponseEntity<ResponseStructure<String>> confirmDelivery(@PathVariable int ordid,@PathVariable int otp){
		return s.confirmDelivery(ordid,otp);
	}
}
