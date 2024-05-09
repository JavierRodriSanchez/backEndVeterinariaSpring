package com.veterinaria.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VeterinarioRequestDTO {

		@NotNull
	    private String nombre;

		@NotNull
	    private String telefono;


		@NotNull
	    private String codColegiado;

	    

		@NotNull
	    private String correo;


		@NotNull
	    private String contrasena;
	    

		@NotNull
	    private String apellidos;

	
}
