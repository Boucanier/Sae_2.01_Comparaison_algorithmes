package modele;

import java.util.ArrayList;
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

            String posTemp = scanner.next();
            // System.out.println(posTemp);

            String precondTemp = scanner.next();
            stringToListPrecond(precondTemp);
            // System.out.println(precond[0] + " " + precond[1] + " " + precond[2] + " " + precond[3]);

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
                precond[i] = Integer.parseInt(extrait);
            }
            i++;
        }
    }
}