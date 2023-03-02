package org.lessons.java.fotoalbum.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Photo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "Titolo non può essere nullo")
	@NotEmpty(message = "Titolo non può essere vuoto")
	@Size(min = 3, max = 50, message = "Titolo troppo corto/lungo")
	private String title;

	@Size(min = 10, max = 500, message = "Descrizione troppo corta/lunga")
	private String description;

	@NotNull(message = "Url immagine non può essere nullo")
	@NotEmpty(message = "Url immagine non può essere vuoto")
	@Size(min = 10, max = 999999999, message = "Url troppo corto/lungo")
	@Column(name = "image_url")
	private String url;

	@NotNull(message = "I tag non possono essere nulli")
	@NotEmpty(message = "I tag non possono essere vuoti")
	@Size(min = 1, max = 200, message = "Tag troppo corto/lungo")
	private String tag;

	@NotNull(message = "La visibilità non può essere nulla")
	@NotEmpty(message = "La visibilità non può essere vuota")
	private Boolean visible;

	@ManyToMany(mappedBy = "photo")
	private List<Category> categories;

	@OneToMany(mappedBy = "photo")
	private List<Comment> comments;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}
