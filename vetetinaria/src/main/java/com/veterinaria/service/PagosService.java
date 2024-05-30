package com.veterinaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.dtos.MascotaDto;
import com.veterinaria.dtos.PagosDto;
import com.veterinaria.dtos.PagosDtoRequest;
import com.veterinaria.entities.Dueño;
import com.veterinaria.entities.Mascota;
import com.veterinaria.entities.Medicina;
import com.veterinaria.entities.Pagos;
import com.veterinaria.entities.Veterinario;
import com.veterinaria.mappers.PagosMapper;
import com.veterinaria.repository.MascotaRepository;
import com.veterinaria.repository.MedicinaRepository;
import com.veterinaria.repository.PagosRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PagosService {

	
	@Autowired
	PagosRepository pagosRepository;
	
	@Autowired
	MascotaRepository mascotaRepository;
	
	 public Pagos crearPago(PagosDtoRequest pagosRequest) {
	        Pagos pagos = new Pagos();
	        pagos.setFechaPago(pagosRequest.getFechaPago());
	        pagos.setMonto(pagosRequest.getMonto());

	        Optional<Mascota> optionalMascota = mascotaRepository.findById(pagosRequest.getIdMascota());
	        if (optionalMascota.isPresent()) {
	            Mascota mascota = optionalMascota.get();
	            pagos.setMascota(mascota);  // Asociar la mascota con el pago
	        } else {
	            // Manejar el caso donde la mascota no se encuentra
	            throw new EntityNotFoundException("Mascota no encontrada");
	        }

	        return pagosRepository.save(pagos);
	    }
	
	
	// Método para guardar una medicina
    public Pagos saveMedicina(Pagos medicina) {
        return pagosRepository.save(medicina);
    }

    // Método para obtener todas las medicinas
    public List<PagosDto> getAllMedicinas() {
        return PagosMapper.entityToDto(pagosRepository.findAll());
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
