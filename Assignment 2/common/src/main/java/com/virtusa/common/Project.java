package com.virtusa.common;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "project")
@Data
public class Project {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private BigDecimal budget;
    private Date startDate;
    private Date endDate;
    private String projectManagerName;
    private String clientName;
    private boolean isActive;

}
