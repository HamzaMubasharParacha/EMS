package com.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class EmsDevice {
    @Id
    private Long id;
    private Long origin;
    private String name;
    private String description;
    private String installationDate;
    private String installedBy;
    private String lastChecked;
    private String model;
    private String manufacturer;
    private String serialId;
    private Long siteId;
    private String powerSource;
    private boolean status;
}
