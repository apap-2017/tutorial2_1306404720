package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	
	@RequestMapping("/hello123")
	public String index() {
			return "hello";
	}
	
	@RequestMapping("/greeting")
	public String greeting (@RequestParam(value = "name", required=false, defaultValue = "dunia") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
	
	@RequestMapping(value = {"/greeting", "greeting/{name}"})
	public String greetingPath(@PathVariable Optional<String> name, Model model) {
		if(name.isPresent()) {
			model.addAttribute("name", name.get());
		}else {
			model.addAttribute("name", "dengklek");
		}
		
		return "greeting";
	}
	
	@RequestMapping("/perkalian")
	public String perkalian(@RequestParam(required = false) Integer a, 
							@RequestParam(required = false) Integer b, 
							Model model) {
		if(a == null && b == null) {
			a = 0;
			b = 0;
			model.addAttribute("a", a);
			model.addAttribute("b", b);
		}else if(a == null) {
			a = 0;
			model.addAttribute("a", a);
			model.addAttribute("b", b);
		}else if(b == null) {
			b = 0;
			model.addAttribute("a", a);
			model.addAttribute("b", b);
		}
		else{
			model.addAttribute("a", a);
			model.addAttribute("b", b);			
		}
		return "perkalian";
		
	}
}
