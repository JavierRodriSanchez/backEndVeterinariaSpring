package com.veterinaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.dtos.MedicinaDto;
import com.veterinaria.entities.Medicina;
import com.veterinaria.entities.Tipo;
import com.veterinaria.mappers.MedicinaDtoMapper;
import com.veterinaria.repository.MedicinaRepository;
@Service
public class MedicinaService {

	
	@Autowired
	MedicinaRepository medicinaRepository;
	
	public List<MedicinaDto> findByTipo(Tipo tipo) {
		
		
        return MedicinaDtoMapper.entitiesToDtos(medicinaRepository.findByTipo(tipo));
    }
	
	// Método para guardar una medicina
    public Medicina saveMedicina(Medicina medicina) {
        return medicinaRepository.save(medicina);
    }

    // Método para obtener todas las medicinas
    public List<Medicina> getAllMedicinas() {
        return medicinaRepository.findAll();
    }

    // Método para obtener una medicina por su ID
    public Optional<Medicina> getMedicinaById(Long id) {
        return medicinaRepository.findById(id);
    }

    // Método para actualizar una medicina
    public Medicina updateMedicina(Medicina medicina) {
        return medicinaRepository.save(medicina);
    }

    // Método para eliminar una medicina por su ID
    public void deleteMedicinaById(Long id) {
        medicinaRepository.deleteById(id);
    }
	
}
