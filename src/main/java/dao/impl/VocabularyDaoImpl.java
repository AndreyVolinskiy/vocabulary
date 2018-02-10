package dao.impl;

import dao.VocabularyDao;
import data.Database;
import model.Vocabulary;

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

    private static final String FIND_ALL = "SELECT * FROM vocabulary";
    private static final String FIND = "SELECT * FROM vocabulary WHERE ukr = ? OR eng = ?";
    private static final String INSERT = "INSERT INTO vocabulary (ukr, eng) VALUES (?,?)";
    private static final String DELETE = "DELETE FROM vocabulary WHERE ukr = ? OR eng = ?";

//   todo SELECT word FROM test WHERE word = 'Привіт' and language = 'eng';

    @Override
    public List<Vocabulary> getAll() {
        List<Vocabulary> list = new LinkedList<>();
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Vocabulary vocabulary = new Vocabulary();
                vocabulary.setUkr(resultSet.getString("ukr"));
                vocabulary.setEng(resultSet.getString("eng"));
                list.add(vocabulary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Vocabulary> find(String word) {
        List<Vocabulary> list = new LinkedList<>();
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND)) {
            statement.setString(1,word);
            statement.setString(2,word);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Vocabulary vocabulary = new Vocabulary();
                vocabulary.setUkr(resultSet.getString("ukr"));
                vocabulary.setEng(resultSet.getString("eng"));
                list.add(vocabulary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
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
