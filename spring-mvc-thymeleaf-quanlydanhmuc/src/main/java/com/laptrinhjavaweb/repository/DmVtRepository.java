package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.model.DmVt;

@Repository("dmVtRepository")
public interface DmVtRepository extends JpaRepository<DmVt, Integer>{

}
