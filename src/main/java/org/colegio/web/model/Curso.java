package org.colegio.web.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_curso")
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nombre_curso")
	private String nombreCurso;
	
	@Column(name = "descripcion_curso")
	private String descripcionCurso;
	
	@JsonIgnore
	@OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Matricula> matriculas = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Asignatura> asignaturas = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<NotasBimestrales> notasBimestrales = new ArrayList<>();

}
