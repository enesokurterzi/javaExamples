package Kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import Kodlama.io.Devs.entities.concretes.Language;

public interface LanguageRepository {
	List<Language> getAll();
	void create(Language language);
	void update(Language language);
	void delete(int id);
	Language findById(int id);
}
