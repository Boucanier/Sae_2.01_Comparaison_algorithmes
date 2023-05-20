package modele;

import java.util.ArrayList;

public class Joueur {
    private static int dureeTotal;
    private static ArrayList<Integer> parcours;
    private static int experience;
    private static int[] pos = new int[2];

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

    public static int getDureeTotal(){
        return dureeTotal;
    }
    
    public static int[] getPos(){
        return pos;
    }

    public static ArrayList getParcours(){
        return parcours;
    }

    public static int getExperience(){
        return experience;
    }

    public void setPos(int[] newPos){
        pos = newPos;
    }

    public void setDureeTotal(int newDuree){
        dureeTotal += newDuree;
    }

    public void setExperience(int newExperience){
        experience += newExperience;
    }

    public void ajoutQueteParcours(int numQuete){
        parcours.add(numQuete);
    }
}
