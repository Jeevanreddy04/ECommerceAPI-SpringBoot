package com.project.E_Commerce.Repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.E_Commerce.Entities.Products;

public interface Productrepo extends JpaRepository<Products, Integer> {
	
	List<Products> findAllByAvailableStatus(String status);

}
