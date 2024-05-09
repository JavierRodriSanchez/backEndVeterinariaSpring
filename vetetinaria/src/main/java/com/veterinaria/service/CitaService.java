package com.veterinaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.veterinaria.entities.Cita;

import com.veterinaria.repository.CitasRepository;
@Service
public class CitaService {
	@Autowired
	CitasRepository citasRepository;
	
	
	public List<Cita> listCitas(){
		
		return citasRepository.findAll();
	}
	public Optional<Cita> findById(Long id) {
        return citasRepository.findById(id);
    }

    public Cita save(Cita cita) {
        return citasRepository.save(cita);
    }

    public void deleteById(Long id) {
    	citasRepository.deleteById(id);
    }
	
    public List<Cita> orderByDate(){
    	
    	return citasRepository.findAll(Sort.by("fechaCita"));
    }
    
    public List<Cita> findMotivosStartWith(String motivo){
    	return citasRepository.findByMotivoStartingWith(motivo);
    }
    
}
