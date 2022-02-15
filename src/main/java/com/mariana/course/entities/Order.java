package com.mariana.course.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="tb_order")
public class Order implements Serializable {

    @Id
    private Long id;

    private Instant moment;

    @ManyToOne
    @JoinColumn(name="client_id")
    private User customer;
}
