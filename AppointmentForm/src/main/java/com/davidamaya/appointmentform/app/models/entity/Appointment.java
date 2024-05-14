package com.davidamaya.appointmentform.app.models.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "appointment")
public class Appointment /*implements Serializable */{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Se requiere una fecha valida")
    @Column(name = "appointment_day")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future
    private Date appointmentDay;

    @NotNull(message = "Se requiere una hora valida")
    @Column(name = "appointment_hour")
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm")
    private Date appointmentHour;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAppointmentDay() {
        return appointmentDay;
    }

    public void setAppointmentDay(Date appointmentDay) {
        this.appointmentDay = appointmentDay;
    }

    public Date getAppointmentHour() {
        return appointmentHour;
    }

    public void setAppointmentHour(Date appointmentHour) {
        this.appointmentHour = appointmentHour;
    }
    /*
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    private static final long serialVersionUID = 3L;   */
}
