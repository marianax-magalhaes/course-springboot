package com.mariana.course.config;

import com.mariana.course.entities.User;
import com.mariana.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
//commandlinerunner indica que deve ser executado assim que o programa rodar
    @Autowired
    private UserRepository repo;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "33334444", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "33335555", "123456");

        repo.saveAll(Arrays.asList(u1,u2));
    }
}
