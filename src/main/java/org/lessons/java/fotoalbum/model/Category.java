package org.lessons.java.fotoalbum.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "Nome categoria non può essere nullo")
	@NotEmpty(message = "Nome categoria non può essere vuoto")
	@Size(min = 3, max = 50, message = "Nome categoria troppo corto/lungo")
	private String name;

	@ManyToMany(mappedBy = "categories")
	private List<Photo> photo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Photo> getPhotos() {
		return photo;
	}

	public void setPhotos(List<Photo> photos) {
		this.photo = photos;
	}

}
