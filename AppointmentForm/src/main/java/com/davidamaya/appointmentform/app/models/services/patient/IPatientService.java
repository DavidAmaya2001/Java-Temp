package com.davidamaya.appointmentform.app.models.services.patient;

import com.davidamaya.appointmentform.app.models.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPatientService {
    public List<Patient> findAll();
    public Page<Patient> findAll(Pageable pageable);
    public void save(Patient patient);
    public Patient findOne(Long id);
    public void delete(Long id);
}
