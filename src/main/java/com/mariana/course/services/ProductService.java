package com.mariana.course.services;

import com.mariana.course.entities.Product;
import com.mariana.course.entities.User;
import com.mariana.course.repositories.ProductRepository;
import com.mariana.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<Product> findAll(){
        return repo.findAll();
    }

    public Product findById(Long id){
        Optional<Product> obj = repo.findById(id);
        return obj.get();
    }
}
