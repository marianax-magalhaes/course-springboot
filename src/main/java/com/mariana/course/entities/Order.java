package com.mariana.course.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@NoArgsConstructor
@Data
@Entity
@Table(name="tb_order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private Instant moment;

//    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name="client_id")
    private User customer;

    public Order(Long id, Instant moment, User customer) {
        this.id = id;
        this.moment = moment;
        this.customer = customer;
    }
}
