package org.lessons.java.fotoalbum.controller;

import java.util.List;

import org.lessons.java.fotoalbum.model.Photo;
import org.lessons.java.fotoalbum.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/photos")
public class index {

	@Autowired
	private PhotoRepository photoRepo;

	@GetMapping
	public String index(Model model) {
		List<Photo> photos = photoRepo.findAll();
		model.addAttribute("photos", photos);
		return "photos/index";
	}

	@GetMapping("/{id}")
	public String show(@PathVariable("id") Integer id, Model model) {
		Photo photo = photoRepo.getReferenceById(id);
		model.addAttribute("photo", photo);
		return ("photos/show");
	}

}
