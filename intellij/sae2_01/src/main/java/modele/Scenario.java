package modele;

import java.util.ArrayList;

public class Scenario {
    private ArrayList<Quete> listeQuetes;

    public Scenario() {
        listeQuetes = new ArrayList<Quete>();
    }

    public String toString() {
        return listeQuetes.size() + " " + listeQuetes;
    }

    /*
        Ajoute une quête à la suite de la liste de scénarios
     */
    public void ajout(Quete parQuete) {
        listeQuetes.add(parQuete);
    }
}