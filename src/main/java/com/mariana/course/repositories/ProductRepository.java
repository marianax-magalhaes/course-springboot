package com.mariana.course.repositories;

import com.mariana.course.entities.Product;
import com.mariana.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
