package com.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class EmsRegion {
    @Id
    private Long id;
    private String name;
    private boolean status;
}
