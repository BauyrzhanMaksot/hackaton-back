package com.example.epam1;

import javax.persistence.*;

/**
 * Created by Bauka on 16-Mar-19
 */
@Entity
@Table(name = "role")
public class Role {

    private Long id;
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}