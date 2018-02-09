package service.impl;

import dao.factory.DaoFactory;
import service.VocabularyService;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Andrey Volinskiy on 08.02.2018.
 */
public class VocabularyServiceImpl implements VocabularyService {

    public static final String IMPOSSIBLE = "Translation impossible.";

    @Override
    public String translate(String word) {
        String translatedWord = IMPOSSIBLE;
        ResultSet resultSet = DaoFactory.getVocabularyDao().find(word);
        try {
            resultSet.next();
            if (resultSet.getString("ukr").equals(word)) {
                translatedWord = resultSet.getString("eng");
            }
            if (resultSet.getString("eng").equals(word)) {
                translatedWord = resultSet.getString("ukr");
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
