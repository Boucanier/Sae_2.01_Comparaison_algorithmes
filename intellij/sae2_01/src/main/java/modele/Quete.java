package modele;

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
            String precondTemp = scanner.next();
            this.duree = scanner.nextInt();
            this.experience = scanner.nextInt();
            this.intitule = scanner.next();
        }
    }
}