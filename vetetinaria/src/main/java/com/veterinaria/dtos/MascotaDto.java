package com.veterinaria.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MascotaDto {

    private String nombre;
    private Long idVeterinario;
    private Long idDueno;
    private int edad;
    private String raza;
    private String sexo;
    private String peso;
    private String imagen;

    // Getters y Setters
}
