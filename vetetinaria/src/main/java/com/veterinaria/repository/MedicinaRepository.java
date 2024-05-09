package com.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veterinaria.entities.Medicina;
@Repository
public interface MedicinaRepository extends JpaRepository<Medicina, Long>{

}
