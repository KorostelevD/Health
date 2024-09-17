package com.example.Health.models;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;

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

    //
    @OneToOne (fetch = FetchType.LAZY)
    private LabResult labResult;
    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private List<Procedure> procedures;
    //

    @ManyToMany (fetch = FetchType.LAZY)
    @JoinTable (
            name = "patients_doctors",
            joinColumns = @JoinColumn(name = "patient_id", nullable = false, foreignKey = @ForeignKey (name = "FK_patients")),
            inverseJoinColumns = @JoinColumn(name = "doctor_id", nullable = false, foreignKey = @ForeignKey (name = "FK_doctors"))
    )
    private List<Doctor> doctors;
}
