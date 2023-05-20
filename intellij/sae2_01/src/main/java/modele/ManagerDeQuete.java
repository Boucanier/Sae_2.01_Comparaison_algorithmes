package modele;

import java.util.ArrayList;

public class ManagerDeQuete {
    ArrayList<Quete> listeQuetesRestantes;

    public ManagerDeQuete(){
        /*
        Constructeur de la classe ManagerDeQuete
         */
    }


    public ManagerDeQuete(Scenario parScenario){
        /*
        Constructeur de la classe ManagerDeQuete
         */
        listeQuetesRestantes = parScenario.getListeQuetes();
    }


    private int trouverIndiceListeQuete(ArrayList<modele.Quete> liste, int numQuete) {
        /*
         * Retourne l'indice de la quête dans la liste possédant le numéro de quête donné en paramètre
         */
        for (int i = 0; i < liste.size(); i++) {
            modele.Quete quete = liste.get(i);
            if (quete.getNumero() == numQuete) {
                return i;
            }
        }
    
        System.out.println("Quête non trouvée dans la liste des quêtes !");
        return -1;
    }
    


    public ArrayList trouverQueteProche(Joueur joueur){
        /*
        renvoie une liste d'entier contenant les numéro des quetes les plus proches possibles pour le joueur

        Params:
            joueur : venant de la classe Joueur
            listeQuetesRestantes : liste des quetes avec leurs caractéristiques
         */
        ArrayList<Integer> listeQueteProche = new ArrayList<>();
        int distanceMin = 10000000; // TROUVER SOLUTIONS POUR RENDRE CA MIEUX !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        for (int i = 0; i < listeQuetesRestantes.size(); i++){

            // on regarde si la quete peut etre faite par rapport au quetes deja réalisé par le joueur
            if ( peutCommencerQuete(joueur.getParcours(), listeQuetesRestantes.get(i).getPrecond()) ){

                // on regarde si la quete est plus proche, plus loin ou si elle est a meme distance
                if ( distanceEntrePos(Joueur.getPos(), listeQuetesRestantes.get(i).getPos()) < distanceMin){
                    listeQueteProche.clear();
                    distanceMin = distanceEntrePos(Joueur.getPos(), listeQuetesRestantes.get(i).getPos());
                    listeQueteProche.add(listeQuetesRestantes.get(i).getNumero());
                }

                else if (distanceEntrePos(Joueur.getPos(), listeQuetesRestantes.get(i).getPos()) == distanceMin){
                    listeQueteProche.add(listeQuetesRestantes.get(i).getNumero());
                }
            }
        }
        return listeQueteProche;
    }


    protected int distanceEntrePos(int[] startPos, int[] endPos){
        /*
        renvoie le nombre de déplacement nécessaire à la réalisation du déplacement d'un joueur d'une position 1 à une position 2

        Params:
        parPos1 : position de la quête 1
        parPos2 : position de la quête 2
         */
        int x = Math.abs(startPos[0] - endPos[0]);
        int y = Math.abs(startPos[1] - endPos[1]);

        return x+y;
    }


    protected boolean peutCommencerQuete(ArrayList<Integer> parcoursDuJoueur, int[] parPrecond){
        /*
        renvoie true si le joueur à les préconditinos pour commencer une certaine quête, false sinon

        Params:
            parcoursDuJoueur : le parcours que le joueur a réalisé
            parPrecond : les préconditions nécessaires pour réaliser la quête
         */
        int peutCommencer = 0;
        
        int precond0 = parPrecond[0];
        int precond1 = parPrecond[1];
        int precond2 = parPrecond[2];
        int precond3 = parPrecond[3];

        if (precond0 == 0){
            return true;
        }

        // on regarde le deuxieme (OU)
        if (precond3 != 0){
            // si deuxieme contition du deuxieme (OU) n'est pas un 0
            if (precond2 != 0){
                if ( parcoursDuJoueur.contains(precond2) || parcoursDuJoueur.contains(precond3) ){
                    peutCommencer ++;
                }
            }
            else{
                peutCommencer ++;
            }
        }
        else{
            if (precond2 != 0){
                // si deuxieme contition du premier (OU) est un 0
                if ( parcoursDuJoueur.contains(precond2) ){
                    peutCommencer ++;
                }
            }
            else
                peutCommencer ++;
        } 

        // on regarde le premier (OU)
        if (precond1 != 0){
            // si deuxieme contition du premier (OU) n'est pas un 0
            if ( parcoursDuJoueur.contains(precond0) || parcoursDuJoueur.contains(precond1) ){
                peutCommencer ++;
            }
        }
        else {
            // si deuxieme condition du premier (OU) est un 0
            if ( parcoursDuJoueur.contains(precond0) ){
                peutCommencer ++;
            }
        }

        if (peutCommencer == 2){
            //si toutes les préconditions sont validées alors on return true
            return true;
        }
        else{
            // false sinon
            return false;
        }
    }


    public void gloutonSimple(Joueur joueur){
        /*
         * exécute la solution gloutonne
         */
        while (! joueur.getParcours().contains(0)){
            // on cherche la liste des quetes les plus proches realisables pour le joueur
            ArrayList queteProche = trouverQueteProche(joueur);
            
            // si dans les quetes les plus proches il y a la quete finale, alors on l'a choisie, sinon on prend la premiere possible
            int queteChoisie;
            if (queteProche.contains(0)){
                queteChoisie = 0;
            }
            else{
                queteChoisie = (int)queteProche.get(0);
            }
            
            // on rajoute la quete choisie dans la liste des quetes parcourues
            joueur.ajoutQueteParcours(queteChoisie);
            System.out.println("Le joueur choisi d'aller à la quête " + queteChoisie);

            Quete queteDansListe = listeQuetesRestantes.get(trouverIndiceListeQuete(listeQuetesRestantes, queteChoisie));

            // on met a jour la durée totale
            joueur.setDureeTotal(queteDansListe.getDuree());
            joueur.setDureeTotal(distanceEntrePos( joueur.getPos(), queteDansListe.getPos()) );
            System.out.println("Le joueur augmente sa durée totale de : " + joueur.getDureeTotal());

            // on met a jour la position du joueur sur la quête sur laquelle il est allé
            joueur.setPos(queteDansListe.getPos());
            System.out.println("Le joueur se rend donc en position " + "(" + queteDansListe.getPos()[0] + ", " +  queteDansListe.getPos()[1] + ")");

            // on met a jour son expérience
            joueur.setExperience(queteDansListe.getExperience());
            System.out.println("Le joueur gagne " + queteDansListe.getExperience());

            // on retire la quete choisie des quetes restantes
            listeQuetesRestantes.remove(queteDansListe);

            // on montre le parcours du joueur en cours
            System.out.println(joueur.getParcours());

            //saut de ligne terminal
            System.out.println();
        }
    }


    public ArrayList niveau1(String choixSolution){
        /*
        correspond à la réalisation du premier niveau en fonction de choixSolution

        Params:
            choixSolution : chaine de caractaire équivalant soit à "efficace" soit à "exhaustive"
         */
        Joueur joueur = new Joueur();
        if (choixSolution == "gloutone"){
            System.out.println("Choix de solution : gloutonne");
            gloutonSimple(joueur);
            return joueur.getParcours();
        }

        else if (choixSolution == "exhaustive"){
            System.out.println("Choix de solution : exhaustif utilisant la tactique gloutonne");
        }
        return new ArrayList<>();
    }
}
