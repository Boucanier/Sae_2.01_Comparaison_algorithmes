package modele;

import java.util.ArrayList;

public class ManagerDeQuete {
    public ManagerDeQuete(){
        /*
        Constructeur de la classe ManagerDeQuete
         */
    }


    public int trouverQueteProche(Joueur joueur, ArrayList<Quete> listeQuetesRestantes){
        /*
        donne le numéro de la quête la plus proche si le joueur peut la faire

        Params:
            listeQuetesRestantes : liste des quetes avec leurs caractéristiques
         */
        return 0;
    }


    protected int distanceEntrePos(int[] parPos1, int[] parPos2){
        /*
        renvoie le nombre de déplacement nécessaire à la réalisation du déplacement d'un joueur d'une position 1 à une position 2

        Params:
        parPos1 : position de la quête 1
        parPos2 : position de la quête 2
         */
        return 0;
    }


    private boolean peutCommencerQuete(ArrayList<Integer> parcours, int[] parPrecond){
        /*
        renvoie true si le joueur à les préconditinos pour commencer une certaine quête, false sinon

        Params:
            parcours : le parcours que le joueur a réalisé
            parPrecond : les préconditions nécessaires pour réaliser la quête
         */
        return true;
    }


    public ArrayList niveau1(String choixSolution){
        /*
        correspond à la réalisation du premier niveau en fonction de choixSolution

        Params:
            choixSolution : chaine de caractaire équivalant soit à "efficace" soit à "exhaustive"
         */
        return new ArrayList<>();
    }
}
