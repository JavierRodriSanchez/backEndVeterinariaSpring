package com.veterinaria.entities;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.Cascade;

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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "veterinario")
public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_v")
    private Long id;
    
  
    @Column(name = "apellidos")
    private String apellidos;
    
   
    @Column(name = "codColegiado")
   // Agregar esta anotación para mapear correctamente desde JSON
    private String codColegiado; // Cambiado el nombre del campo para que coincida con el JSON
    

    @Column(name = "contrasena")
    private String contrasena;
    
    
    @Column(name = "correo",unique = true)
    private String correo;


    @Column(name = "nombrevet")
  // Agregar esta anotación para mapear correctamente desde JSON
    private String nombre; // Cambiado el nombre del campo para que coincida con el JSON
    
   
    @Column(name = "telefono")
    private String telefono;
    
    
    @ManyToOne()
    @JoinColumn(name = "fk_rol")
    Rol roles;
    
}

