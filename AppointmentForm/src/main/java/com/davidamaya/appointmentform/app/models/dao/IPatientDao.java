package com.davidamaya.appointmentform.app.models.dao;

import com.davidamaya.appointmentform.app.models.entity.Patient;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IPatientDao extends PagingAndSortingRepository<Patient, Long> {
}
