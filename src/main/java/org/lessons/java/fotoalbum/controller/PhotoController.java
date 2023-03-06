package org.lessons.java.fotoalbum.controller;

import java.util.List;

import org.lessons.java.fotoalbum.model.Category;
import org.lessons.java.fotoalbum.model.Photo;
import org.lessons.java.fotoalbum.repository.CategoryRepository;
import org.lessons.java.fotoalbum.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/photos")
public class PhotoController {

	@Autowired
	private PhotoRepository photoRepo;

	@Autowired
	private CategoryRepository categoryRepo;

	@GetMapping
	public String index(@RequestParam(name = "search", required = false) String search, Model model) {
		List<Photo> photos;

		if (search != null && !search.isEmpty()) {
			photos = photoRepo.findByTitleLike("%" + search + "%");
			if (photos.isEmpty()) {
				photos = photoRepo.findByTagLike("%" + search + "%");
			}
		} else {
			photos = photoRepo.findAll();
		}

		model.addAttribute("photos", photos);
		return "photos/index";
	}

	@GetMapping("/{id}")
	public String show(@PathVariable("id") Integer id, Model model) {
		Photo photo = photoRepo.getReferenceById(id);
		model.addAttribute("photo", photo);
		return ("photos/show");
	}

	@GetMapping("/create")
	public String create(Model model) {
		List<Category> categories = categoryRepo.findAll();
		model.addAttribute("categories", categories);
		model.addAttribute("photo", new Photo());
		return "photos/create";
	}

	@RequestMapping("/create")
	public String store(@Valid @ModelAttribute("photo") Photo formPhoto, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "photos/create";
		}

		photoRepo.save(formPhoto);
		return "redirect:/photos";

	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, Model model) {
		List<Category> categories = categoryRepo.findAll();
		model.addAttribute("categories", categories);
		model.addAttribute("photo", photoRepo.getReferenceById(id));
		return ("photos/edit");
	}

	@PostMapping("/edit/{id}")
	public String update(@Valid @ModelAttribute("photo") Photo formPhoto, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "photos/edit";
		}

		photoRepo.save(formPhoto);
		return "redirect:/photos";
	}

	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		photoRepo.deleteById(id);
		return "redirect:/photos";
	}

}
