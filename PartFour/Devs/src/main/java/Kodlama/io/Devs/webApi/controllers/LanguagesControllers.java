package Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguagesControllers {
	private LanguageService languageService;

	@Autowired
	public LanguagesControllers(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@PostMapping("/add")
	public void add(Language language) throws Exception {
		languageService.create(language);
	}
	
	@DeleteMapping("/delete")
	public void delete(int id) {	
		languageService.delete(id);
	}
	
	@PutMapping("/update")
	public void update(Language language) throws Exception {
		languageService.update(language);
	}
	
	@GetMapping("/getall")
	public List<Language> getAll(){
		return languageService.getAll();
	}
	
	@GetMapping("/getbyid")
	public Language getById(@RequestParam int id){
		return languageService.findById(id);
	}
	

}
