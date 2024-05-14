package com.davidamaya.appointmentform.app.models.dao;

import com.davidamaya.appointmentform.app.models.entity.Address;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IAddressDao extends PagingAndSortingRepository<Address, Long> {
}
