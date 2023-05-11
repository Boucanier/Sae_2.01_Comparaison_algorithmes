package modele;

import java.util.ArrayList;

public class Joueur {
    private int dureeTotal;
    private ArrayList<Integer> parcours;
    private int experience;
    private int[] pos = new int[2];

    public Joueur() {
        /*
         * Constructeur de la classe joueur
         */
        dureeTotal = 0;
        parcours = new ArrayList<>();
        experience = 0; // il n'a aucune expérience dès sa création

        //le joueur est en (0, 0) dès qu'il apparait
        pos[0] = 0;
        pos[1] = 0;
    }
}
