package com.example;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Pracownik {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "pracownik_id")
    private Long id;

    private String imie;
    private String nazwisko;
    private String wiek;

    @ManyToOne
    @JoinColumn(name = "pracodawca",referencedColumnName = "pracodawca_id")
    private Pracodawca pracodawca;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "pracownik_projekt",
            joinColumns = { @JoinColumn(name = "pracownik_id") },
            inverseJoinColumns = { @JoinColumn(name = "projekt_id") }
    )
    Set<Projekt> projekty = new HashSet<>();

    public void dodajProjekt(Projekt projekt){
        this.projekty.add(projekt);
        projekt.getPracownicy().add(this);
    }

    /*****************Getters && Setters *****************/
    public Set<Projekt> getProjekty() {
        return projekty;
    }

    public void setProjekty(Set<Projekt> projekty) {
        this.projekty = projekty;
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

    public Pracodawca getPracodawca() {
        return pracodawca;
    }

    public void setPracodawca(Pracodawca pracodawca) {
        this.pracodawca = pracodawca;
    }
}
