package service.impl;

import dao.factory.DaoFactory;
import data.Database;
import service.VocabularyService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Andrey Volinskiy on 08.02.2018.
 */
public class VocabularyServiceImpl implements VocabularyService {

    private static final String TRANSLATION_UKR_ENG = "SELECT * FROM vocabulary WHERE ukr = ?";
    private static final String TRANSLATION_ENG_UKR = "SELECT * FROM vocabulary WHERE eng = ?";

    @Override
    public String translate(String word) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statementUkrEng = connection.prepareStatement(TRANSLATION_UKR_ENG);
             PreparedStatement statementEngUkr = connection.prepareStatement(TRANSLATION_ENG_UKR)) {
            statementUkrEng.setString(1, word);
            statementEngUkr.setString(1, word);
            ResultSet resultSet1 = statementUkrEng.executeQuery();
            ResultSet resultSet2 = statementEngUkr.executeQuery();
            if (resultSet1.next()) {
                return resultSet1.getString("eng");
            }
            if (resultSet2.next()) {
                return resultSet2.getString("ukr");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Translation impossible.";
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
