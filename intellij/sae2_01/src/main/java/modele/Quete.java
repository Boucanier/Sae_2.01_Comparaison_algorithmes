package modele;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Quete {
    private int numero;
    private int[] pos = new int[2];
    private int[] precond = new int[4];
    private int duree;
    private int experience;
    private String intitule;

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
    }


    private void stringToListPrecond(String precondition) {
    /*
        @Param :
            precondition (String) :
        @Returns :
            precond[int] : la liste qui va devenir le champ contenant les preconditions nécessaire
    */
        precondition = precondition.replace("(", "");
        precondition = precondition.replace(")", "");
        precondition = precondition.replace(" ", "");
        Scanner scanPrecondition = new Scanner(precondition).useDelimiter(",");
        int i = 0;
        while (scanPrecondition.hasNext()) {
            String extrait = scanPrecondition.next();
            if (!extrait.equals("")) {
                int entier = Integer.parseInt(extrait);
                precond[i] = entier;
            }
            i++;
        }
    }

    private void stringToListPos(String position) {
        position = position.replace("(", "");
        position = position.replace(")", "");
        position = position.replace(" ", "");
        Scanner scanPos = new Scanner(position).useDelimiter(",");
        int i = 0;
        while (scanPos.hasNext()) {
            String extrait = scanPos.next();
            int entier = Integer.parseInt(extrait);
            pos[i] = entier;
            i ++;
        }
    }

    public String toString() {
        return "num : " + numero + ", position : " + Arrays.toString(pos) + ", precond : " + Arrays.toString(precond) + ", durée : " + duree + ", experience : " + experience + ", intitule : " + intitule;
    }


    public int getNumero() {
        return numero;
    }


    public void setNumero(int numero) {
        this.numero = numero;
    }


    public int[] getPos() {
        return pos;
    }


    public void setPos(int[] pos) {
        this.pos = pos;
    }


    public int[] getPrecond() {
        return precond;
    }


    public void setPrecond(int[] precond) {
        this.precond = precond;
    }


    public int getDuree() {
        return duree;
    }


    public void setDuree(int duree) {
        this.duree = duree;
    }


    public int getExperience() {
        return experience;
    }


    public void setExperience(int experience) {
        this.experience = experience;
    }


    public String getIntitule() {
        return intitule;
    }


    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }
}