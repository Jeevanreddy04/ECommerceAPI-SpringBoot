package com.project.E_Commerce.Repo;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.E_Commerce.Entities.Carrier;

public interface CarrierRepo extends JpaRepository<Carrier, Integer> {
	
	Optional<Carrier> findByMob(long mob);

}
