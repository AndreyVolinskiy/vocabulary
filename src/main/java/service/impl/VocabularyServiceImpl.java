package service.impl;

import dao.factory.DaoFactory;
import service.VocabularyService;

/**
 * @author Andrey Volinskiy on 08.02.2018.
 */
public class VocabularyServiceImpl implements VocabularyService {

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
