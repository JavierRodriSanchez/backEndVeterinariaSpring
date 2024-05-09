package com.veterinaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.dtos.MascotaDto;
import com.veterinaria.dtos.MascotasResponseDto;
import com.veterinaria.entities.Mascota;
import com.veterinaria.entities.Veterinario;
import com.veterinaria.mappers.MascotaMapperFindMascotaById;
import com.veterinaria.service.MascotaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

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

import com.veterinaria.entities.Mascota;
import com.veterinaria.service.MascotaService;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

    @GetMapping
    public ResponseEntity<List<Mascota>> getAllMascotas() {
        List<Mascota> mascotas = mascotaService.findAll();
        return ResponseEntity.ok(mascotas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mascota> getMascotaById(@PathVariable("id") Long id) {
        Optional<Mascota> mascota = mascotaService.findById(id);
        if (mascota.isPresent()) {
            return ResponseEntity.ok(mascota.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/nueva")
    public Mascota crearNuevaMascota(@RequestBody MascotaDto mascotaDto) {
        return mascotaService.crearMascota(mascotaDto);
    }
    @Operation(summary = "add one pet")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pet created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Pet already exists")})
    
   
    @PutMapping("/{id}")
    public ResponseEntity<Mascota> updateMascota(@PathVariable("id") Long id, @RequestBody Mascota mascota) {
        mascota.setId(id);
        Mascota updatedMascota = mascotaService.save(mascota);
        return ResponseEntity.ok(updatedMascota);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMascota(@PathVariable("id") Long id) {
        mascotaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/mascotas/{idCita}")
    public MascotasResponseDto findMascotaByCitaId(@PathVariable Long idCita) {
        return MascotaMapperFindMascotaById.entityToDto( mascotaService.findMascotaByCitaId(idCita));
    }
}
