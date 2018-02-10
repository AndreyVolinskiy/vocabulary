package service;

import model.Vocabulary;

import java.util.List;

/**
 * @author Andrey Volinskiy on 08.02.2018.
 */
public interface VocabularyService {

    List<Vocabulary> getAll();

    String translate(String word);

    void add(String ukrWord, String engWord);

    void delete(String word);
}
