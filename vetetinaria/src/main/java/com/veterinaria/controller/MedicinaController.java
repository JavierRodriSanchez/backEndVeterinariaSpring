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
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.dtos.MedicinaDto;
import com.veterinaria.entities.Medicina;
import com.veterinaria.entities.Tipo;
import com.veterinaria.service.MedicinaService;

@RestController
@RequestMapping("/api/medicines")
public class MedicinaController {

	@Autowired
	MedicinaService medicinaService;
	
	 @GetMapping("/tipo/{tipoId}")
	    public ResponseEntity<List<MedicinaDto>> getMedicinaByTipo(@PathVariable Long tipoId) {
	        Tipo tipo = new Tipo();
	        tipo.setIdTipo(tipoId);
	        List<MedicinaDto> medicinas = medicinaService.findByTipo(tipo);
	        return ResponseEntity.ok(medicinas);
	    }
    // Endpoint para crear una medicina
    @PostMapping
    public ResponseEntity<Medicina> createMedicina(@RequestBody Medicina medicina) {
        Medicina newMedicina = medicinaService.saveMedicina(medicina);
        return new ResponseEntity<>(newMedicina, HttpStatus.CREATED);
    }

    // Endpoint para obtener todas las medicinas
    @GetMapping
    public ResponseEntity<List<Medicina>> getAllMedicinas() {
        List<Medicina> medicinas = medicinaService.getAllMedicinas();
        return new ResponseEntity<>(medicinas, HttpStatus.OK);
    }

    // Endpoint para obtener una medicina por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Medicina> getMedicinaById(@PathVariable Long id) {
        Optional<Medicina> medicina = medicinaService.getMedicinaById(id);
        return medicina.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint para actualizar una medicina
    @PutMapping("/{id}")
    public ResponseEntity<Medicina> updateMedicina(@PathVariable Long id, @RequestBody Medicina medicinaDetails) {
        Optional<Medicina> optionalMedicina = medicinaService.getMedicinaById(id);
        if (optionalMedicina.isPresent()) {
            Medicina existingMedicina = optionalMedicina.get();
            existingMedicina.setNombreMedicina(medicinaDetails.getNombreMedicina());
            existingMedicina.setTipo(medicinaDetails.getTipo());
            medicinaService.updateMedicina(existingMedicina);
            return new ResponseEntity<>(existingMedicina, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para eliminar una medicina por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteMedicina(@PathVariable Long id) {
        Optional<Medicina> medicina = medicinaService.getMedicinaById(id);
        if (medicina.isPresent()) {
            medicinaService.deleteMedicinaById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
}
