package com.ambroziepaval.model;

public class Carte {

    private int id;
    private String denumire;
    private int anAparitie;
    private String editura;
    private Autor autor;
    private Gen gen;

    public Carte() {
    }

    public Carte(int id, String denumire, int anAparitie, String editura, Autor autor, Gen gen) {
        this.id = id;
        this.denumire = denumire;
        this.anAparitie = anAparitie;
        this.editura = editura;
        this.autor = autor;
        this.gen = gen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getAnAparitie() {
        return anAparitie;
    }

    public void setAnAparitie(int anAparitie) {
        this.anAparitie = anAparitie;
    }

    public String getEditura() {
        return editura;
    }

    public void setEditura(String editura) {
        this.editura = editura;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Gen getGen() {
        return gen;
    }

    public void setGen(Gen gen) {
        this.gen = gen;
    }

    @Override
    public String toString() {
        return "Carte{" +
                "id=" + id +
                ", denumire='" + denumire + '\'' +
                ", anAparitie=" + anAparitie +
                ", editura='" + editura + '\'' +
                ", autor=" + autor +
                ", gen=" + gen +
                '}';
    }
}
