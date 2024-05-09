package com.veterinaria.entities;

import java.sql.Date;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "pagos")
public class Pagos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long idPago;
	
	@Column(name = "fecha_pago")
	private Date fechaPago;
	
	
	@Column(name = "monto")
	private Double monto;
	
	
	@ManyToOne()
    @JoinColumn(name = "fk_mascota")
    private Mascota mascota;
	
}
