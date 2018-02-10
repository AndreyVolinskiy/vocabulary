package service;

import model.Vocabulary;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Andrey Volinskiy on 08.02.2018.
 */
public interface VocabularyService {

    String find(StringBuilder preparedStatement) throws SQLException;

    List<Vocabulary> getAll();

    String translate(String word);

    void add(String ukrWord, String engWord);

    void delete(String word);
}
