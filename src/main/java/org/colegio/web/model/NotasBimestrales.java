package org.colegio.web.model;

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
@Table(name = "tb_notas_bimestrales")
public class NotasBimestrales {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "bimestre")
	private int bimestre;
	
	@Column(name = "calificacion")
	private double calificacion;
	
	@Column(name = "comentarios_profesor")
	private String comentariosProfesor;
	
	@ManyToOne
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;
	
	@ManyToOne
    @JoinColumn(name = "id_asignatura")
    private Asignatura asignatura;
	
	@ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;
	

}
