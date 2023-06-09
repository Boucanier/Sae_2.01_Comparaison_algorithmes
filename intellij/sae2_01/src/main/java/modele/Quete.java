package modele;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Classe représentant une quête et ses caractéristiques
 */
public class Quete {
    private int numero;
    private int[] pos = new int[2];
    private int[] precond = new int[4];
    private int duree;
    private int experience;
    private String intitule;

    /**
     * Constructeur de la classe Quete
     * @param ligne
     */
    public Quete(String ligne) {
        Scanner scanner = new Scanner(ligne).useDelimiter("\\|");
        while (scanner.hasNext()) {
            this.numero = scanner.nextInt();
            stringToListPos(scanner.next()); // transformation de string en tableau
            stringToListPrecond(scanner.next()); // idem
            this.duree = scanner.nextInt();
            this.experience = scanner.nextInt();
            this.intitule = scanner.next();
        }
        scanner.close();
    }

    /**
     * Constructeur de la classe Quete avec tous les champs en paramètre
     * @param numero
     * @param pos
     * @param precond
     * @param duree
     * @param experience
     * @param intitule
     */
    public Quete(int numero, int[] pos, int[] precond, int duree, int experience, String intitule) {
        this.numero = numero;
        this.pos = pos;
        this.precond = precond;
        this.duree = duree;
        this.experience = experience;
        this.intitule = intitule;
    }

    /**
     * Renvoie les préconditions de la quête sous forme de chaîne de caractères
     * @return String
     */
    public String getPrecondStr() {
        if (precond == null) {
            return null;
        }
        return "(("+precond[0]+", "+precond[1]+"), ("+precond[2]+", "+precond[3]+"))";
    }

    /**
     * Renvoie la position de la quête sous forme de chaîne de caractères
     * @return String
     */
    public String getPosStr() {
        if (pos == null) {
            return null;
        }
        return pos[0]+", "+pos[1];
    }

    /**
     * Renvoie une chaîne de caractères représentant la quête
     * @return String
     */
    public String toString() {
        return "num : " + numero + ", position : " + Arrays.toString(pos) + ", precond : " + Arrays.toString(precond) + ", durée : " + duree + ", experience : " + experience + ", intitule : " + intitule;
    }

    /**
     * Retourne le numéro de la quête
     * @return int
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Permet de modifier le numéro de la quête
     * @param numero
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Retourne la position de la quête
     * @return int[]
     */
    public int[] getPos() {
        return pos;
    }

    /**
     * Permet de modifier la position de la quête
     * @param pos
     */
    public void setPos(int[] pos) {
        this.pos = pos;
    }

    /**
     * Retourne les préconditions de la quête
     * @return int[]
     */
    public int[] getPrecond() {
        return precond;
    }

    /**
     * Permet de modifier les préconditions de la quête
     * @param precond
     */
    public void setPrecond(int[] precond) {
        this.precond = precond;
    }

    /**
     * Retourne la durée de la quête
     * @return int
     */
    public int getDuree() {
        return duree;
    }

    /**
     * Permet de modifier la durée de la quête
     * @param duree
     */
    public void setDuree(int duree) {
        this.duree = duree;
    }

    /**
     * Retourne l'expérience de la quête
     * @return int
     */
    public int getExperience() {
        return experience;
    }

    /**
     * Permet de modifier l'expérience de la quête
     * @param experience
     */
    public void setExperience(int experience) {
        this.experience = experience;
    }

    /**
     * Retourne l'intitulé de la quête
     * @return String
     */
    public String getIntitule() {
        return intitule;
    }

    /**
     * Permet de modifier l'intitulé de la quête
     * @param intitule
     */
    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }


    /**
     * Transforme un string en préconditions (tableau de 4 entiers)
     * @param precondition
     */
    private void stringToListPrecond(String precondition) {
        precondition = precondition.replace("(", "");
        precondition = precondition.replace(")", "");
        precondition = precondition.replace(" ", "");
        try (Scanner scanPrecondition = new Scanner(precondition).useDelimiter(",")) {
            int i = 0;
            while (scanPrecondition.hasNext()) {
                String extrait = scanPrecondition.next();
                if (!extrait.equals("")) {
                    int entier = Integer.parseInt(extrait);
                    precond[i] = entier;
                }
                i++;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }


    /**
     * Transforme un string en position (tableau de 2 entiers)
     * @param position
     */
    private void stringToListPos(String position) {
        position = position.replace("(", "");
        position = position.replace(")", "");
        position = position.replace(" ", "");
        try (Scanner scanPos = new Scanner(position).useDelimiter(",")) {
            int i = 0;
            while (scanPos.hasNext()) {
                String extrait = scanPos.next();
                int entier = Integer.parseInt(extrait);
                pos[i] = entier;
                i ++;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}