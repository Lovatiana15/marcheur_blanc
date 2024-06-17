package test;

import etudiante.soa.model.Carte;
import etudiante.soa.model.Lieu;
import etudiante.soa.model.Marcheur;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MarcheAleatoireTest {
    private Carte plan;
    private Lieu hei, pullman, balancoire, esti, nexta, boulevard, marais, sekolintsika;

    @BeforeEach
    public void setUp() {
        plan = new Carte();

        hei = new Lieu("HEI");
        pullman = new Lieu("Pullman");
        balancoire = new Lieu("Balançoire");
        esti = new Lieu("ESTI");
        nexta = new Lieu("Nexta");
        boulevard = new Lieu("Boulevard");
        marais = new Lieu("Marais");
        sekolintsika = new Lieu("sekolintsika");

        hei.ajouter_une_liason_entre_deux_lieux(pullman);
        hei.ajouter_une_liason_entre_deux_lieux(balancoire);

        pullman.ajouter_une_liason_entre_deux_lieux(hei);
        pullman.ajouter_une_liason_entre_deux_lieux(nexta);
        pullman.ajouter_une_liason_entre_deux_lieux(balancoire);

        balancoire.ajouter_une_liason_entre_deux_lieux(hei);
        balancoire.ajouter_une_liason_entre_deux_lieux(pullman);
        balancoire.ajouter_une_liason_entre_deux_lieux(boulevard);
        balancoire.ajouter_une_liason_entre_deux_lieux(esti);

        nexta.ajouter_une_liason_entre_deux_lieux(pullman);

        boulevard.ajouter_une_liason_entre_deux_lieux(balancoire);
        boulevard.ajouter_une_liason_entre_deux_lieux(esti);

        esti.ajouter_une_liason_entre_deux_lieux(balancoire);
        esti.ajouter_une_liason_entre_deux_lieux(boulevard);

        marais.ajouter_une_liason_entre_deux_lieux(sekolintsika);
        sekolintsika.ajouter_une_liason_entre_deux_lieux(marais);

        sekolintsika.ajouter_une_liason_entre_deux_lieux(hei);
        hei.ajouter_une_liason_entre_deux_lieux(sekolintsika);

        plan.ajouterLieu(hei);
        plan.ajouterLieu(pullman);
        plan.ajouterLieu(balancoire);
        plan.ajouterLieu(esti);
        plan.ajouterLieu(nexta);
        plan.ajouterLieu(boulevard);
        plan.ajouterLieu(marais);
        plan.ajouterLieu(sekolintsika);
    }

    @Test
    public void test_marche_aleatoire_HEI_Vers_ESTI() {
        Marcheur Bjarni = new Marcheur(hei, esti, plan);
        List<Lieu> marche = Bjarni.alle_vers();

        Assertions.assertEquals(hei, marche.get(0));
        Assertions.assertEquals(esti, marche.get(marche.size() - 1));

        for (int i = 0; i < marche.size() - 1; i++) {
            Lieu lieu_actuel = marche.get(i);
            Lieu lieu_suivant = marche.get(i + 1);
            Assertions.assertTrue(lieu_actuel.getLiaisons().contains(lieu_suivant));
        }
        marche.forEach(lieu -> System.out.print(lieu.getNom_du_lieu() + " -> "));
    }

    @Test
    public void test_marche_aleatoire_Marais_vers_Pullman() {
        Marcheur John = new Marcheur(marais, pullman, plan);
        List<Lieu> marche = John.alle_vers();

        Assertions.assertEquals(marais, marche.get(0));
        Assertions.assertEquals(pullman, marche.get(marche.size() - 1));

        for (int i = 0; i < marche.size() - 1; i++) {
            Lieu actuel = marche.get(i);
            Lieu suivant = marche.get(i + 1);
            Assertions.assertTrue(actuel.getLiaisons().contains(suivant));
        }
        marche.forEach(lieu -> System.out.print(lieu.getNom_du_lieu() + " -> "));
    }
}
