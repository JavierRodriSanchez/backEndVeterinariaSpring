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

import com.veterinaria.dtos.ClienteDto;
import com.veterinaria.entities.Dueño;
import com.veterinaria.service.DueñoService;

@RestController
@RequestMapping("/api/dueños")
public class DueñoController {

	@Autowired
	DueñoService dueñoService;
	
	
    @PostMapping("/add")
    public ResponseEntity<Dueño> createDueño(@RequestBody ClienteDto dueño) {
        Dueño createdDueño = dueñoService.saveDueño(dueño);
        return new ResponseEntity<>(createdDueño, HttpStatus.CREATED);
    }

    // Endpoint para obtener todos los dueños
    @GetMapping
    public ResponseEntity<List<Dueño>> getAllDueños() {
        List<Dueño> dueños = dueñoService.getAllDueños();
        return new ResponseEntity<>(dueños, HttpStatus.OK);
    }

    // Endpoint para obtener un dueño por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Dueño> getDueñoById(@PathVariable Long id) {
        Optional<Dueño> dueño = dueñoService.getDueñoById(id);
        return dueño.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

 // Endpoint para actualizar un dueño
    @PutMapping("/{id}")
    public ResponseEntity<Dueño> updateDueño(@PathVariable Long id, @RequestBody ClienteDto clienteDto) {
        clienteDto.setId(id);
        Dueño updatedDueño = dueñoService.updateDueño(clienteDto);
        return new ResponseEntity<>(updatedDueño, HttpStatus.OK);
    }

    // Endpoint para eliminar un dueño por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDueño(@PathVariable Long id) {
        dueñoService.deleteDueñoById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    
    @GetMapping("getClientes")
    public List<Dueño> getClientes(@RequestParam String nombre){
    	
    	return dueñoService.findByName(nombre);
    	
    }
    
    @GetMapping("getCorreo")
    public List<Dueño> getCorreo(@RequestParam String correo){
    	return dueñoService.findByCorreo(correo);
    }
    
    @GetMapping("getTelefono")
    public List<Dueño> getTelefono(@RequestParam String telefono){
    	return dueñoService.findByTelefono(telefono);
    }
    
    @GetMapping("getDireccion")
    public List<Dueño> getDueño(@RequestParam String direccion){
    	return dueñoService.findDireccion(direccion);
    	
    }
    
    @GetMapping("orderByPhone")
    public List<Dueño> orderByPhone(){
    	return dueñoService.orderByTelefono();
    	
    }
    @GetMapping("orderByName")
    public List<Dueño> orderByName(){
    	return dueñoService.orderByName();
    }
    
    @GetMapping("orderByDireccion")
    public List<Dueño> orderbyDireccion(){
    	return dueñoService.orderByDireccion();
    }
    
    @GetMapping("orderByCorreo")
    public List<Dueño> orderByCorreo(){
    	return dueñoService.orderByCorreo();
    }
}
