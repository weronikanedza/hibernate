import com.example.Pracodawca;
import com.example.Pracownik;
import com.example.Projekt;
import com.example.Telefon;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Pracodawca pracodawca = new Pracodawca();
        zapiszDanePracodawcy(pracodawca, "Jarek", "Nowak", "43");

        Pracownik pracownik_1 = new Pracownik();
        zapiszDanePracownika(pracownik_1,"Andrzej","Wojciech","23");

        Pracownik pracownik_2 = new Pracownik();
        zapiszDanePracownika(pracownik_2,"Jurek","Rolka","34");

        pracodawca.dodajPracownika(pracownik_1);
        pracodawca.dodajPracownika(pracownik_2);


        Telefon telefon = new Telefon();
        telefon.setNazwa("Nokia");
        pracodawca.dodajTelefon(telefon);


        Projekt projekt_1 = new Projekt();
        zapiszDaneProjektu(projekt_1,"Multisport","30H");

        Projekt projekt_2 = new Projekt();
        zapiszDaneProjektu(projekt_2,"Kalendarz","8H");

        pracownik_1.dodajProjekt(projekt_1);
        pracownik_1.dodajProjekt(projekt_2);

        pracownik_2.dodajProjekt(projekt_1);

        entityManager.persist(pracodawca);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    private static void zapiszDaneProjektu(Projekt projekt,String nazwa,String czas){
        projekt.setNazwa(nazwa);
        projekt.setCzasWykonania(czas);
    }

    private static void zapiszDanePracodawcy(Pracodawca pracodawca, String imie, String nazwisko, String wiek) {
        pracodawca.setImie(imie);
        pracodawca.setNazwisko(nazwisko);
        pracodawca.setWiek(wiek);
    }

    private static void zapiszDanePracownika(Pracownik pracownik, String imie, String nazwisko, String wiek) {
        pracownik.setImie(imie);
        pracownik.setNazwisko(nazwisko);
        pracownik.setWiek(wiek);
    }
}
