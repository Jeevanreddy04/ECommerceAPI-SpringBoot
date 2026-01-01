package com.project.E_Commerce.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.E_Commerce.Entities.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {
	
	

}
