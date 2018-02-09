package dao.impl;

import dao.VocabularyDao;
import data.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Andrey Volinskiy on 07.02.2018.
 */
public class VocabularyDaoImpl implements VocabularyDao {

    private static final String FIND = "SELECT * FROM vocabulary WHERE ukr = ? OR eng = ?";
    private static final String INSERT = "INSERT INTO vocabulary (ukr, eng) VALUES (?,?)";
    private static final String DELETE = "DELETE FROM vocabulary WHERE ukr = ? OR eng = ?";

    @Override
    public ResultSet find(String word) {
        ResultSet resultSet = null;
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND)) {
            statement.setString(1,word);
            statement.setString(2,word);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void add(String ukrWord, String engWord) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setString(1, ukrWord);
            statement.setString(2, engWord);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String word) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setString(1, word);
            statement.setString(2, word);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
