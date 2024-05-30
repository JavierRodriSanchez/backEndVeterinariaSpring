package com.veterinaria.dtos;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class PagosDto {

	private Long idPago;

	private Date fechaPago;

	private Double monto;

	private Long id;

	private String nombre;

	private int edad;

	private String raza;

	private String sexo;

	private String peso;

	private String imagen;

}
