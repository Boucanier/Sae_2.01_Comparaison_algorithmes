package modele;

import java.util.ArrayList;

/**
 * Classe représentant le joueur et ses caractéristiques
 */
public class Joueur {
    private static int dureeTotal;
    private static ArrayList<Integer> parcoursNum;
    private static ArrayList<Quete> parcoursQuete;
    private static int experience;
    private static int[] pos = new int[2];

    /**
     * Constructeur de la classe Joueur
     */
    public Joueur() {
        dureeTotal = 0;
        parcoursNum = new ArrayList<>();
        parcoursQuete = new ArrayList<>();
        experience = 0; // il n'a aucune expérience dès sa création

        //le joueur est en (0, 0) dès qu'il apparait
        pos[0] = 0;
        pos[1] = 0;
    }

    /**
     * Méthode qui permet de récupérer la durée que le joueur a mis
     * @return int
     */
    public static int getDureeTotal(){
        return dureeTotal;
    }
    
    /**
     * Méthode qui permet de récupérer la position du joueur
     * @return int[]
     */
    public static int[] getPos(){
        return pos;
    }

    /**
     * Permet de récupérer les numéros des quêtes que le joueur a fait
     * @return ArrayList<Integer>
     */
    public static ArrayList<Integer> getParcoursNum(){
        return parcoursNum;
    }

    /**
     * Permet de récupérer les quêtes que le joueur a fait
     * @return ArrayList<Quete>
     */
    public static ArrayList<Quete> getParcoursQuete(){
        return parcoursQuete;
    }

    /**
     * Permet de récupérer l'expérience du joueur
     * @return int
     */
    public static int getExperience(){
        return experience;
    }

    /**
     * Permet de modifier la position du joueur
     * @param newPos
     */
    public void setPos(int[] newPos){
        pos = newPos;
    }

    /**
     * Permet de modifier la durée que le joueur a mis
     * @param newDuree
     */
    public void setDureeTotal(int newDuree){
        dureeTotal += newDuree;
    }

    /**
     * Permet de modifier l'expérience du joueur
     * @param newExperience
     */
    public void setExperience(int newExperience){
        experience += newExperience;
    }

    /**
     * Permet de modifier les numéros des quêtes que le joueur a fait
     * @param newParcoursNum
     */
    public void ajoutQueteParcoursNum(int numQuete){
        parcoursNum.add(numQuete);
    }

    /**
     * Permet de modifier les quêtes que le joueur a fait
     * @param newParcoursQuete
     */
    public void ajoutQueteParcours(Quete queteAAjouter){
        parcoursQuete.add(queteAAjouter);
        ajoutQueteParcoursNum(queteAAjouter.getNumero());
    }

    /**
     * Renvoie une chaîne de caractères représentant le parcours du joueur
     * @return String
     */
    public String toString(){
        return parcoursNum.toString();
    }
}
