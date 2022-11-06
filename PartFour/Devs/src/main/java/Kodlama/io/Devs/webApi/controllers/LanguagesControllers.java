package Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.business.requests.langugage.CreateLanguageRequest;
import Kodlama.io.Devs.business.requests.langugage.DeleteLanguageRequest;
import Kodlama.io.Devs.business.requests.langugage.UpdateLanguageRequest;
import Kodlama.io.Devs.business.responses.language.GetAllLanguagesResponse;
import Kodlama.io.Devs.business.responses.language.GetByIdLanguagesResponse;

@RestController
@RequestMapping("/api/languages")
public class LanguagesControllers {
	private LanguageService languageService;

	@Autowired
	public LanguagesControllers(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@GetMapping("/getAll")
	public List<GetAllLanguagesResponse> getAll() {
		return languageService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetByIdLanguagesResponse getById(int id) {
		return languageService.getById(id);
	}
	
	@PostMapping("/add")
	public void add(CreateLanguageRequest createLanguageRequest) {
		this.languageService.add(createLanguageRequest);
	}
	
	@DeleteMapping("/delete")
	public void delete(DeleteLanguageRequest deleteLanguageRequest) {
		this.languageService.delete(deleteLanguageRequest);
	}
	
	@PutMapping("/update")
	public void update(int id, UpdateLanguageRequest updateLanguageRequest) {
		this.languageService.update(id, updateLanguageRequest);
	}

}
