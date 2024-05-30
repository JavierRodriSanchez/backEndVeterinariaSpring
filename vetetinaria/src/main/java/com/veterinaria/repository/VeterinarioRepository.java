package com.veterinaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.veterinaria.entities.Veterinario;
@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Long>{

	@Query("select m from Veterinario m where m.correo like :mail%")
	public List<Veterinario> findByMail(@Param("mail")String name);
	
	
	@Query("select m from Veterinario m where m.nombre like :nombre%")
	public List<Veterinario> findByNombre(@Param("nombre")String name);
	
	@Query("select m from Veterinario m where m.codColegiado like :codColegiado%")
	public List<Veterinario> findBycodigo(@Param("codColegiado")String codColegiado);
	
	@Query("select m from Veterinario m where m.telefono like :telefono%")
	public List<Veterinario> findByTelefono(@Param("telefono")String telefono);
	
	@Query(value ="delete  from veterinario v where v.id_v = :id_v",nativeQuery = true)
	public void deleteByIdVeterinario(@Param("id_v")Long id);
}
  