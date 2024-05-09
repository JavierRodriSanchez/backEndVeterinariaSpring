package com.veterinaria.mappers;

import com.veterinaria.dtos.MascotasResponseDto;
import com.veterinaria.entities.Mascota;

public class MascotaMapperFindMascotaById {

	
	public static MascotasResponseDto entityToDto(Mascota mascota) {
		
	
		  MascotasResponseDto dto = new MascotasResponseDto();
	        dto.setId(mascota.getId());
	        dto.setNombre(mascota.getNombre());
	        dto.setRaza(mascota.getRaza());
	        dto.setEdad(mascota.getEdad());
	        dto.setPeso(mascota.getPeso());
	        dto.setImagen(mascota.getImagen());
	        dto.setSexo(mascota.getSexo());
	        return dto;
	}
	 public static Mascota dtoToEntity(MascotasResponseDto dto) {
	        Mascota mascota = new Mascota();
	        mascota.setId(dto.getId());
	        mascota.setNombre(dto.getNombre());
	        mascota.setRaza(dto.getRaza());
	        mascota.setEdad(dto.getEdad());
	        mascota.setPeso(dto.getPeso());
	        mascota.setImagen(dto.getImagen());
	        mascota.setSexo(dto.getSexo());
	        return mascota;
	    }
	
}
