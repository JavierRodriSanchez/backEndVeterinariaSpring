package com.veterinaria.dtos;

import java.util.List;

import com.veterinaria.entities.Mascota;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto {

    
    private Long id;

    private String nombre;

    private String telefono;

    private String direccion;



    private String correo;

    
    private String contrasena;
   
    
}
