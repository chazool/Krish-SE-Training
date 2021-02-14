package com.chazool.common.taskservice;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task")
@Data
public class Task {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int projectId;
    private boolean isActive;

}
