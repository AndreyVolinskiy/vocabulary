package service.impl;

import dao.VocabularyDao;
import dao.factory.DaoFactory;
import dao.impl.VocabularyDaoImpl;
import model.Vocabulary;
import service.VocabularyService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Andrey Volinskiy on 08.02.2018.
 */
public class VocabularyServiceImpl implements VocabularyService {

    public static final String IMPOSSIBLE = "Translation impossible.";

    @Override
    public List<Vocabulary> getAll() {
        return DaoFactory.getVocabularyDao().getAll();
    }

    @Override
    public String translate(String word) {
        String translatedWord = IMPOSSIBLE;
        List<Vocabulary> list = DaoFactory.getVocabularyDao().find(word);

        for (Vocabulary elem : list) {
            if (elem.getEng().equals(word)) {
                translatedWord = elem.getUkr();
            }
            if (elem.getUkr().equals(word)) {
                translatedWord = elem.getEng();
            }
        }
        return translatedWord;
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
