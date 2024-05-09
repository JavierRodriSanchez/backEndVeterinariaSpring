package com.veterinaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.dtos.ClienteDto;
import com.veterinaria.dtos.MascotaDto;
import com.veterinaria.entities.Dueño;
import com.veterinaria.entities.Mascota;
import com.veterinaria.entities.Veterinario;
import com.veterinaria.repository.DueñoRepository;
import com.veterinaria.repository.MascotaRepository;

@Service
public class DueñoService {

	@Autowired
	MascotaRepository mascotaRepository;
	@Autowired
	DueñoRepository dueñoRepository;
	
	public Dueño saveDueño(ClienteDto clienteDto) {
        Dueño dueño = new Dueño();
        dueño.setNombre(clienteDto.getNombre());
        dueño.setTelefono(clienteDto.getTelefono());
        dueño.setDireccion(clienteDto.getDireccion());
        dueño.setCorreo(clienteDto.getCorreo());
        dueño.setContrasena(clienteDto.getContrasena());
        
       
        return dueñoRepository.save(dueño);
    }


    // Método para obtener todos los dueños
    public List<Dueño> getAllDueños() {
        return dueñoRepository.findAll();
    }

    // Método para obtener un dueño por su ID
    public Optional<Dueño> getDueñoById(Long id) {
        return dueñoRepository.findById(id);
    }

    // Método para actualizar un dueño
    public Dueño updateDueño(ClienteDto clienteDto) {
    	Dueño dueño = new Dueño();
    	dueño.setId(clienteDto.getId());
        dueño.setNombre(clienteDto.getNombre());
        dueño.setTelefono(clienteDto.getTelefono());
        dueño.setDireccion(clienteDto.getDireccion());
        dueño.setCorreo(clienteDto.getCorreo());
        dueño.setContrasena(clienteDto.getContrasena());
    	
        return dueñoRepository.save(dueño);
    }

    // Método para eliminar un dueño por su ID
    public void deleteDueñoById(Long id) {
        dueñoRepository.deleteById(id);
    }
	
	
	
	
}
