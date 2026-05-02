package com.onStreets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onStreets.entity.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long>{

}
