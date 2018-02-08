package dao;

import model.Vocabulary;

import java.util.List;

/**
 * @author Andrey Volinskiy on 07.02.2018.
 */
public interface VocabularyDao {

    List<String> getAllUkrainian();

    List<String> getAllEnglish();

    String translate(String word);

    void add(String ukrWord, String engWord);

    void delete(String word);
}
