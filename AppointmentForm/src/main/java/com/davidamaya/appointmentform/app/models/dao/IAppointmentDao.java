package com.davidamaya.appointmentform.app.models.dao;

import com.davidamaya.appointmentform.app.models.entity.Appointment;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IAppointmentDao extends PagingAndSortingRepository<Appointment, Long> {
}
