package com.construccion.software.patient.adapter.in.rest.controllers;

import com.construccion.software.patient.adapter.in.builder.PatientBuilder;
import com.construccion.software.patient.adapter.in.rest.request.PatientRequest;
import com.construccion.software.patient.application.usecases.PatientUseCase;
import com.construccion.software.patient.domain.models.Patient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientController {

    private final PatientBuilder patientBuilder;
    private final PatientUseCase patientUseCase;

    public PatientController(PatientBuilder patientBuilder, PatientUseCase patientUseCase) {
        this.patientBuilder = patientBuilder;
        this.patientUseCase = patientUseCase;
    }

    @GetMapping("/Patients/{documentId}")
    public ResponseEntity<?> getPatientByDocumentId(@PathVariable String documentId) throws Exception {

        Patient patient = patientUseCase.getPatientByDocumentId(patientBuilder.getDocumentId(documentId));

        return ResponseEntity.ok(patient);
    }

    @PostMapping("/Patients")
    public ResponseEntity<?> createPatient(@RequestBody PatientRequest request) throws Exception {

        Patient patient = patientBuilder.build(
                request.getDocumentId(),
                request.getName(),
                request.getGenre(),
                request.getAddress(),
                request.getPhone(),
                request.getEmail()
        );

        Patient createdPatient = patientUseCase.createPatient(patient);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdPatient);
    }

    @PatchMapping("/Patients")
    public ResponseEntity<?> updatePatient(@RequestBody PatientRequest request) throws Exception {

        Patient patient = patientBuilder.build(
                request.getDocumentId(),
                request.getName(),
                request.getGenre(),
                request.getAddress(),
                request.getPhone(),
                request.getEmail()
        );

        Patient updatedPatient = patientUseCase.updatePatient(patient);

        return ResponseEntity.ok(updatedPatient);
    }

    @DeleteMapping("/Patients/{documentId}")
    public ResponseEntity<?> deletePatient(@PathVariable String documentId) throws Exception {

        patientUseCase.deletePatient(patientBuilder.getDocumentId(documentId));

        return ResponseEntity.noContent().build();
    }
}
