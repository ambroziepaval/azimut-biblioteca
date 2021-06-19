package com.ambroziepaval.dao;

import com.ambroziepaval.model.Autor;
import com.ambroziepaval.model.Carte;
import com.ambroziepaval.model.Gen;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarteDao extends GenericDao {

    public Carte findById(int id) {
        Carte carte = new Carte();
        String query = """
                select
                    c.id, c.denumire, c.an_aparitie, c.editura,
                    a.id, a.nume, a.prenume,
                    g.id, g.denumire
                from carte c
                inner join autor a on c.id_autor = a.id
                inner join gen g on c.id_gen = g.id
                where c.id = ?
                """;

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                carte.setId(resultSet.getInt("c.id"));
                carte.setDenumire(resultSet.getString("c.denumire"));
                carte.setAnAparitie(resultSet.getInt("c.an_aparitie"));
                carte.setEditura(resultSet.getString("c.editura"));

                Autor autor = new Autor();
                autor.setId(resultSet.getInt("a.id"));
                autor.setNume(resultSet.getString("a.nume"));
                autor.setPrenume(resultSet.getString("a.prenume"));
                carte.setAutor(autor);

                Gen gen = new Gen();
                gen.setId(resultSet.getInt("g.id"));
                gen.setDenumire(resultSet.getString("g.denumire"));
                carte.setGen(gen);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return carte;
    }

    public List<Carte> findAll() {
        List<Carte> carteList = new ArrayList<>();
        String query = """
                select
                    c.id, c.denumire, c.an_aparitie, c.editura,
                    a.id, a.nume, a.prenume,
                    g.id, g.denumire
                from carte c
                inner join autor a on c.id_autor = a.id
                inner join gen g on c.id_gen = g.id
                """;

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Carte carte = new Carte();
                carte.setId(resultSet.getInt("c.id"));
                carte.setDenumire(resultSet.getString("c.denumire"));
                carte.setAnAparitie(resultSet.getInt("c.an_aparitie"));
                carte.setEditura(resultSet.getString("c.editura"));

                Autor autor = new Autor();
                autor.setId(resultSet.getInt("a.id"));
                autor.setNume(resultSet.getString("a.nume"));
                autor.setPrenume(resultSet.getString("a.prenume"));
                carte.setAutor(autor);

                Gen gen = new Gen();
                gen.setId(resultSet.getInt("g.id"));
                gen.setDenumire(resultSet.getString("g.denumire"));
                carte.setGen(gen);
                carteList.add(carte);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return carteList;
    }

    public boolean save(Carte carte) {
        if (carte == null || carte.getAutor() == null || carte.getGen() == null) {
            return false;
        }

        String query = """
                insert into carte (denumire, an_aparitie, editura, id_autor, id_gen)
                values (?,?,?,?,?)
                """;
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, carte.getDenumire());
            preparedStatement.setInt(2, carte.getAnAparitie());
            preparedStatement.setString(3, carte.getEditura());
            preparedStatement.setInt(4, carte.getAutor().getId());
            preparedStatement.setInt(5, carte.getGen().getId());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }

        return true;
    }
}
