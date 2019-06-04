package com.iyoa.cleanaddis.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iyoa.cleanaddis.model.Address;

public interface AddressRepository extends JpaRepository<Address,UUID> {

}
