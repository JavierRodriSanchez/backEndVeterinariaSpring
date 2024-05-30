package com.veterinaria.mappers;

import java.util.ArrayList;
import java.util.List;

import com.veterinaria.dtos.MedicinaDto;
import com.veterinaria.entities.Mascota;
import com.veterinaria.entities.Medicina;
import com.veterinaria.entities.Tipo;

public class MedicinaDtoMapper {

    public static MedicinaDto entityToDto(Medicina entity) {
        MedicinaDto dto = new MedicinaDto();
        dto.setIdMedicina(entity.getIdMedicina());
        dto.setNombreMedicina(entity.getNombreMedicina());
        dto.setMascotaId(entity.getMascotas().getId());
        dto.setNombreMascota(entity.getMascotas().getNombre());
        dto.setTipoId(entity.getTipo().getIdTipo());
        dto.setNombreTipo(entity.getTipo().getNombreTipo());
        dto.setPrecio(entity.getTipo().getPrecio());
        return dto;
    }
    public static List<MedicinaDto> entitiesToDtos(List<Medicina> entities) {
        List<MedicinaDto> dtos = new ArrayList<>();
        for (Medicina entity : entities) {
            dtos.add(MedicinaDtoMapper.entityToDto(entity));
        }
        return dtos;
    }
    public static Medicina dtoToEntity(MedicinaDto dto) {
        Medicina entity = new Medicina();
        entity.setIdMedicina(dto.getIdMedicina());
        entity.setNombreMedicina(dto.getNombreMedicina());

        Mascota mascota = new Mascota();
        mascota.setId(dto.getMascotaId());
        mascota.setNombre(dto.getNombreMascota());
        entity.setMascotas(mascota);

        Tipo tipo = new Tipo();
        tipo.setIdTipo(dto.getTipoId());
        tipo.setNombreTipo(dto.getNombreTipo());
        tipo.setPrecio(dto.getPrecio());
        entity.setTipo(tipo);

        return entity;
    }
}

