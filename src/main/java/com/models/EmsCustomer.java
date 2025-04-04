package com.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class EmsCustomer {
    @Id
    private Long id;
    private String name;
    private String lastName;
    private String company;
    private String address;
    private Long siteId;
    private boolean status;
}

