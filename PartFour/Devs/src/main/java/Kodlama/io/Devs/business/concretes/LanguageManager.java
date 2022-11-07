package Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.business.requests.langugage.CreateLanguageRequest;
import Kodlama.io.Devs.business.requests.langugage.DeleteLanguageRequest;
import Kodlama.io.Devs.business.requests.langugage.UpdateLanguageRequest;
import Kodlama.io.Devs.business.responses.language.GetAllLanguagesResponse;
import Kodlama.io.Devs.business.responses.language.GetByIdLanguagesResponse;
import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {
	private LanguageRepository languageRepository;
	
	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public List<GetAllLanguagesResponse> getAll() {
		List<Language> languages = languageRepository.findAll();
		List<GetAllLanguagesResponse> languageResponse = new ArrayList<GetAllLanguagesResponse>();
		
		for(Language language: languages) {
			GetAllLanguagesResponse responseItem = new GetAllLanguagesResponse();
			responseItem.setId(language.getId());
			responseItem.setName(language.getName());
			languageResponse.add(responseItem);
		}
		
		return languageResponse;
	}

	@Override
	public GetByIdLanguagesResponse getById(int id) {
		Language language = languageRepository.findById(id).get();
		GetByIdLanguagesResponse response = new GetByIdLanguagesResponse();
		response.setName(language.getName());
		return response;
	}

	@Override
	public void add(CreateLanguageRequest createLanguageRequest) {
		Language language = new Language();
		language.setName(createLanguageRequest.getName());
		
		if (!isLanguageEmpty(language) && !isLanguageNameExist(language)) {
			this.languageRepository.save(language);
		} else {
			System.err.println("Duplicate or blank data cannot be entered.");
		}
		
		
	}

	@Override
	public void delete(DeleteLanguageRequest deleteLanguageRequest) {
		languageRepository.deleteById(deleteLanguageRequest.getId());		
	}

	@Override
	public void update(int id, UpdateLanguageRequest updatelanguageRequest) {
		if (!updatelanguageRequest.getName().isEmpty()) {
			Language language = languageRepository.findById(id).get();
			language.setName(updatelanguageRequest.getName());
			languageRepository.save(language);
		}		
	}
	
	private boolean isLanguageNameExist (Language language){
        for(Language languageall : languageRepository.findAll()){
            if(languageall.getName().equalsIgnoreCase(language.getName()))
                return true;
        }
        return false;
    }
    private  boolean isLanguageEmpty(Language language){
        return language.getName().isEmpty() || language.getName().isBlank();
    }
	
	
	
}
