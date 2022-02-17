package com.mariana.course.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name="tb_product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;

//    usando set ao inves de lista para garantir que nao teremos categoria repetida
//    instanciando para a colecao comecar vazia e nao nula
    @ManyToMany
    @JoinTable(name = "tb_product_category", joinColumns = @JoinColumn(name="product_id"), inverseJoinColumns = @JoinColumn(name="category_id)"))
    private Set<Category> categories = new HashSet<>();

    @OneToMany(mappedBy="id.product")
    private Set<OrderItem> items = new HashSet<>();

    @JsonIgnore
    public Set<Order> getOrders(){
        Set<Order> set = new HashSet<>();
        for(OrderItem x : items){
            set.add(x.getOrder());
        }
        return set;
    }

    public Product(Long id, String name, String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }
}
