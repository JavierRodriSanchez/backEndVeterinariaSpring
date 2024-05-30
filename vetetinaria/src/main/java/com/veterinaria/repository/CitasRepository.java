package com.veterinaria.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import org.springframework.stereotype.Repository;

import com.veterinaria.dtos.CitaDto;
import com.veterinaria.entities.Cita;
import com.veterinaria.entities.Veterinario;
@Repository  
public interface CitasRepository extends JpaRepository<Cita, Long>{
	@Query("select m from Cita m where m.motivo like :motivo%")
	public List<Cita> findByMotivoStartingWith(@Param("motivo") String motivo);
	
	
	@Query("select c from Cita c where c.mascota.nombre like :nombreMascota%")
    public List<Cita> findByNombreMascota(@Param("nombreMascota") String nombreMascota);
	
	@Query("select c from Cita c where c.mascota.id = :mascotaId")
    List<Cita> findByMascotaId(@Param("mascotaId") Long mascotaId);

}
   