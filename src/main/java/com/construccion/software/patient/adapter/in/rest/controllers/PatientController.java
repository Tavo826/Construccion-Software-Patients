package com.construccion.software.patient.adapter.in.rest.controllers;

import com.construccion.software.patient.adapter.in.builder.PatientBuilder;
import com.construccion.software.patient.adapter.in.rest.request.PatientRequest;
import com.construccion.software.patient.application.usecases.PatientUseCase;
import com.construccion.software.patient.domain.models.Patient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/patients")
public class PatientController {

    private final PatientBuilder patientBuilder;
    private final PatientUseCase patientUseCase;

    public PatientController(PatientBuilder patientBuilder, PatientUseCase patientUseCase) {
        this.patientBuilder = patientBuilder;
        this.patientUseCase = patientUseCase;
    }

    @GetMapping
    public ResponseEntity<?> getAllPatients() throws Exception {

        List<Patient> patientList = patientUseCase.getAllPatient();

        return ResponseEntity.ok(patientList);
    }

    @GetMapping("/{documentId}")
    public ResponseEntity<?> getPatientByDocumentId(@PathVariable String documentId) throws Exception {

        Patient patient = patientUseCase.getPatientByDocumentId(patientBuilder.getDocumentId(documentId));

        return ResponseEntity.ok(patient);
    }

    @PostMapping("")
    public ResponseEntity<?> createPatient(@RequestBody PatientRequest request) throws Exception {

        Patient patient = patientBuilder.build(request);

        Patient createdPatient = patientUseCase.createPatient(patient);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdPatient);
    }

    @PatchMapping("")
    public ResponseEntity<?> updatePatient(@RequestBody PatientRequest request) throws Exception {

        Patient patient = patientBuilder.build(request);

        Patient updatedPatient = patientUseCase.updatePatient(patient);

        return ResponseEntity.ok(updatedPatient);
    }

    @DeleteMapping("/{documentId}")
    public ResponseEntity<?> deletePatient(@PathVariable String documentId) throws Exception {

        patientUseCase.deletePatient(patientBuilder.getDocumentId(documentId));

        return ResponseEntity.noContent().build();
    }
}
