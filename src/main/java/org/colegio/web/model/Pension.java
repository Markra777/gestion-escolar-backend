package org.colegio.web.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_pension")
public class Pension {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "monto")
	private double monto;
	
	@Column(name = "fecha_pago")
	private Date fechaPago;
	
	@Column(name = "estado")
	private String estado;
	
	@ManyToOne
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;

}
