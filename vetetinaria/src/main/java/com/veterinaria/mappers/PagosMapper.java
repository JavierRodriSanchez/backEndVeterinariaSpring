package com.veterinaria.mappers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.veterinaria.dtos.MascotaDto;
import com.veterinaria.dtos.PagosDto;
import com.veterinaria.entities.Pagos;

public class PagosMapper {


	public static List<PagosDto> entityToDto(List<Pagos> entities) {
	    List<PagosDto> dtos = new ArrayList<>();
	    for (Pagos entity : entities) {
	        PagosDto dto = new PagosDto();
	        dto.setIdPago(entity.getIdPago());
	        dto.setFechaPago(entity.getFechaPago());
	        dto.setMonto(entity.getMonto());
	        dto.setId(entity.getMascota().getId());
	        dto.setNombre(entity.getMascota().getNombre());
	        dto.setEdad(entity.getMascota().getEdad());
	        dto.setPeso(entity.getMascota().getPeso());
	        dto.setRaza(entity.getMascota().getRaza());
	        dto.setSexo(entity.getMascota().getSexo());
	        dto.setImagen(entity.getMascota().getImagen());
	        dtos.add(dto);
	    }
	    return dtos;
	}
}
