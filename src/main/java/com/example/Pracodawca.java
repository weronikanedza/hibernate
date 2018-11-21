package com.example;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Pracodawca {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="pracodawca_id")
    private Long id;

    private String imie;
    private String nazwisko;
    private String wiek;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pracodawca")
    private Set<Pracownik> pracownicy = new HashSet<>();


    @OneToOne(fetch = FetchType.LAZY, mappedBy = "pracodawca", cascade = CascadeType.ALL)
    private Telefon telefon;

    public void dodajPracownika(Pracownik pracownik){
        this.pracownicy.add(pracownik);
        pracownik.setPracodawca(this);
    }

    public void dodajTelefon(Telefon telefon){
        this.telefon=telefon;
        telefon.setPracodawca(this);
    }

    /*****************Getters && Setters *****************/
    public Telefon getTelefon() {
        return telefon;
    }

    public void setTelefon(Telefon telefon) {
        this.telefon = telefon;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getWiek() {
        return wiek;
    }

    public void setWiek(String wiek) {
        this.wiek = wiek;
    }

    public Set<Pracownik> getPracownicy() {
        return pracownicy;
    }

    public void setPracownicy(Set<Pracownik> pracownicy) {
        this.pracownicy = pracownicy;
    }
}
