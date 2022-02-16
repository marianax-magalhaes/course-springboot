package com.mariana.course.entities;

import lombok.Getter;

public enum OrderStatus {

    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    @Getter
    private int code;

    private OrderStatus(int code){
        this.code = code;
    }

//    static pq nao precisa instanciar
    public static OrderStatus valueOf(int code){
        for (OrderStatus value : OrderStatus.values()){
            if(value.getCode() == code){
                return value;
            }
        } throw new IllegalArgumentException("Invalid order status code.");
    }


}
