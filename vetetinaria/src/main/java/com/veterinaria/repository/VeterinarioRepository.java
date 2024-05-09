package com.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.veterinaria.entities.Veterinario;
@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Long>{

	@Query("select m from Veterinario m where m.correo like :mail%")
	public Veterinario findByMail(@Param("mail")String name);
	
	@Query(value ="delete  from veterinario v where v.id_v = :id_v",nativeQuery = true)
	public void deleteByIdVeterinario(@Param("id_v")Long id);
}
  