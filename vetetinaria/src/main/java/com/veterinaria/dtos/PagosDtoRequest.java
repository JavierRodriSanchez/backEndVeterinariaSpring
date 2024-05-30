package com.veterinaria.dtos;

import java.sql.Date;

import lombok.Data;

@Data
public class PagosDtoRequest {
	
	private Long id;
	
	private Date fechaPago;

	private Double monto;

	private Long idMascota;

}
