package service.impl;

import dao.factory.DaoFactory;
import dao.impl.VocabularyDaoImpl;
import service.VocabularyService;

import java.util.List;

/**
 * @author Andrey Volinskiy on 08.02.2018.
 */
public class VocabularyServiceImpl implements VocabularyService {
    @Override
    public List<String> getAllUkrainian() {
        return DaoFactory.getVocabularyDao().getAllUkrainian();
    }

    @Override
    public List<String> getAllEnglish() {
        return DaoFactory.getVocabularyDao().getAllEnglish();
    }

    @Override
    public String translate(String word) {
        return DaoFactory.getVocabularyDao().translate(word);
    }

    @Override
    public void add(String ukrWord, String engWord) {
        DaoFactory.getVocabularyDao().add(ukrWord, engWord);
    }

    @Override
    public void delete(String word) {
        DaoFactory.getVocabularyDao().delete(word);
    }
}
