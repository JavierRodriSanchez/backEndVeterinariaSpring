package com.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.veterinaria.entities.Mascota;
@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long>{
	 @Query("SELECT m FROM Mascota m JOIN Cita c ON m.id = c.mascota.id WHERE c.id = :idCita")
	    Mascota findMascotaByCitaId(@Param("idCita") Long idCita);
}
