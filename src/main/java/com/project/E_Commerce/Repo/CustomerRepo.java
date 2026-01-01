package com.project.E_Commerce.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.E_Commerce.Entities.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	Optional<Customer> findByMob(long mob);

}
