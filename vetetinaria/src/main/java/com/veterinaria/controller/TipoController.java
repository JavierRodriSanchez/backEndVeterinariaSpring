package com.veterinaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.entities.Tipo;
import com.veterinaria.entities.Veterinario;
import com.veterinaria.service.TipoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/tipo")
public class TipoController {

	@Autowired
	TipoService tipoService;
	
	@GetMapping("/findAll")
	public List<Tipo>findAll(){
		
	return	tipoService.findAll();
		
	}
	
	  @Operation(summary = " create one type ")
	    @ApiResponses(value = {
	            @ApiResponse(responseCode = "201", description = "type created", content = {
	                    @Content(mediaType = "application/json", schema = @Schema(implementation = Tipo.class))
	            })
	    })
	@PostMapping("/add")
	public Tipo create(@org.springframework.web.bind.annotation.RequestBody Tipo tipo) {
		
		return tipoService.create(tipo);
	}
	  
	  
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@PathVariable(name = "id")Long id, @org.springframework.web.bind.annotation.RequestBody Tipo tipo) {
		tipo.setIdTipo(id);
		Tipo update = tipoService.update(tipo);
		return ResponseEntity.ok(update);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(name = "id")Long id){
		
		tipoService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	  
}
