package dao;

/**
 * @author Andrey Volinskiy on 07.02.2018.
 */
public interface VocabularyDao {

    String translate(String word);

    void add(String ukrWord, String engWord);

    void delete(String word);
}
