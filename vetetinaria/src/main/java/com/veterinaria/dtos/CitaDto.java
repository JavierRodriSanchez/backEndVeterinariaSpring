package com.veterinaria.dtos;

import java.util.Date;

import com.veterinaria.entities.Mascota;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitaDto {
	
	    private Long idCita;
	
	    private Date fechaCita;
	
	   
	    private String motivo;
	
	
	    private String observaciones;
	    
	    
	 
	    private long idMascota;
	    
	    private String nombre;
	
	
	
	
	
}
