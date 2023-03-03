package org.lessons.java.fotoalbum.controller;

import java.util.List;

import org.lessons.java.fotoalbum.model.Category;
import org.lessons.java.fotoalbum.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepo;

	@GetMapping
	public String index(Model model) {
		List<Category> categories = categoryRepo.findAll();
		model.addAttribute("categories", categories);
		return "categories/index";
	}

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("category", new Category());
		return "categories/create";
	}

	@RequestMapping("/create")
	public String store(@Valid @ModelAttribute("category") Category formCategory, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			return "categories/create";
		}

		categoryRepo.save(formCategory);
		return "redirect:/categories";

	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("category", categoryRepo.getReferenceById(id));
		return ("categories/edit");
	}

	@PostMapping("/edit/{id}")
	public String update(@Valid @ModelAttribute("category") Category formCategory, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			return "categories/edit";
		}

		categoryRepo.save(formCategory);
		return "redirect:/categories";
	}

	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		categoryRepo.deleteById(id);
		return "redirect:/categories";
	}
}
