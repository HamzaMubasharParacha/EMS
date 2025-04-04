package com.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Consumption {
    @Id
    private Long id;
    private LocalDateTime recordedTime;
    private String consumptionUnit;
    private Long deviceId;
    private BigDecimal consumption;
}
