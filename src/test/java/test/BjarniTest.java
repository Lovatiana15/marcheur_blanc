package test;

import etudiante.soa.model.Carte;
import etudiante.soa.model.Lieu;
import etudiante.soa.model.Marcheur;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class BjarniTest {

    @Test
    public void testMarcheAleatoire() {
        Carte plan = new Carte();

        Lieu hei = new Lieu("HEI");
        Lieu pullman = new Lieu("Pullman");
        Lieu balancoire = new Lieu("Balançoire");
        Lieu esti = new Lieu("ESTI");
        Lieu nexta = new Lieu("Nexta");
        Lieu boulevard = new Lieu("Boulevard");
        Lieu marais = new Lieu("Marais");
        Lieu sekolintsika = new Lieu("sekolintsika");

        hei.ajouter_une_liason_entre_deux_lieux((pullman));
        hei.ajouter_une_liason_entre_deux_lieux((balancoire));

        pullman.ajouter_une_liason_entre_deux_lieux((hei));
        pullman.ajouter_une_liason_entre_deux_lieux((nexta));
        pullman.ajouter_une_liason_entre_deux_lieux((balancoire));

        balancoire.ajouter_une_liason_entre_deux_lieux((hei));
        balancoire.ajouter_une_liason_entre_deux_lieux((pullman));
        balancoire.ajouter_une_liason_entre_deux_lieux((boulevard));
        balancoire.ajouter_une_liason_entre_deux_lieux((esti));

        nexta.ajouter_une_liason_entre_deux_lieux((pullman));

        boulevard.ajouter_une_liason_entre_deux_lieux((balancoire));
        boulevard.ajouter_une_liason_entre_deux_lieux((esti));

        esti.ajouter_une_liason_entre_deux_lieux((balancoire));
        esti.ajouter_une_liason_entre_deux_lieux((boulevard));

        marais.ajouter_une_liason_entre_deux_lieux((sekolintsika));
        sekolintsika.ajouter_une_liason_entre_deux_lieux((marais));

        sekolintsika.ajouter_une_liason_entre_deux_lieux((hei));
        hei.ajouter_une_liason_entre_deux_lieux((sekolintsika));

        plan.ajouterLieu(hei);
        plan.ajouterLieu(pullman);
        plan.ajouterLieu(balancoire);
        plan.ajouterLieu(esti);
        plan.ajouterLieu(nexta);
        plan.ajouterLieu(boulevard);
        plan.ajouterLieu(marais);
        plan.ajouterLieu(sekolintsika);

        Marcheur Bjarni = new Marcheur(hei, nexta, plan);
        List<Lieu> marche = Bjarni.alle_vers();

        assertEquals(hei, marche.get(0));
        assertEquals(nexta, marche.get(marche.size() - 1));

        for (int i = 0; i < marche.size() - 1; i++) {
            Lieu actuel = marche.get(i);
            Lieu suivant = marche.get(i + 1);
            assertTrue(actuel.getLiaisons().contains(suivant));
        }

        marche.forEach(lieu -> System.out.print(lieu.getNom_du_lieu() + " -> "));
    }
}
