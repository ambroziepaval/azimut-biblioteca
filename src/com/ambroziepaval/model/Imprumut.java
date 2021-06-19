package com.ambroziepaval.model;

import java.util.Date;

public class Imprumut {

    private int id;
    private Carte carte;
    private Client client;
    private Date dataImprumut;
    private Date dataReturnare;

    public Imprumut() {
    }

    public Imprumut(int id, Carte carte, Client client, Date dataImprumut, Date dataReturnare) {
        this.id = id;
        this.carte = carte;
        this.client = client;
        this.dataImprumut = dataImprumut;
        this.dataReturnare = dataReturnare;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Carte getCarte() {
        return carte;
    }

    public void setCarte(Carte carte) {
        this.carte = carte;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDataImprumut() {
        return dataImprumut;
    }

    public void setDataImprumut(Date dataImprumut) {
        this.dataImprumut = dataImprumut;
    }

    public Date getDataReturnare() {
        return dataReturnare;
    }

    public void setDataReturnare(Date dataReturnare) {
        this.dataReturnare = dataReturnare;
    }

    @Override
    public String toString() {
        return "Imprumut{" +
                "id=" + id +
                ", carte=" + carte +
                ", client=" + client +
                ", dataImprumut=" + dataImprumut +
                ", dataReturnare=" + dataReturnare +
                '}';
    }
}
