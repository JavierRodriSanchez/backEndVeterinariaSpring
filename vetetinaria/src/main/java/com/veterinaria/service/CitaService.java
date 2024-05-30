package com.veterinaria.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.veterinaria.dtos.CitaDto;
import com.veterinaria.entities.Cita;
import com.veterinaria.entities.Mascota;
import com.veterinaria.repository.CitasRepository;
@Service
public class CitaService {
	@Autowired
	CitasRepository citasRepository;
	
	
	public List<Cita> listCitas(){
		
		return citasRepository.findAll();
	}
	
	
	public List<CitaDto> listCitasWithPets(){
		
		List<Cita> findAll = citasRepository.findAll();
		List<CitaDto> listWithPets = new ArrayList<CitaDto>();
		
		for (Cita citaEntity : findAll) {
			CitaDto citaDto = new CitaDto();
			citaDto.setIdCita(citaEntity.getIdCita());
			citaDto.setFechaCita(citaEntity.getFechaCita());
			citaDto.setMotivo(citaEntity.getMotivo());
			citaDto.setObservaciones(citaEntity.getObservaciones());
			citaDto.setIdMascota(citaEntity.getMascota().getId());
			citaDto.setNombre(citaEntity.getMascota().getNombre());
			listWithPets.add(citaDto);
		}
		return listWithPets;
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
	
    public List<CitaDto> orderByDate(){
    	List<Cita> findAll = citasRepository.findAll(Sort.by("fechaCita"));
		List<CitaDto> listWithPets = new ArrayList<CitaDto>();
		
		for (Cita citaEntity : findAll) {
			CitaDto citaDto = new CitaDto();
			citaDto.setIdCita(citaEntity.getIdCita());
			citaDto.setFechaCita(citaEntity.getFechaCita());
			citaDto.setMotivo(citaEntity.getMotivo());
			citaDto.setObservaciones(citaEntity.getObservaciones());
			citaDto.setIdMascota(citaEntity.getMascota().getId());
			citaDto.setNombre(citaEntity.getMascota().getNombre());
			listWithPets.add(citaDto);
		}
    	return listWithPets;
    }
    
    public List<CitaDto> findMotivosStartWith(String motivo){
    	
    	List<Cita> findAll = citasRepository.findByMotivoStartingWith(motivo);
		List<CitaDto> listWithPets = new ArrayList<CitaDto>();
		
		for (Cita citaEntity : findAll) {
			CitaDto citaDto = new CitaDto();
			citaDto.setIdCita(citaEntity.getIdCita());
			citaDto.setFechaCita(citaEntity.getFechaCita());
			citaDto.setMotivo(citaEntity.getMotivo());
			citaDto.setObservaciones(citaEntity.getObservaciones());
			citaDto.setIdMascota(citaEntity.getMascota().getId());
			citaDto.setNombre(citaEntity.getMascota().getNombre());
			listWithPets.add(citaDto);
		}
    	return listWithPets;
    	
    }
    
public List<CitaDto> findNamePets(String nombreMascotas){
    	
    	List<Cita> findAll = citasRepository.findByNombreMascota(nombreMascotas);
		List<CitaDto> listWithPets = new ArrayList<CitaDto>();
		
		for (Cita citaEntity : findAll) {
			CitaDto citaDto = new CitaDto();
			citaDto.setIdCita(citaEntity.getIdCita());
			citaDto.setFechaCita(citaEntity.getFechaCita());
			citaDto.setMotivo(citaEntity.getMotivo());
			citaDto.setObservaciones(citaEntity.getObservaciones());
			citaDto.setIdMascota(citaEntity.getMascota().getId());
			citaDto.setNombre(citaEntity.getMascota().getNombre());
			listWithPets.add(citaDto);
		}
    	return listWithPets;
    	
    }
    
public List<CitaDto> findCitasByMascotaId(Long mascotaId) {
    
    
    
    List<Cita> findAll = citasRepository.findByMascotaId(mascotaId);
	List<CitaDto> listWithPets = new ArrayList<CitaDto>();
	
	for (Cita citaEntity : findAll) {
		CitaDto citaDto = new CitaDto();
		citaDto.setIdCita(citaEntity.getIdCita());
		citaDto.setFechaCita(citaEntity.getFechaCita());
		citaDto.setMotivo(citaEntity.getMotivo());
		citaDto.setObservaciones(citaEntity.getObservaciones());
		citaDto.setIdMascota(citaEntity.getMascota().getId());
		citaDto.setNombre(citaEntity.getMascota().getNombre());
		listWithPets.add(citaDto);
	}
	return listWithPets;
}
    
}
