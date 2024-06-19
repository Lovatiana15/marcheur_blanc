package etudiante.soa.model;

import etudiante.soa.model.Lieu;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class Marcheur {
    private Lieu positionActuelle;
    private Set<Lieu> lieuxVisites = new HashSet<>();

    public Marcheur(Lieu pointDeDepart) {
        this.positionActuelle = pointDeDepart;
        this.lieuxVisites.add(pointDeDepart);
    }
    public void se_deplacer_vers(Lieu nouveauLieu) {
        this.positionActuelle = nouveauLieu;
        this.lieuxVisites.add(nouveauLieu);
    }
}