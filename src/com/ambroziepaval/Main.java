package com.ambroziepaval;

import com.ambroziepaval.dao.AutorDao;
import com.ambroziepaval.dao.CarteDao;
import com.ambroziepaval.model.Autor;
import com.ambroziepaval.model.Carte;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        workWithAutors();

        System.out.println("\nCARTE");
        CarteDao carteDao = new CarteDao();
        Carte carte1 = carteDao.findById(1);
        System.out.println(carte1);

        Carte newCarte = new Carte();
        newCarte.setDenumire("Ambrozie's History");
        newCarte.setEditura("Rao");
        newCarte.setAnAparitie(2021);
        newCarte.setGen(carte1.getGen());
        newCarte.setAutor(new Autor(1));
        carteDao.save(newCarte);
    }

    private static void workWithAutors() {
        System.out.println("\nAUTOR");
        AutorDao autorDao = new AutorDao();
        Autor autor1 = autorDao.findById(1);
        System.out.println(autor1);

        Autor autorAmbrozie = new Autor("Paval", "Ambrozie");
        autorDao.save(autorAmbrozie);

        List<Autor> allAutors = autorDao.findAll();
        System.out.println(allAutors);

        autorDao.save(null);
    }
}
