package Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.LanguageService;
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
	public List<Language> getAll() {
		return languageRepository.getAll();
	}

	@Override
	public void create(Language language) throws Exception {
		if(language.getName().length() != 0) {
            for(Language Languages : languageRepository.getAll()) {
                if(Languages.getName().equalsIgnoreCase(language.getName())) {
                    throw new Exception("Aynı isimde 2 adet programlama dili olamaz.");
                }
            }
            languageRepository.create(language);
        } else {
            throw new Exception("Programlama dili boş geçilemez.");
        }
		
	}

	@Override
	public void update(Language language) throws Exception {
		if(language.getName().length() != 0) {
            for(Language Languages : languageRepository.getAll()) {
                if(Languages.getName().equalsIgnoreCase(language.getName())) {
                    throw new Exception("Aynı isimde 2 adet programlama dili olamaz.");
                }
            }
            languageRepository.update(language);
        } else {
            throw new Exception("Programlama dili boş geçilemez.");
        }
		
	}

	@Override
	public void delete(int id) {
		languageRepository.delete(id);
		
	}

	@Override
	public Language findById(int id) {
		return languageRepository.findById(id);
	}
	
}
