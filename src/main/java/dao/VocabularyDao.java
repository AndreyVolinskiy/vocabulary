package dao;

import model.Vocabulary;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Andrey Volinskiy on 07.02.2018.
 */
public interface VocabularyDao {

    List<Vocabulary> getAll();

    List<Vocabulary> find(String word);

    String find(StringBuilder preparedStatement) throws SQLException;

    void add(String ukrWord, String engWord);

    void delete(String word);
}
