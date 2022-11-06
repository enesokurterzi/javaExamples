package Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.business.requests.langugage.CreateLanguageRequest;
import Kodlama.io.Devs.business.requests.langugage.DeleteLanguageRequest;
import Kodlama.io.Devs.business.requests.langugage.UpdateLanguageRequest;
import Kodlama.io.Devs.business.responses.language.GetAllLanguagesResponse;
import Kodlama.io.Devs.business.responses.language.GetByIdLanguagesResponse;

public interface LanguageService {
	List<GetAllLanguagesResponse> getAll();
	
	GetByIdLanguagesResponse getById(int id);
	
	void add(CreateLanguageRequest createLanguageRequest);
	void delete(DeleteLanguageRequest deleteLanguageRequest);
	void update(int id, UpdateLanguageRequest UpdatelanguageRequest);
}
