package modele;

import java.util.ArrayList;

public class Scenario {
    private ArrayList<Quete> listeQuetes;

    public Scenario() {
        listeQuetes = new ArrayList<Quete>();
    }

    public String toString() {
        String msg = "";
        msg = msg + listeQuetes.size() + "\n";
        for (Quete quete : listeQuetes){
            msg = msg + quete + "\n";
        }
        return msg;
    }

    
    public void ajout(Quete parQuete) {
        /*
        Ajoute une quête à la suite de la liste de scénarios
     */
        listeQuetes.add(parQuete);
    }


    public ArrayList getListeQuetes(){
        /*
         * retourne la liste des quetes
         */
        return listeQuetes;
    }
}