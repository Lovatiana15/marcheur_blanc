package etudiante.soa.simule;

import etudiante.soa.model.Lieu;
import etudiante.soa.model.Marcheur;

import java.util.*;

public class Guide {
    private Marcheur marcheur;
    private Set<Lieu> lieux_a_explores = new HashSet<>();
    private Stack<Lieu> chemin = new Stack<>();

    public Guide(Marcheur marcheur) {
        this.marcheur = marcheur;
    }
    public List<Lieu> guider_vers(Lieu destination) {
        chemin.push(marcheur.getPositionActuelle());
        Lieu actuel = marcheur.getPositionActuelle();
        lieux_a_explores.add(actuel);
        while (!actuel.equals(destination)) {
            List<Lieu> lieux_non_visites = new ArrayList<>();
            for (Lieu prochain_lieu : actuel.getLiaisons()) {
                if (!lieux_a_explores.contains(prochain_lieu)) {
                    lieux_non_visites.add(prochain_lieu);
                }
            }
            if (lieux_non_visites.isEmpty()) {
                chemin.pop();
                if (chemin.isEmpty()) {
                    return new ArrayList<>(chemin);
                }
                actuel = chemin.peek();
            } else {
                Lieu prochainLieu = choisirProchainLieu(lieux_non_visites);
                chemin.push(prochainLieu);
                actuel = prochainLieu;
                lieux_a_explores.add(actuel);
            }

            marcheur.se_deplacer_vers(actuel);
        }
        return new ArrayList<>(chemin);
    }
    private Lieu choisirProchainLieu(List<Lieu> lieux_non_visites) {
        return lieux_non_visites.get(new Random().nextInt(lieux_non_visites.size()));
    }
}
