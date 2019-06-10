package com.iyoa.cleanaddis.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iyoa.cleanaddis.data.Teaching;

public interface TeachingRepository  extends JpaRepository<Teaching, UUID>  {

}
