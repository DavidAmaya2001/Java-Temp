package com.davidamaya.appointmentform.app.models.services.address;

import com.davidamaya.appointmentform.app.models.entity.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAddressService{

    public List<Address> findAll();
    public Page<Address> findAll(Pageable pageable);
    public void save(Address address);
    public Address findOne(Long id);
    public void delete(Long id);
}
