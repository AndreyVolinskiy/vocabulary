package dao;

import java.sql.ResultSet;

/**
 * @author Andrey Volinskiy on 07.02.2018.
 */
public interface VocabularyDao {

    ResultSet find(String word);

    void add(String ukrWord, String engWord);

    void delete(String word);
}
