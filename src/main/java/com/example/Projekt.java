package com.example;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="projekt")
public class Projekt {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "pracownik_id")
    private Long id;

    private String czasWykonania;
    private String nazwa;

    @ManyToMany(mappedBy = "projekty")
    private Set<Pracownik> pracownicy = new HashSet<>();

    /*****************Getters && Setters *****************/

    public Set<Pracownik> getPracownicy() {
        return pracownicy;
    }

    public void setPracownicy(Set<Pracownik> pracownicy) {
        this.pracownicy = pracownicy;
    }

    public String getCzasWykonania() {
        return czasWykonania;
    }

    public void setCzasWykonania(String czasWykonania) {
        this.czasWykonania = czasWykonania;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}
