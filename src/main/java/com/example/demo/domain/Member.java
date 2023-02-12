package com.example.demo.domain;

import jdk.jfr.Enabled;

import javax.persistence.*;

@Entity

// DB에 Table 역할을 함
public class Member {

    // Id 어노테이션을 통해 pk 설정
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
