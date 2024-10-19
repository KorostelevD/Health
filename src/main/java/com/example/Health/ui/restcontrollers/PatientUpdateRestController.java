package com.example.Health.ui.restcontrollers;

import com.example.Health.data.services.PatientService;
import com.example.Health.data.services.ProcedureService;
import com.example.Health.data.services.qualifiers.PatientServiceDbQualifier;
import com.example.Health.models.Patient;
import com.example.Health.models.Procedure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PatientUpdateRestController {
    @Autowired
    ProcedureService procedureService;

    @Autowired
    @PatientServiceDbQualifier
    PatientService patientService;




    //@RequestMapping()
    @PostMapping("/rest/procedureUpdateForm")

    public ResponseEntity<?> procedureUpdateForm(@RequestBody Procedure procedure) {

        Integer PatientNum = procedure.getPatient().getId();
        System.err.println("!!! procedureUpdateForm");
        System.err.println(procedure);

        //Збереження в базі даних
            Optional<Patient> optionalPatient = patientService.findById(PatientNum);
            Patient patient = optionalPatient.get();
            System.err.println(patient.getId());
            procedure = procedureService.save(procedure);
            procedure.setPatient(patient);
            procedureService.save(procedure);
          return new ResponseEntity<>(HttpStatus.OK);
    }

}
