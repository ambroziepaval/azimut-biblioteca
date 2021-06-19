package com.ambroziepaval.model;

public class Client {

    private String cnp;
    private String nume;
    private String prenume;
    private String telefon;
    private String email;
    private String adresa;

    public Client() {
    }

    public Client(String cnp, String nume, String prenume, String telefon, String email, String adresa) {
        this.cnp = cnp;
        this.nume = nume;
        this.prenume = prenume;
        this.telefon = telefon;
        this.email = email;
        this.adresa = adresa;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return "Client{" +
                "cnp='" + cnp + '\'' +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", telefon='" + telefon + '\'' +
                ", email='" + email + '\'' +
                ", adresa='" + adresa + '\'' +
                '}';
    }
}
