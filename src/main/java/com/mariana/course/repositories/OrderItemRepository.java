package com.mariana.course.repositories;

import com.mariana.course.entities.Category;
import com.mariana.course.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
