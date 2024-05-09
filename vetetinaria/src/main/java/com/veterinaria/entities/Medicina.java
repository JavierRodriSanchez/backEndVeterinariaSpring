package com.veterinaria.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "medicinas")
public class Medicina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medicina")
    private Long idMedicina;

    @Column(name = "nombre_medicina")
    private String nombreMedicina;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_mascota")
    private Mascota mascotas;
    
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_tipo")
    private Tipo tipo;

    // Getters y Setters
}
