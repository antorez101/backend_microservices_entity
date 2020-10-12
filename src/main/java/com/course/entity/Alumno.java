package com.course.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "alumnos")
public class Alumno {
	
	@Column(name = "id_alumno")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAlumno;
	
	@Column(name = "name_alumno")
	private String nameAlumno;
	
	@Column(name = "last_name_alumno")
	private String lastNameAlumno;
	
	private String email;
	
	@Column(name = "created_at")
	@Temporal(TemporalType.DATE)
	private Date createdAt;
	
	@PrePersist
	public void prePersist() {
		this.createdAt = new Date();
	}

	
	public Long getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Long idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getNameAlumno() {
		return nameAlumno;
	}

	public void setNameAlumno(String nameAlumno) {
		this.nameAlumno = nameAlumno;
	}

	public String getLastNameAlumno() {
		return lastNameAlumno;
	}

	public void setLastNameAlumno(String lastNameAlumno) {
		this.lastNameAlumno = lastNameAlumno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((idAlumno == null) ? 0 : idAlumno.hashCode());
		result = prime * result + ((lastNameAlumno == null) ? 0 : lastNameAlumno.hashCode());
		result = prime * result + ((nameAlumno == null) ? 0 : nameAlumno.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idAlumno == null) {
			if (other.idAlumno != null)
				return false;
		} else if (!idAlumno.equals(other.idAlumno))
			return false;
		if (lastNameAlumno == null) {
			if (other.lastNameAlumno != null)
				return false;
		} else if (!lastNameAlumno.equals(other.lastNameAlumno))
			return false;
		if (nameAlumno == null) {
			if (other.nameAlumno != null)
				return false;
		} else if (!nameAlumno.equals(other.nameAlumno))
			return false;
		return true;
	}
	
	
	

}
