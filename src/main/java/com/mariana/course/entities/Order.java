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

    private Integer orderStatus;

    @ManyToOne
    @JoinColumn(name="client_id")
    private User customer;

    public OrderStatus getOrderStatus(){
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus){
        if(orderStatus !=null){
            this.orderStatus = orderStatus.getCode();
        }
    }

    public Order(Long id, Instant moment, User customer, OrderStatus orderStatus) {
        this.id = id;
        this.moment = moment;
        this.customer = customer;
        setOrderStatus(orderStatus);
    }
}
