package com.example.Health.data.services.qualifiers;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


//@Target(value = {})
//@Autowired
//
@Qualifier("patientServiceDb")
@Retention(RetentionPolicy.RUNTIME) //час роботи
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE})
public @interface PatientServiceQualifier {



}
