package com.veterinaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.veterinaria.entities.Dueño;



@Repository
public interface DueñoRepository extends JpaRepository<Dueño,Long>{

	@Query("select m from Dueño m where m.nombre like :nombre%")
	public List<Dueño> findByNombre(@Param("nombre")String name);
	
	@Query("select m from Dueño m where m.telefono like :telefono%")
	public List<Dueño> findByTelefono(@Param("telefono")String telefono);
	
	
	@Query("select m from Dueño m where m.direccion like :direccion%")
	public List<Dueño> findByDireccion(@Param("direccion")String direccion);
	
	
	@Query("select m from Dueño m where m.correo like :correo%")
	public List<Dueño> findByCorreo(@Param("correo")String correo);
}
