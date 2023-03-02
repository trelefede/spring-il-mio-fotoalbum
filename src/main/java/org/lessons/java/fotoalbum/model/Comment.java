package org.lessons.java.fotoalbum.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "Nome non può essere nullo")
	@NotEmpty(message = "Nome non può essere vuoto")
	@Size(min = 3, max = 50, message = "Nome troppo corto/lungo")
	private String name;

	@NotNull(message = "Commento non può essere nullo")
	@NotEmpty(message = "Commento non può essere vuoto")
	@Size(min = 2, max = 500, message = "Commento troppo corto/lungo")
	private String text;

	@ManyToOne
	private Photo photo;

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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

}
