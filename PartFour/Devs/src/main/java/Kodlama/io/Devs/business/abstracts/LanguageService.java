package Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.entities.concretes.Language;

public interface LanguageService {
	List<Language> getAll();
	void create(Language language) throws Exception;
	void update(Language language) throws Exception;
	void delete(int id);
	Language findById(int id); 
}
