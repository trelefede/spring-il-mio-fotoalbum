package org.lessons.java.fotoalbum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/my-photos")
public class FrontController {

	@GetMapping()
	public String index() {
		return "api/index";
	}
	
	@GetMapping("/show")
	public String show() {
		return "api/show";
	}
}
