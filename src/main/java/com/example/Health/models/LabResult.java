package com.example.Health.models;

import jakarta.persistence.*;
import lombok.*; //імпорт бібліотеки Lombok, яка автоматично генерує такі методи, як getter, setter, toString, конструктори тощо, з відповідними анотаціями.

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor //Генерує конструктор без аргументів. Це означає, що при створенні об'єкта класу можна буде створити його без передавання жодних значень у конструктор.
@AllArgsConstructor //Генерує конструктор, який приймає аргументи для всіх полів класу. Це означає, що при створенні об'єкта класу можна буде передати значення для всіх його атрибутів.
@RequiredArgsConstructor // не додавати null

@Table(name = "labresults")
@ToString //@ToString є частиною бібліотеки Lombok і автоматично генерує метод toString() для класу. Метод toString() відповідає за повернення текстового представлення об'єкта класу, що включає значення його полів.
@EqualsAndHashCode

@Entity //Ця анотація позначає клас як сутність для JPA, що означає, що його екземпляри будуть зберігатися в базі даних.


public class LabResult {
    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    @Column(nullable = false)
    private Date resultDate;
    @NonNull
    @Column(nullable = false)
    private String result;

    //У кожного пацієнта окремий результат аналізів
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne (mappedBy = "labResult")
    private Patient patient;



}
