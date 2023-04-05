package modele;

import java.util.ArrayList;
import java.util.Scanner;
public class Quete {
    int numero;
    int[] pos = new int[2];
    int[] precond = new int[4];
    int duree;
    int experience;
    String intitule;

    public Quete(String ligne) {
        Scanner scanner = new Scanner(ligne).useDelimiter("\\|");
        while (scanner.hasNext()) {
            this.numero = scanner.nextInt();
            String posTemp = scanner.next();

            // on prend la valeur suivante dans une string
            String precondTemp = scanner.next();
            // puis on convertie celle-ci en liste [X,X,X,X] avec X = int
            precond = stringToListPrecond(precondTemp);
            this.duree = scanner.nextInt();
            this.experience = scanner.nextInt();
            this.intitule = scanner.next();
        }
    }

    private static int[] stringToListPrecond(String precondition) {
        /*
        @Param :
            precondition (String) :
        @Returns :
            precond[int] : la liste qui va devenir le champ contenant les preconditions nécessaire
         */
        int [] precond = new int[4];
        precondition.replace("(", "");
        precondition.replace(")", "");
        precondition.replace(" ", "");
        Scanner scanPrecondition = new Scanner(precondition).useDelimiter(",");
        int i = 0;
        while (scanPrecondition.hasNext()) {
            String extrait = scanPrecondition.next();
            if (!extrait.equals("")) {
                precond[i] = Integer.parseInt(extrait);
                i++;
            }
        }
        return precond;
    }
}