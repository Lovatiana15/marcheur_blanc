package etudiante.soa.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@NoArgsConstructor
public class Carte {
    private Map<String, Lieu> lieux = new HashMap<>();
    public void ajouterLieu(Lieu lieu) {
        if (lieu != null && !lieux.containsKey(lieu.getNom_du_lieu())) {
            lieux.put(lieu.getNom_du_lieu(), lieu);
        }
    }

}