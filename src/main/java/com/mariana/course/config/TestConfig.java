package com.mariana.course.config;

import com.mariana.course.entities.*;
import com.mariana.course.repositories.CategoryRepository;
import com.mariana.course.repositories.OrderRepository;
import com.mariana.course.repositories.ProductRepository;
import com.mariana.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
//commandlinerunner indica que deve ser executado assim que o programa rodar
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    @Autowired
    private ProductRepository prodRepo;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "33334444", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "33335555", "123456");

        Order o1 = new Order(null, Instant.parse("2022-02-16T10:53:07Z"), u1, OrderStatus.PAID);
        Order o2 = new Order(null, Instant.parse("2022-01-15T12:58:07Z"), u1, OrderStatus.WAITING_PAYMENT);
        Order o3 = new Order(null, Instant.parse("2021-12-20T09:15:07Z"), u2, OrderStatus.DELIVERED);

        Category cat1 = new Category(null, "Eletronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Product p1 = new Product(null, "Harry Potter", "descrição", 20.00, "");
        Product p2 = new Product(null, "Dell", "descrição", 21.00, "");
        Product p3 = new Product(null, "TV Samsung", "descrição", 22.00, "");
        Product p4 = new Product(null, "Kindle", "descrição", 23.00, "");

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat1);
        p4.getCategories().add(cat1);

        userRepo.saveAll(Arrays.asList(u1,u2));
        orderRepo.saveAll(Arrays.asList(o1,o2,o3));
        categoryRepo.saveAll(Arrays.asList(cat1, cat2, cat3));
        prodRepo.saveAll(Arrays.asList(p1,p2,p3,p4));
    }
}
