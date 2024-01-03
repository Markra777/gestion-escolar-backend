package org.colegio.web.model;

import java.util.ArrayList;
import java.util.Date;
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
@Table(name = "tb_estudiante")
public class Estudiante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "correo_electronico")
	private String email;
	
	@ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
	
	@JsonIgnore
	@OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL)
    private List<Matricula> matriculas = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL)
    private List<NotasBimestrales> notasBimestrales = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL)
    private List<Pension> pensiones = new ArrayList<>();
	

}
