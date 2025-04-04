package com.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class EmsSite {
    @Id
    private Long id;
    private String name;
    private String address;
    private String city;
    private Long regionId;
    private boolean status;
}
