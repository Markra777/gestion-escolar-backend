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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_asignatura")
public class Asignatura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nombre_asignatura")
	private String nombreAsignatura;
	
	@Column(name = "descripcion_asignatura")
	private String descripcionAsignatura;
	
	@Column(name = "bimestres")
	private int bimestres;
	
	@ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;
	
	@JsonIgnore
	@OneToMany(mappedBy = "asignatura", cascade = CascadeType.ALL)
    private List<NotasBimestrales> notasBimestrales = new ArrayList<>();

}
