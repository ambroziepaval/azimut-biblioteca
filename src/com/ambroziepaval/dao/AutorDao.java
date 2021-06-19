package com.ambroziepaval.dao;

import com.ambroziepaval.model.Autor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutorDao extends GenericDao {

    public List<Autor> findAll() {
        List<Autor> autorList = new ArrayList<>();
        String query = """
                select id, nume, prenume
                from autor
                """;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Autor autor = new Autor();
                autor.setId(resultSet.getInt("id"));
                autor.setNume(resultSet.getString("nume"));
                autor.setPrenume(resultSet.getString("prenume"));
                autorList.add(autor);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return autorList;
    }

    public Autor findById(int id) {
        Autor autor = new Autor();
        String query = """
                select id, nume, prenume
                from autor
                where id=?
                """;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                autor.setId(resultSet.getInt("id"));
                autor.setNume(resultSet.getString("nume"));
                autor.setPrenume(resultSet.getString("prenume"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return autor;
    }

    public boolean save(Autor autor) {
        if (autor == null){
            return false;
        }

        String query = """
                insert into autor (nume, prenume) values (?,?)
                """;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, autor.getNume());
            preparedStatement.setString(2, autor.getPrenume());

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }

        return true;
    }

    public void deleteById(int id) {
        String query = """
                delete from autor
                where id=?
                """;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
