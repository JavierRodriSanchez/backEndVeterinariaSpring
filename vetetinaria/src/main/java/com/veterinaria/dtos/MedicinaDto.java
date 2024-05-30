package com.veterinaria.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;





public class MedicinaDto {
    private Long idMedicina;
    private String nombreMedicina;
    private Long mascotaId;
    private String nombreMascota;
    private Long tipoId;
    private String nombreTipo;
    private Double precio;

    // Getters and Setters

    public Long getIdMedicina() {
        return idMedicina;
    }

    public void setIdMedicina(Long idMedicina) {
        this.idMedicina = idMedicina;
    }

    public String getNombreMedicina() {
        return nombreMedicina;
    }

    public void setNombreMedicina(String nombreMedicina) {
        this.nombreMedicina = nombreMedicina;
    }

    public Long getMascotaId() {
        return mascotaId;
    }

    public void setMascotaId(Long mascotaId) {
        this.mascotaId = mascotaId;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public Long getTipoId() {
        return tipoId;
    }

    public void setTipoId(Long tipoId) {
        this.tipoId = tipoId;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
