package com.example.Health.data.services.qualifiers;


import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Qualifier("patientServiceJson")
@Retention(RetentionPolicy.RUNTIME) //час роботи
@Target({FIELD, METHOD, PARAMETER, TYPE})

public @interface PatientServiceJsonQualifier {
}
