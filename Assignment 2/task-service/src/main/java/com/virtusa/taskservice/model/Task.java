package com.virtusa.taskservice.model;

import lombok.Data;

import javax.persistence.*;

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
