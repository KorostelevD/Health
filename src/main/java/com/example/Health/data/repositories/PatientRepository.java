package com.example.Health.data.repositories;

import com.example.Health.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Stream;

public interface    PatientRepository extends JpaRepository<Patient, Integer> {
    List<Patient> findAllBySurnameAndNameAndPatronymic (String surname, String name, String patronymic);

    List<Patient> findBySurnameIgnoreCaseAndNameAndGenderNot(String surname, String name, Patient.Gender gender);

    List<Patient> findByEmail(String email);

    long countByGenderNot(Patient.Gender gender);

    Stream<Patient> findByGenderNot(Patient.Gender gender);
    /*Stream<Patient> findByGenderNot (Patient.Gender gender);
    Stream<Patient> findGender (Patient.Gender gender);
    long countByGenderNot (Patient.Gender gender);*/

}
