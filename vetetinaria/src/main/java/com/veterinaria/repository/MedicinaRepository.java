package com.veterinaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veterinaria.entities.Medicina;
import com.veterinaria.entities.Tipo;
@Repository
public interface MedicinaRepository extends JpaRepository<Medicina, Long>{
	List<Medicina> findByTipo(Tipo tipo);
}
