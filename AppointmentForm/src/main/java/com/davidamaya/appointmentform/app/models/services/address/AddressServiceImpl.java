package com.davidamaya.appointmentform.app.models.services.address;

import com.davidamaya.appointmentform.app.models.dao.IAddressDao;
import com.davidamaya.appointmentform.app.models.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AddressServiceImpl implements IAddressService{

    @Autowired
    private IAddressDao addressDao;

    @Override
    @Transactional(readOnly = true)
    public List<Address> findAll() {
        return (List<Address>) addressDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Address> findAll(Pageable pageable) {
        return addressDao.findAll(pageable);
    }

    @Override
    @Transactional
    public void save(Address address) {
        addressDao.save(address);
    }

    @Override
    @Transactional
    public Address findOne(Long id) {
        return addressDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        addressDao.deleteById(id);
    }
}
