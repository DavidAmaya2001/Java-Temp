package com.davidamaya.appointmentform.app.models.services.appointment;

import com.davidamaya.appointmentform.app.models.dao.IAppointmentDao;
import com.davidamaya.appointmentform.app.models.entity.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AppointmentServiceImpl implements IAppointmentService{

    @Autowired
    private IAppointmentDao appointmentDao;

    @Override
    @Transactional(readOnly = true)
    public List<Appointment> findAll() {
        return (List<Appointment>) appointmentDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Appointment> findAll(Pageable pageable) {
        return appointmentDao.findAll(pageable);
    }

    @Override
    @Transactional
    public void save(Appointment appointment) {
        appointmentDao.save(appointment);
    }

    @Override
    @Transactional
    public Appointment findOne(Long id) {
        return appointmentDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        appointmentDao.deleteById(id);
    }
}
