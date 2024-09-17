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
    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    // Поля пацієнта
    @NonNull
    @Column(length = 50, nullable = false)
    private String surname;
    @NonNull
    @Column(length = 50, nullable = false)
    private String name;
    @NonNull
    @Column(length = 50, nullable = false)
    private String patronymic;
    @NonNull
    @Column(nullable = false, columnDefinition = "int(1) default 0")
    private Gender gender;
    @NonNull
    @Column(nullable = false)
    private Date birthDate;
    @NonNull
    @Column(nullable = false)
    private String phonenumber;
    @NonNull
    @Column(nullable = false)
    private String email;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    //У кожного пацієнта окремий результат аналізів
    @OneToOne (fetch = FetchType.LAZY)
    private LabResult labResult;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    //У кожного пацієнта окремий медичний запис
    @OneToOne (fetch = FetchType.LAZY)
    private MedicalRecord medicalRecord;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    //У кожного пацієнта окрема оплата
    @OneToOne (fetch = FetchType.LAZY)
    private Payment payment;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    //У одного пацєнта може бути багато різних процедур
    @OneToMany(mappedBy = "patients", fetch = FetchType.LAZY)
    private List<Procedure> procedures;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    //Багато до багатьох, багато лікарів, багато пацієнтів
    @ManyToMany (fetch = FetchType.LAZY)
    @JoinTable (
            name = "patients_doctors",
            joinColumns = @JoinColumn(name = "patient_id", nullable = false, foreignKey = @ForeignKey (name = "FK_patients")),
            inverseJoinColumns = @JoinColumn(name = "doctor_id", nullable = false, foreignKey = @ForeignKey (name = "FK_doctors"))
    )
    private List<Doctor> doctors;
}
