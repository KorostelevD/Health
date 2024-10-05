package com.example.Health.models;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Getter
@Setter

@NoArgsConstructor //Генерує конструктор без аргументів. Це означає, що при створенні об'єкта класу можна буде створити його без передавання жодних значень у конструктор.
@AllArgsConstructor //Генерує конструктор, який приймає аргументи для всіх полів класу. Це означає, що при створенні об'єкта класу можна буде передати значення для всіх його атрибутів.


@Table(name = "program_news")
@ToString
@EqualsAndHashCode


@Entity
public class ProgramNews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    private LocalDate createdAt;
    private LocalDate updatedAt;
}
