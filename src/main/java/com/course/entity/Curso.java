package com.course.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cursos")
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cursoId;
	
	@Column(name = "name_curso")
	private String nameCurso;
	
	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Alumno> alumnos = new ArrayList<Alumno>();
	
	@PrePersist
	private void prePersist() {
		this.createdAt = new Date();
	}

	public Long getCursoId() {
		return cursoId;
	}

	public void setCursoId(Long cursoId) {
		this.cursoId = cursoId;
	}

	public String getNameCurso() {
		return nameCurso;
	}

	public void setNameCurso(String nameCurso) {
		this.nameCurso = nameCurso;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void addAlumnos(Alumno alumno) {
		this.alumnos.add(alumno);
	}
	
	public void deleteAlumno(Alumno alumno) {
		this.alumnos.remove(alumno);
	}
	
	
	
	

}
