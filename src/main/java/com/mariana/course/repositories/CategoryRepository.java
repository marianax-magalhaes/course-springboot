package com.mariana.course.repositories;

import com.mariana.course.entities.Category;
import com.mariana.course.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
