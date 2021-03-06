package com.mariana.course.services;

import com.mariana.course.entities.User;
import com.mariana.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = repo.findById(id);
        return obj.get();
    }

    public User insert(User obj){
        return repo.save(obj);
    }

    public void delete(Long id){
        repo.deleteById(id);
    }

    public User update(Long id, User obj){
        User entity = repo.getOne(id);
        updateData(entity, obj);
        return repo.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
