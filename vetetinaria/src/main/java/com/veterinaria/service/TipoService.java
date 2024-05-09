package com.veterinaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.entities.Tipo;

import com.veterinaria.repository.TipoRepository;

@Service
public class TipoService {

	@Autowired
	TipoRepository tipoRepository;

	public List<Tipo> findAll() {

		return tipoRepository.findAll();
	}

	public Tipo create(Tipo tipo) {
		return tipoRepository.save(tipo);
	}

	// Método para actualizar un veterinario existente
	public Tipo update(Tipo tipo) {
		return tipoRepository.save(tipo);
	}

	// Método para eliminar un veterinario por su ID
	public void deleteById(Long id) {
		tipoRepository.deleteById(id);
	}

}
