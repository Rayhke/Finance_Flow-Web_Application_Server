package com.example.DataBase.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    private String id;

    private String pwd;

    public void update(String pwd) {
        this.pwd = pwd;
    }
}
