package com.davidamaya.appointmentform.app.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "address")
public class Address /* implements Serializable */{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "address_1")
    private String address1;

    @Column(name = "address_2")
    private String address2;

    @NotBlank
    @Column(name = "patient_city")
    private String city;

    @NotBlank
    @Column(name = "patient_region")
    private String region;

    @NotNull
    @Column(name = "patient_cp")
    private Integer patientCp;

    @NotBlank
    @Column(name = "patient_country")
    private String country;

    public Address() {
    }

    public Address(String address1, String address2, String city, String region, Integer patientCp, String country) {
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.region = region;
        this.patientCp = patientCp;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getPatientCp() {
        return patientCp;
    }

    public void setPatientCp(Integer patientCp) {
        this.patientCp = patientCp;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    /*
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    private static final long serialVersionUID = 2L;   */
}
