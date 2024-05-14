package com.davidamaya.appointmentform.app.models.services.patient;

import com.davidamaya.appointmentform.app.models.dao.IPatientDao;
import com.davidamaya.appointmentform.app.models.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PatientServiceImpl implements IPatientService{

    @Autowired
    private IPatientDao patientDao;
    @Override
    @Transactional(readOnly = true)
    public List<Patient> findAll() {
        return (List<Patient>) patientDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Patient> findAll(Pageable pageable) {
        return patientDao.findAll(pageable);
    }

    @Override
    public void save(Patient patient) {
        patientDao.save(patient);
    }

    @Override
    public Patient findOne(Long id) {
        return patientDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        patientDao.deleteById(id);
    }
}
