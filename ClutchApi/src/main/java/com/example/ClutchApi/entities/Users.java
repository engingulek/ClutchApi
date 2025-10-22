package com.example.ClutchApi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "users") // user tablo adı özel karakter olduğu için tırnak zorunlu
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Column(name = "namesurname", nullable = false)
    private String nameSurname;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;
}
