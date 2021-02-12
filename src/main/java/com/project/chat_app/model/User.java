package com.project.chat_app.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private Date joiningTime;

    public User() {
    }

    public User(String name, Date joiningTime) {
        this.name = name;
        this.joiningTime = joiningTime;
    }
}
