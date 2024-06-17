package etudiante.soa.model;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Lieu {
    private String nom_du_lieu;
    private List<Lieu> liaisons = new ArrayList<>();

    public Lieu(String nom_du_lieu) {
        this.nom_du_lieu = nom_du_lieu;
    }

    public void ajouter_une_liason_entre_deux_lieux (Lieu autre_lieu) {
        if (autre_lieu != null && !liaisons.contains(autre_lieu)) {
            this.liaisons.add(autre_lieu);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lieu lieu = (Lieu) o;

        return nom_du_lieu != null ? nom_du_lieu.equals(lieu.nom_du_lieu) : lieu.nom_du_lieu == null;
    }

    @Override
    public int hashCode() {
        return nom_du_lieu != null ? nom_du_lieu.hashCode() : 0;
    }
}