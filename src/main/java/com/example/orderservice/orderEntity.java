package com.example.orderservice;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table
public class orderEntity {
    @Id
    private long Id;
    private String name;
}
