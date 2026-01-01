package com.project.E_Commerce.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.E_Commerce.Entities.Admin;
@Repository
public interface AdminRepo  extends JpaRepository<Admin, Integer>{
	
	Optional<Admin> findByMob(long mob);
}
