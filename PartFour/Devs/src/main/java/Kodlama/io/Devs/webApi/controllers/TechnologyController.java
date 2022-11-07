package Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.TechnologyService;
import Kodlama.io.Devs.business.requests.technology.CreateTechnologyRequest;
import Kodlama.io.Devs.business.requests.technology.DeleteTechnologyRequest;
import Kodlama.io.Devs.business.requests.technology.UpdateTechnologyRequest;
import Kodlama.io.Devs.business.responses.technology.GetAllTechnologiesResponse;

@RestController
@RequestMapping("/api/technologies")
public class TechnologyController {
	private TechnologyService technologyService;
	
	@Autowired
	public TechnologyController(TechnologyService technologyService) {
		this.technologyService = technologyService;
	}
	
	@GetMapping("/getall")
	public List<GetAllTechnologiesResponse> getAll() {
		return technologyService.getAll();
	}
	
	@PostMapping("/add")
	public void add(CreateTechnologyRequest createTechnologyRequest) {
		this.technologyService.add(createTechnologyRequest);
	}
	
	@DeleteMapping("/delete")
	public void deleteById(DeleteTechnologyRequest deleteTechnologyRequest) {
		this.technologyService.delete(deleteTechnologyRequest);
	}
	
	@PutMapping("update")
	public void updateById(int id, int languageId, UpdateTechnologyRequest updateTechnologyRequest) {
		this.technologyService.update(id, languageId, updateTechnologyRequest);
	}
	
}
