package service;

import java.util.List;

/**
 * @author Andrey Volinskiy on 08.02.2018.
 */
public interface VocabularyService {

    List<String> getAllUkrainian();

    List<String> getAllEnglish();

    String translate(String word);

    void add(String ukrWord, String engWord);

    void delete(String word);
}
