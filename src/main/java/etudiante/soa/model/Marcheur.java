package etudiante.soa.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@NoArgsConstructor
public class Marcheur {
    private Lieu pointDeDepart;
    private Lieu destination;
    private Carte plan;

    public Marcheur(Lieu pointDeDepart, Lieu destination, Carte plan) {
        this.pointDeDepart = pointDeDepart;
        this.destination = destination;
        this.plan = plan;
    }

    public List<Lieu> alle_vers() {
        List<Lieu> chemin = new ArrayList<>();
        Set<Lieu> visites = new HashSet<>();
        Lieu actuel = pointDeDepart;
        Random random = new Random();

        while (!actuel.equals(destination)) {
            chemin.add(actuel);
            visites.add(actuel);

            List<Lieu> lieu_non_visites = new ArrayList<>();
            for (Lieu lieu_apres : actuel.getLiaisons()) {
                if (!visites.contains(lieu_apres)) {
                    lieu_non_visites.add(lieu_apres);
                }
            }

            if (lieu_non_visites .isEmpty()) {
                lieu_non_visites .addAll(actuel.getLiaisons());
            }

            actuel = lieu_non_visites .get(random.nextInt(lieu_non_visites .size()));
        }

        chemin.add(destination);
        return chemin;
    }
}