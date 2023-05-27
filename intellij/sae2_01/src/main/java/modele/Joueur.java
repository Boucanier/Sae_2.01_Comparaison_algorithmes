package modele;

import java.util.ArrayList;

/**
 * Classe représentant le joueur et ses caractéristiques
 */
public class Joueur {
    private int dureeTotal;
    private ArrayList<Integer> parcoursNum;
    private ArrayList<Quete> parcoursQuete;
    private ArrayList<int[]> arrayPos;
    private ArrayList<Integer> arrayExperience;
    private int experience;
    private int[] pos = new int[2];

    /**
     * Constructeur de la classe Joueur
     */
    public Joueur() {
        dureeTotal = 0;
        parcoursNum = new ArrayList<>();
        parcoursQuete = new ArrayList<>();
        arrayPos = new ArrayList<>();
        arrayExperience = new ArrayList<>();
        experience = 0; // il n'a aucune expérience dès sa création

        //le joueur est en (0, 0) dès qu'il apparait
        pos[0] = 0;
        pos[1] = 0;
    }

    /**
     * Méthode qui permet de récupérer la durée que le joueur a mis
     * @return int
     */
    public int getDureeTotal(){
        return dureeTotal;
    }
    
    /**
     * Méthode qui permet de récupérer la position du joueur
     * @return int[]
     */
    public int[] getPos(){
        return pos;
    }

    /**
     * Permet de récupérer les numéros des quêtes que le joueur a fait
     * @return ArrayList<Integer>
     */
    public ArrayList<Integer> getParcoursNum(){
        return parcoursNum;
    }

    /**
     * Permet de récupérer les quêtes que le joueur a fait
     * @return ArrayList<Quete>
     */
    public ArrayList<Quete> getParcoursQuete(){
        return parcoursQuete;
    }

    /**
     * Permet de récupérer l'expérience du joueur
     * @return int
     */
    public int getExperience(){
        return experience;
    }

    /**
     * Permet de modifier la position du joueur
     * @param newPos
     */
    public void setPos(int[] newPos){
        pos = newPos;
        arrayPos.add(newPos);
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
        arrayExperience.add(newExperience);
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

    /**
     * Renvoie une chaine de caractaire contenant les positins sur lesquelles le joueur est allé
     * 
     * @return String
     */
    public String getArrayPos(){
        String lesPos = "";
        for (int[] position : arrayPos){
            lesPos = lesPos + " (" + position[0] + ", " + position[1] + ")";
        }
        return lesPos;
    }
}
