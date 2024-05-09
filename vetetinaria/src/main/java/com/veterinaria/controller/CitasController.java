package com.veterinaria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.entities.Cita;
import com.veterinaria.entities.Mascota;
import com.veterinaria.service.CitaService;

@RestController
@RequestMapping("api/citas")
public class CitasController {
	
	
	@Autowired
	CitaService citaService;
	
	@GetMapping("getAll")
	public List<Cita> findAllCitas(){
		
		return citaService.listCitas();
		
	}
	

    @GetMapping("/{id}")
    public ResponseEntity<Cita> getMascotaById(@PathVariable("id") Long id) {
        Optional<Cita> mascota = citaService.findById(id);
        if (mascota.isPresent()) {
            return ResponseEntity.ok(mascota.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Cita> createMascota(@RequestBody Cita cita) {
    	Cita savedMascota = citaService.save(cita);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMascota);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cita> updateMascota(@PathVariable("id") Long id, @RequestBody Cita cita) {
        cita.setIdCita(id);
        Cita updatedMascota = citaService.save(cita);
        return ResponseEntity.ok(updatedMascota);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMascota(@PathVariable("id") Long id) {
    	citaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    
    @GetMapping("/orderByDate")
    public List<Cita> orderByDate(){
    	
    	return citaService.orderByDate();
    	
    }
    
    
    @GetMapping("/citas")
    public List<Cita> getCitasByMotivo(@RequestParam String motivo) {
        return citaService.findMotivosStartWith(motivo);
    }
}
