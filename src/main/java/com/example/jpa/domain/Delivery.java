package com.example.jpa.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter@Setter
public class Delivery {

    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private  Long id;

    @OneToOne(mappedBy = "delivery",fetch = LAZY)
    private Order order;

    @Embedded
    private Adress adress;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status; //REATY, COMP
}
