package service;

/**
 * @author Andrey Volinskiy on 08.02.2018.
 */
public interface VocabularyService {

    String translate(String word);

    void add(String ukrWord, String engWord);

    void delete(String word);
}
