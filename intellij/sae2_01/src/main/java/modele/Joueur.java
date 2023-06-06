package modele;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Classe représentant le joueur et ses caractéristiques
 */
public class Joueur {
    private int dureeTotal;
    private int deplacement;
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
        deplacement = 0;
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

    public int getDeplacement(){
        return deplacement;
    }

    public void setDeplacement(int newDeplacement){
        deplacement += newDeplacement;
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
     * @param numQuete
     */
    public void ajoutQueteParcoursNum(int numQuete){
        parcoursNum.add(numQuete);
    }

    /**
     * Permet de modifier les quêtes que le joueur a fait
     * @param queteAAjouter
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

    public void removeExperience(int nbExp){
        experience -= nbExp;
    }

    public void removeDerniereQuete(){
        parcoursQuete.remove(parcoursQuete.size() - 1);
        parcoursNum.remove(parcoursNum.size() - 1);
    }

    /**
     * Renvoie une chaine de caractaire contenant les positins sur lesquelles le joueur est allé
     *
     * @return String
     */
    public ArrayList<int[]> getArrayPos(){
        return arrayPos;
    }

    public Joueur copy() {
        Joueur copy = new Joueur();
        copy.dureeTotal = this.dureeTotal;
        copy.parcoursNum = new ArrayList<>(this.parcoursNum);
        copy.parcoursQuete = new ArrayList<>(this.parcoursQuete);
        copy.arrayPos = new ArrayList<>(this.arrayPos);
        copy.arrayExperience = new ArrayList<>(this.arrayExperience);
        copy.experience = this.experience;
        copy.pos = Arrays.copyOf(this.pos, this.pos.length);
        copy.deplacement = this.deplacement;
        return copy;
    }

    public void parcourirQuete(Quete quete) {
        parcoursNum.add(quete.getNumero());
        parcoursQuete.add(quete);
    }

    public void annulerDerniereQuete() {
        if (!parcoursNum.isEmpty()) {
            parcoursNum.remove(parcoursNum.size() - 1);
            parcoursQuete.remove(parcoursQuete.size() - 1);
        }
    }

    public void removeDeplacement(int distanceJouerQuete){
        deplacement -= distanceJouerQuete;
    }

    public void removeDureeTotal(int dureeAEnlever) {
        dureeTotal -= dureeAEnlever;
    }
}
