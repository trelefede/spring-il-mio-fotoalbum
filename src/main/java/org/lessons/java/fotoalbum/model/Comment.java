package org.lessons.java.fotoalbum.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "Nome non può essere nullo")
	@NotEmpty(message = "Nome non può essere vuoto")
	@Min(value = 3, message = "Nome troppo corto")
	@Max(value = 50, message = "Nome troppo lungo")
	private String name;

	@NotNull(message = "Commento non può essere nullo")
	@NotEmpty(message = "Commento non può essere vuoto")
	@Min(value = 2, message = "Nome troppo corto")
	@Max(value = 500, message = "Nome troppo lungo")
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
