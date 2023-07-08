package com.gl.student.tracker.lab6.model;

import lombok.Data;

import javax.persistence.*;
@Entity
@Table(name = "TBL_ROLES")
@Data
public class Role {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;
}
