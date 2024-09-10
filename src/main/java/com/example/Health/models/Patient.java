package com.example.Health.models;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//
@Entity
@Table(name = "patients")
@ToString
@EqualsAndHashCode

public class Patient {
    public enum Gender{
        NONE,
        MALE,
        FEMALE
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    // Поля пацієнта
    @Column(length = 50, nullable = false)
    private String surname;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 50, nullable = false)
    private String patronymic;
    @Column(nullable = false, columnDefinition = "int(1) default 0")
    private Gender gender;
    @Column(nullable = false)
    private Date birthDate;
    @Column(nullable = false)
    private String phonenumber;
    @Column(nullable = false)
    private String email;
}
