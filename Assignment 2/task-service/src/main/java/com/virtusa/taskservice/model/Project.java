package com.virtusa.taskservice.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Project {

    private int id;
    private String name;
    private BigDecimal budget;
    private Date startDate;
    private Date endDate;
    private String projectManagerName;
    private String clientName;
    private boolean isActive;

}
