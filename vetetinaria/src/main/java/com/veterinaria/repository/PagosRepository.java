package com.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veterinaria.entities.Pagos;
@Repository
public interface PagosRepository extends JpaRepository<Pagos, Long>{

}
