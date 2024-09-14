package com.example.Health.data.repositories; //Визначає простір імен (namespace), до якого належить цей клас. Це дозволяє логічно організувати класи в проєкті.


import com.example.Health.models.LabResult; // Імпортує модель (сущність) LabResult, яка, ймовірно, відповідає таблиці в базі даних, що зберігає результати лабораторних аналізів.
import org.springframework.data.jpa.repository.JpaRepository; // import org.springframework.data.jpa.repository.JpaRepository; – Імпортує інтерфейс JpaRepository, який надає базові CRUD-операції для взаємодії з базою даних.

/*
LabResultRepository – Це інтерфейс, який успадковує JpaRepository. Цей інтерфейс автоматично надає основні методи для роботи з базою даних, такі як:

save() – для збереження нових записів або оновлення існуючих.
findById() – для пошуку запису за ідентифікатором.
findAll() – для отримання всіх записів.
delete() – для видалення записів.
*/

//extends JpaRepository<LabResult, Integer> – Вказує, що цей репозиторій працює з сутністю LabResult (тобто, таблицею в базі даних) і використовує Integer як тип ідентифікатора (ID) для кожного запису.


public interface LabResultRepository extends JpaRepository <LabResult, Integer> {
}

