package com.example.Health.models;

import jakarta.persistence.*;
import lombok.*; //імпорт бібліотеки Lombok, яка автоматично генерує такі методи, як getter, setter, toString, конструктори тощо, з відповідними анотаціями.

import java.sql.Date;

@Data
@Getter
@Setter

@NoArgsConstructor //Генерує конструктор без аргументів. Це означає, що при створенні об'єкта класу можна буде створити його без передавання жодних значень у конструктор.
@AllArgsConstructor //Генерує конструктор, який приймає аргументи для всіх полів класу. Це означає, що при створенні об'єкта класу можна буде передати значення для всіх його атрибутів.
@RequiredArgsConstructor // не додавати null

@Table(name = "procedures")
@ToString //@ToString є частиною бібліотеки Lombok і автоматично генерує метод toString() для класу. Метод toString() відповідає за повернення текстового представлення об'єкта класу, що включає значення його полів.
@EqualsAndHashCode

@Entity //Ця анотація позначає клас як сутність для JPA, що означає, що його екземпляри будуть зберігатися в базі даних.


public class Procedure {
    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //@NonNull
    //@Column(nullable = false)
    //private Date proceduresDate;
    @NonNull
    @Column(nullable = false)
    private String procedures;

    //Багато різних процедур у одного пацієнта
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = true,
            foreignKey = @ForeignKey(name ="FK_procedures_patients" ))
    private Patient patient;


}
