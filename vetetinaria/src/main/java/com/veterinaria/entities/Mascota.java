package com.veterinaria.entities;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "mascotas")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_veterinario")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Veterinario veterinario;
    
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_dueno")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Dueño dueño;
    @JsonIgnore
    @OneToMany(mappedBy = "mascota")
    private List<Cita> citas;
    
    @Column(name = "edad")
    private int edad;

    @Column(name = "raza")
    private String raza;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "peso")
    private String peso;

    
    @Column(name = "imagenes",length = 2000)
    private String imagen;
    // Getters y Setters
    
    
}
