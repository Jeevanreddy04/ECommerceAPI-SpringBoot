	package com.project.E_Commerce.Exceptions;

	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.ExceptionHandler;
	import org.springframework.web.bind.annotation.RestControllerAdvice;

	import com.project.E_Commerce.Exceptions.*;
	import com.project.E_Commerce.Response.ResponseStructure;

	@RestControllerAdvice
	public class GlobalExceptionHandler {

	    @ExceptionHandler({
	        AdminNotFoundException.class,
	        CarrierNotFoundException.class,
	        CustomerNotFoundException.class,
	        OrderNotFoundException.class,
	        ProductNotFoundException.class,
	        AddressNotFoundException.class
	    })
	    public ResponseEntity<ResponseStructure<String>> handleNotFound(RuntimeException ex) {
	        ResponseStructure<String> rs = new ResponseStructure<>();
	        rs.setstatuscode(HttpStatus.NOT_FOUND.value());
	        rs.setMessage(ex.getMessage());
	        rs.setData("Resource not found");
	        return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);
	    }

	    @ExceptionHandler( PendingOrderNotFoundException.class)
	    public ResponseEntity<ResponseStructure<String>> handleBadRequest(RuntimeException ex) {
	        ResponseStructure<String> rs = new ResponseStructure<>();
	        rs.setstatuscode(HttpStatus.BAD_REQUEST.value());
	        rs.setMessage(ex.getMessage());
	        rs.setData("Pending Orders Not Found");
	        return new ResponseEntity<>(rs, HttpStatus.BAD_REQUEST);
	    }
	    
	    @ExceptionHandler(CarrierCapacityException.class)
	    public ResponseEntity<ResponseStructure<String>> handleCarrierCapacity(
	            CarrierCapacityException ex) {

	        ResponseStructure<String> rs = new ResponseStructure<>();
	        rs.setstatuscode(HttpStatus.BAD_REQUEST.value());
	        rs.setMessage(ex.getMessage());
	        rs.setData("Carrier capacity exceeded");

	        return new ResponseEntity<>(rs, HttpStatus.BAD_REQUEST);
	    }


	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<ResponseStructure<String>> handleGlobal(Exception ex) {
	        ResponseStructure<String> rs = new ResponseStructure<>();
	        rs.setstatuscode(HttpStatus.INTERNAL_SERVER_ERROR.value());
	        rs.setMessage("Internal Server Error");
	        rs.setData(ex.getMessage());
	        return new ResponseEntity<>(rs, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

