package com.project.E_Commerce.Repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.E_Commerce.Entities.Orders;

public interface OrderRepo extends JpaRepository<Orders, Integer> {
List<Orders> findByOrderStatus(String Status);

}
