package com.course.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "examenes")
public class Examen {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idExamen;
	
	@Column(name = "name_exam")
	private String nameExam;
	
	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@JsonIgnoreProperties(value = {"examen"}, allowSetters = true)
	@OneToMany(mappedBy = "examen", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Pregunta> preguntas;
	
	public Examen() {
		this.preguntas = new ArrayList<Pregunta>();
	}
	
	@PrePersist
	private void prePersist() {
		this.createdAt = new Date();
	}

	public Long getIdExamen() {
		return idExamen;
	}

	public void setIdExamen(Long idExamen) {
		this.idExamen = idExamen;
	}

	public String getNameExam() {
		return nameExam;
	}

	public void setNameExam(String nameExam) {
		this.nameExam = nameExam;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public List<Pregunta> getPreguntas() {
		return preguntas;
	}
	
	public void setPreguntas(List<Pregunta> preguntas) {
		//this.preguntas.clear();
		preguntas.forEach(this::addPregunta);		
	}

	public void addPregunta(Pregunta pregunta) {		
		this.preguntas.add(pregunta);
		pregunta.setExamen(this);		
	}
	
	public void removePregunta(Pregunta pregunta) {		
		this.preguntas.remove(pregunta);
		pregunta.setExamen(null);
		
	}
	
	

}
