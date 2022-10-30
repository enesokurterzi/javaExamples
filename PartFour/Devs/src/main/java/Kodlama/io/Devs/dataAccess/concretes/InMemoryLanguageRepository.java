package Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entities.concretes.Language;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {
	List<Language> languages;
	
	public InMemoryLanguageRepository() {
		languages = new ArrayList<>();
		languages.add(new Language(1, "Java"));
		languages.add(new Language(2, "C#"));
		languages.add(new Language(3, "Python"));
		languages.add(new Language(4, "JavaScript"));
	}

	@Override
	public List<Language> getAll() {
		return languages;
	}

	@Override
	public void create(Language language) {
		languages.add(language);
	}

	@Override
	public void update(Language language) {
		languages.set(language.getId(), language);		
	}

	@Override
	public void delete(int id) {
		languages.remove(id);	
	}

	@Override
	public Language findById(int id) {
		return languages.get(id);
	}
	

}
