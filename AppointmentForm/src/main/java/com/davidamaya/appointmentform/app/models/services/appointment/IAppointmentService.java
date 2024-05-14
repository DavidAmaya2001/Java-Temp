package com.davidamaya.appointmentform.app.models.services.appointment;

import com.davidamaya.appointmentform.app.models.entity.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAppointmentService {

    public List<Appointment> findAll();
    public Page<Appointment> findAll(Pageable pageable);
    public void save(Appointment appointment);
    public Appointment findOne(Long id);
    public void delete(Long id);
}
