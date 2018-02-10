package dao;

import model.Vocabulary;

import java.util.List;

/**
 * @author Andrey Volinskiy on 07.02.2018.
 */
public interface VocabularyDao {

    List<Vocabulary> getAll();

    List<Vocabulary> find(String word);

    void add(String ukrWord, String engWord);

    void delete(String word);
}
