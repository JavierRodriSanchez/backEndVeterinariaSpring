	package com.veterinaria.entities;
	import java.util.Date;
	
	import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.FetchType;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.JoinColumn;
	import jakarta.persistence.ManyToOne;
	import jakarta.persistence.Table;
	import jakarta.persistence.Temporal;
	import jakarta.persistence.TemporalType;
	import lombok.Data;
	@Data
	@Entity
	@Table(name = "citas")
	public class Cita {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_cita")
	    private Long idCita;
	
	    @Column(name = "fecha_cita")
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date fechaCita;
	
	    @Column(name = "motivo")
	    private String motivo;
	
	    @Column(name = "observaciones")
	    private String observaciones;
	    
	    
	    
	 // Relación Many-to-One con Mascota
	    @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "fk_mascota")
	    @JsonIgnore
	    private Mascota mascota;
	
	    @JsonProperty("mascota")
	    public void setMascotaId(Long id) {
	        Mascota m = new Mascota();
	        m.setId(id);
	        this.mascota = m;
	    }
	}
