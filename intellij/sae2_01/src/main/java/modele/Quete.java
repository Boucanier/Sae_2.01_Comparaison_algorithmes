package modele;

import java.util.Scanner;
public class Quete {
    int chNumero;
    int[] pos = new int[2];
    int[] precond = new int[4];
    int duree;
    int experience;
    String intitule;

    public Quete(String ligne) {
        Scanner scanner = new Scanner(ligne).useDelimiter("\\|");
        while (scanner.hasNext()) {
            this.chNumero = scanner.nextInt();

        }
    }
}