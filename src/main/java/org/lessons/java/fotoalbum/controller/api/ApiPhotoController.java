package org.lessons.java.fotoalbum.controller.api;

import java.util.List;
import java.util.Optional;

import org.lessons.java.fotoalbum.model.Photo;
import org.lessons.java.fotoalbum.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/photos")
public class ApiPhotoController {

	@Autowired
	PhotoRepository photoRepo;

	@GetMapping()
	public List<Photo> index() {
		List<Photo> photos = photoRepo.findAll();
		return photos;
	}

	@GetMapping("{id}")
	public ResponseEntity<Photo> show(@PathVariable("id") Integer id) {
		Optional<Photo> photo = photoRepo.findById(id);
		if (photo.isPresent()) {
			return new ResponseEntity<Photo>(photo.get(), HttpStatus.OK);
		} else
			return new ResponseEntity<Photo>(HttpStatus.NOT_FOUND);
	}
}
