package com.example;

import javax.persistence.*;

@Entity
public class Telefon {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="telefon_id")
    private Long id;

    private String nazwa;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pracodawca_id")
    private Pracodawca pracodawca;


    /*****************Getters && Setters *****************/
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Pracodawca getPracodawca() {
        return pracodawca;
    }

    public void setPracodawca(Pracodawca pracodawca) {
        this.pracodawca = pracodawca;
    }
}
