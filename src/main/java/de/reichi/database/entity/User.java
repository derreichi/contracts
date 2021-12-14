package de.reichi.database.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstname;

    private String surename;

    private String password;

    @Email(regexp = ".+@.+\\..+", message = "An email has to look like an email!!!")
    //@Column (unique = true) // 1 Email = 1 User
    private String email;

    private String role;
}
