package modele;

import java.util.ArrayList;

/**
 * Classe représentant le scénario
 */
public class Scenario {
    private ArrayList<Quete> listeQuetes;

    /**
     * Constructeur de la classe Scenario
     */
    public Scenario() {
        listeQuetes = new ArrayList<Quete>();
    }

    /**
     * Renvoie une chaîne de caractères contenant les informations du scénario
     * @param listeQuetes
     */
    public String toString() {
        String msg = "";
        msg = msg + listeQuetes.size() + "\n";
        for (Quete quete : listeQuetes){
            msg = msg + quete + "\n";
        }
        return msg;
    }

    /**
     * Ajoute une quete à la liste des quetes
     * @param parQuete
     */
    public void ajout(Quete parQuete) {
        listeQuetes.add(parQuete);
    }


    /**
     * Renvoie la liste des quetes
     * @return
     */
    public ArrayList getListeQuetes(){
        return listeQuetes;
    }
}