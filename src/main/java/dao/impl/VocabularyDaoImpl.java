package dao.impl;

import dao.VocabularyDao;
import data.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Andrey Volinskiy on 07.02.2018.
 */
public class VocabularyDaoImpl implements VocabularyDao {

    private static final String SELECT_UKR = "SELECT ukr FROM vocabulary;";
    private static final String SELECT_ENG = "SELECT eng FROM vocabulary;";
    private static final String TRANSLATION = "SELECT * FROM vocabulary WHERE ukr = ? OR eng = ?";
    private static final String INSERT = "INSERT INTO vocabulary (ukr, eng) VALUES (?,?)";
    private static final String DELETE = "DELETE FROM vocabulary WHERE ukr = ? OR eng = ?";

    public List<String> getAllUkrainian() {
        List<String> list = new LinkedList<>();
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_UKR);) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(resultSet.getString("ukr"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<String> getAllEnglish() {
        List<String> list = new LinkedList<>();
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ENG)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(resultSet.getString("eng"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public String translate(String word) {
        String result;
        List<String> ukrList = getAllUkrainian();
        List<String> engList = getAllEnglish();

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(TRANSLATION)) {
            statement.setString(1, word);
            statement.setString(2, word);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                if (ukrList.contains(word)) {
                    result = resultSet.getString("eng");
                    return result;
                }
                if (engList.contains(word)) {
                    result = resultSet.getString("ukr");
                    return result;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Translation impossible.";
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
            statement.setString(1,word);
            statement.setString(2,word);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
