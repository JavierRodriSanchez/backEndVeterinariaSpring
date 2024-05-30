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

import com.veterinaria.dtos.PagosDto;
import com.veterinaria.dtos.PagosDtoRequest;
import com.veterinaria.entities.Pagos;
import com.veterinaria.service.PagosService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/paid")
public class PagosController {

	@Autowired
    private PagosService pagosService;
	
	
	@PostMapping("/añadir")
    public ResponseEntity<Pagos> crearPago(@RequestBody PagosDtoRequest pagosRequest) {
        try {
            Pagos nuevoPago = pagosService.crearPago(pagosRequest);
            return new ResponseEntity<>(nuevoPago, HttpStatus.CREATED);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping
    public ResponseEntity<List<PagosDto>> getAllMascotas() {
        List<PagosDto> mascotas = pagosService.getAllMedicinas();
        return ResponseEntity.ok(mascotas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pagos> getMascotaById(@PathVariable("id") Long id) {
        Optional<Pagos> mascota = pagosService.getMedicinaById(id);
        if (mascota.isPresent()) {
            return ResponseEntity.ok(mascota.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Pagos> createMascota(@RequestBody Pagos pagos) {
    	Pagos savedMascota = pagosService.saveMedicina(pagos);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMascota);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pagos> updateMascota(@PathVariable("id") Long id, @RequestBody Pagos pagos) {
    	pagos.setIdPago(id);
        Pagos updatedMascota = pagosService.saveMedicina(pagos);
        return ResponseEntity.ok(updatedMascota);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMascota(@PathVariable("id") Long id) {
    	pagosService.deleteMedicinaById(id);
        return ResponseEntity.noContent().build();
    }
	
	
}
