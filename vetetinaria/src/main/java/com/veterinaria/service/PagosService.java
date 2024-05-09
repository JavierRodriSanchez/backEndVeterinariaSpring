package com.veterinaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.entities.Medicina;
import com.veterinaria.entities.Pagos;
import com.veterinaria.repository.MedicinaRepository;
import com.veterinaria.repository.PagosRepository;

@Service
public class PagosService {

	
	@Autowired
	PagosRepository pagosRepository;
	
	// Método para guardar una medicina
    public Pagos saveMedicina(Pagos medicina) {
        return pagosRepository.save(medicina);
    }

    // Método para obtener todas las medicinas
    public List<Pagos> getAllMedicinas() {
        return pagosRepository.findAll();
    }

    // Método para obtener una medicina por su ID
    public Optional<Pagos> getMedicinaById(Long id) {
        return pagosRepository.findById(id);
    }

    // Método para actualizar una medicina
    public Pagos updateMedicina(Pagos medicina) {
        return pagosRepository.save(medicina);
    }

    // Método para eliminar una medicina por su ID
    public void deleteMedicinaById(Long id) {
    	pagosRepository.deleteById(id);
    }
	
}
