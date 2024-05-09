package com.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veterinaria.entities.Dueño;


@Repository
public interface DueñoRepository extends JpaRepository<Dueño,Long>{

}
