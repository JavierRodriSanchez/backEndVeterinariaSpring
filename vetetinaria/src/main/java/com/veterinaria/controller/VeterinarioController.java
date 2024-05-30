package com.veterinaria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.dtos.CitaDto;
import com.veterinaria.dtos.VeterinarioRequestDTO;
import com.veterinaria.entities.Veterinario;
import com.veterinaria.repository.VeterinarioRepository;
import com.veterinaria.service.VeterinarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/vets")
public class VeterinarioController {

	@Autowired
	VeterinarioService veterinarioService;
	
	 
	   @Operation(summary = "get all vets ")
	   @ApiResponses(value = {
			   @ApiResponse(responseCode = "200",description = "vets found",content = {
					   
					   @Content(mediaType = "application/json",schema = @Schema(implementation = Veterinario.class))
			   })
	   })
	@GetMapping("/findAll")
	public List<Veterinario>findAll(){
		
		return  veterinarioService.findAll();
		
	}
	   

	    @Operation(summary = "search one vet by id")
	    @ApiResponses(value = {
	            @ApiResponse(responseCode = "201", description = "vet found", content = {
	                    @Content(mediaType = "application/json", schema = @Schema(implementation = Veterinario.class))
	            })
	    })
	    @GetMapping("/{id}")
	    public ResponseEntity<Veterinario> obtenerVeterinarioPorId(@PathVariable Long id) {
	        Optional<Veterinario> veterinario = veterinarioService.findById(id);
	        return veterinario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    
	 
	    
	    @Operation(summary = "add one vet ")
	    @ApiResponses(value = {
	            @ApiResponse(responseCode = "201", description = "vets created", content = {
	                    @Content(mediaType = "application/json", schema = @Schema(implementation = Veterinario.class))
	            })
	    })
	    @PostMapping("/add")
	    public ResponseEntity<Veterinario> crearVeterinario(@org.springframework.web.bind.annotation.RequestBody Veterinario veterinario) {
	        Veterinario nuevoVeterinario = veterinarioService.create(veterinario);
	        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoVeterinario);
	    }




	    @Operation(summary = "update one vet")
	    @ApiResponses(value = {
	            @ApiResponse(responseCode = "200", description = "vet updated", content = {
	                    @Content(mediaType = "application/json", schema = @Schema(implementation = Veterinario.class))
	            })
	    })
	    @PutMapping("/{id}")
	    public ResponseEntity<Veterinario> actualizarVeterinario(@PathVariable Long id, @org.springframework.web.bind.annotation.RequestBody Veterinario veterinario) {
	        if (!veterinarioService.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        }
	        veterinario.setId(Long.valueOf(id));
	        Veterinario veterinarioActualizado = veterinarioService.update(veterinario);
	        return ResponseEntity.ok(veterinarioActualizado);
	    }

	    
	    

	    @Operation(summary = "delete one vet")
	    @ApiResponses(value = {
	            @ApiResponse(responseCode = "200", description = "vet deleted", content = {
	                    @Content(mediaType = "application/json", schema = @Schema(implementation = Veterinario.class))
	            })
	    })
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> eliminarVeterinario(@PathVariable Long id) {
	        if (!veterinarioService.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        }
	        veterinarioService.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }  
	    
	    @Operation(summary = "List vets order by name")
	    @ApiResponses(value = {
	            @ApiResponse(responseCode = "200", description = "vets found", content = {
	                    @Content(mediaType = "application/json", schema = @Schema(implementation = Veterinario.class))
	            })
	    })
	    @GetMapping("/orderByName")
	    public List<Veterinario> OrderByName(){
	    	
	    	return veterinarioService.orderByName();
	    	
	    	
	    }
	    
	    
	    
	    @Operation(summary = "List vets order by Code")
	    @ApiResponses(value = {
	            @ApiResponse(responseCode = "200", description = "vets found", content = {
	                    @Content(mediaType = "application/json", schema = @Schema(implementation = Veterinario.class))
	            })
	    })
	    @GetMapping("/orderByCodigo")
	    public List<Veterinario> OrderByCod(){
	    	
	    	return veterinarioService.orderByCodigoColegiado();
	    	
	    	
	    }
	    
	    
	    @Operation(summary = "List vets order by Mail")
	    @ApiResponses(value = {
	            @ApiResponse(responseCode = "200", description = "vets found", content = {
	                    @Content(mediaType = "application/json", schema = @Schema(implementation = Veterinario.class))
	            })
	    })
	    @GetMapping("/orderByMail")
	    public List<Veterinario> OrderMail(){
	    	
	    	return veterinarioService.orderByCorreo();
	    	
	    	
	    }
	    
	    @GetMapping("filterByName")
	    public List<Veterinario>getListName(@RequestParam String nombre){
	    	return veterinarioService.findByName(nombre);
	    }
	    
	    
	    
	    @GetMapping("getMail")
	    public List<Veterinario> getNamePets(@RequestParam String mail){
	    	return veterinarioService.findMail(mail);
	    }
	    
	    @GetMapping("getCode")
	    public List<Veterinario> getCodeVet(@RequestParam String code){
	    	return veterinarioService.findByCode(code);
	    }
	    @GetMapping("getPhone")
	    public List<Veterinario>getPhone(@RequestParam String phone){
	    	return veterinarioService.findByPhone(phone);
	    }
	    
	    @DeleteMapping("/borrarPorId/{id}")
	    public void deleteByIdVeterinario(@PathVariable(name = "id")Long id) {
	    	
	    	veterinarioService.deleteByIdVeterinarios(id);
	    	
	    }
	    
	    
}
