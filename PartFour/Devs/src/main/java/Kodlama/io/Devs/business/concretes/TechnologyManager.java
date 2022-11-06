package Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import Kodlama.io.Devs.business.abstracts.TechnologyService;
import Kodlama.io.Devs.business.requests.technology.DeleteTechnologyRequest;
import Kodlama.io.Devs.business.requests.technology.CreateTechnologyRequest;
import Kodlama.io.Devs.business.requests.technology.UpdateTechnologyRequest;
import Kodlama.io.Devs.business.responses.technology.GetAllTechnologiesResponse;
import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import Kodlama.io.Devs.entities.concretes.Language;
import Kodlama.io.Devs.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService {
	private TechnologyRepository technologyRepository;
	private LanguageRepository languageRepository;

	@Autowired
	public TechnologyManager(TechnologyRepository technologyRepository, LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
		this.technologyRepository = technologyRepository;
	}
	
	@Override
	public List<GetAllTechnologiesResponse> getAll() {
		List<Technology> technologies = technologyRepository.findAll();
		List<GetAllTechnologiesResponse> responses = new ArrayList<>();
		
		for(Technology technology: technologies) {
			GetAllTechnologiesResponse response = new GetAllTechnologiesResponse();
			
			response.setName(technology.getName());
			response.setLanguageName(technology.getLanguage().getName());
			
			responses.add(response);
		}
		return responses;
	}

	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) {
		Technology technology = new Technology();
		Language language = languageRepository.findById(createTechnologyRequest.getLangugageId()).get();
		
		technology.setName(createTechnologyRequest.getName());
		technology.setLanguage(language);
		technologyRepository.save(technology);
	}

	@Override
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
		technologyRepository.deleteById(deleteTechnologyRequest.getId());		
	}

	@Override
	public void update(int id, UpdateTechnologyRequest updateTechnologyRequest) {
		Technology technology = technologyRepository.findById(id).get();
		Language language = languageRepository.findById(updateTechnologyRequest.getLanguageId()).get();
		
		technology.setName(updateTechnologyRequest.getName());
		technology.setLanguage(language);
		technologyRepository.save(technology);
	}

}
