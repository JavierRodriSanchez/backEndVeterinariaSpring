package com.veterinaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.veterinaria.dtos.VeterinarioRequestDTO;
import com.veterinaria.entities.Veterinario;
import com.veterinaria.mappers.VeterinarioMapperRequest;
import com.veterinaria.repository.VeterinarioRepository;

@Service
public class VeterinarioService {

	@Autowired
	VeterinarioRepository veterinarioRepository;

	public List<Veterinario> findAll() {

		return veterinarioRepository.findAll();

	}

	// Método para obtener un veterinario por su ID
	public Optional<Veterinario> findById(Long id) {
		return veterinarioRepository.findById(id);
	}

	// Método para crear un nuevo veterinario
	public Veterinario create(Veterinario veterinario) {

		return veterinarioRepository.save(veterinario);
	}

	// Método para actualizar un veterinario existente
	public Veterinario update(Veterinario veterinario) {
		return veterinarioRepository.save(veterinario);
	}

	// Método para eliminar un veterinario por su ID
	public void deleteById(Long id) {
		veterinarioRepository.deleteById(id);
	}

	// Método para verificar si existe un veterinario por su ID
	public boolean existsById(Long id) {
		return veterinarioRepository.existsById(id);
	}
	//Método para ordenar por nombre
	public List<Veterinario> orderByName() {

		List<Veterinario> findAll = veterinarioRepository.findAll(Sort.by("nombre"));
		return findAll;
	}
	//Método para ordenar por codigoColegiado
	public List<Veterinario> orderByCodigoColegiado() {

		List<Veterinario> findAll = veterinarioRepository.findAll(Sort.by("codColegiado"));
		return findAll;
	}
	
	//Método para ordenar por codigoColegiado
		public List<Veterinario> orderByCorreo() {

			List<Veterinario> findAll = veterinarioRepository.findAll(Sort.by("correo"));
			return findAll;
		}
		
	//Método para encontrar por correo
	public Veterinario searchByCorreo(String correo) {
		
	return	veterinarioRepository.findByMail(correo);
		
	}
	//Metodo para borrar por id 
	public void deleteByIdVeterinarios(Long id) {
		
		veterinarioRepository.deleteByIdVeterinario(id);
	}
	
}
