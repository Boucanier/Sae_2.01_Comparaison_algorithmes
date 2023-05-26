package modele;

import java.util.ArrayList;

/**
 * Classe permettant de gérer les quêtes
 */
public class ManagerDeQuete {
    private ArrayList<Quete> listeQuetesRestantes; // une liste qui va changer au fur et a mesure
    private ArrayList<Quete> listeQuetes; // une liste qui nous permet de se souvenir des anciennes quêtes réalisées si celles-ci ont été complétées
    final boolean affichageTerminal = false;

    /**
     * Constructeur de la classe ManagerDeQuete
     * Ne prend pas de paramètre
     */
    public ManagerDeQuete(){
    }

    /**
     * Constructeur de la classe ManagerDeQuete
     * Prend en paramètre un scénario
     * @param parScenario
     */
    public ManagerDeQuete(Scenario parScenario){
        listeQuetes = parScenario.getListeQuetes();
        this.listeQuetes = new ArrayList<>();
        this.listeQuetesRestantes = new ArrayList<>();
        this.listeQuetes.addAll(listeQuetes);
        this.listeQuetesRestantes.addAll(listeQuetes);
    }


    /**
     * Retourne l'indice de la quête dans la liste possédant le numéro de quête donné en paramètre
     * @param liste
     * @param numQuete
     * @return int
     */
    private int trouverIndiceListeQuete(ArrayList<Quete> liste, int numQuete) {
        for (int i = 0; i < liste.size(); i++) {
            modele.Quete quete = liste.get(i);
            if (quete.getNumero() == numQuete) {
                return i;
            }
        }

        System.out.println("Quête non trouvée dans la liste des quêtes !");
        return -1;
    }
    
    /**
     * Renvoie une liste d'entier contenant les numéro des quetes les plus proches possibles pour le joueur
     * @param joueur
     * @return ArrayList<Integer>
     */
    public ArrayList<Integer> trouverQueteProche(Joueur joueur){
        ArrayList<Integer> listeQueteProche = new ArrayList<>();
        int distanceMin = 10000000; // TROUVER SOLUTIONS POUR RENDRE CA MIEUX !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        for (int i = 0; i < listeQuetesRestantes.size(); i++){

            // on regarde si la quete peut etre faite par rapport au quetes deja réalisé par le joueur
            if ( peutCommencerQuete(joueur.getParcoursNum(), listeQuetesRestantes.get(i).getPrecond()) ){

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


    /**
     * Renvoie le nombre de déplacement nécessaire à la réalisation du déplacement d'un joueur d'une position 1 à une position 2
     * @param startPos : position de départ
     * @param endPos : position d'arrivée
     * @return int
     */
    protected int distanceEntrePos(int[] startPos, int[] endPos){
        int x = Math.abs(startPos[0] - endPos[0]);
        int y = Math.abs(startPos[1] - endPos[1]);

        return x+y;
    }


    /**
     * Renvoie true si le joueur à les préconditions pour commencer une certaine quête, false sinon
     * @param parcoursDuJoueur
     * @param parPrecond
     * @return boolean
     */
    protected boolean peutCommencerQuete(ArrayList<Integer> parcoursDuJoueur, int[] parPrecond){
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


    /**
     * Renvoie le numéro de la quete la plus proche en fonction de si l'on sohaite une solution efficace ou exhausistive
     * @param queteProche
     * @param typeSolution
     * @return int
     */
    private int choisirQueteDansQuetesProches(ArrayList<Integer> queteProche, String typeSolution){
        int queteChoisie;
        if (typeSolution == "efficace"){
            // si c'est une solution efficace alors :
            if (queteProche.contains(0)){
                queteChoisie = 0;
            }
            else{
                queteChoisie = queteProche.get(0);
            }
        } 
        else if (typeSolution == "exhaustive"){
            // si c'est une solution exhaustive alors :
            if (listeQuetesRestantes.size() == 1){
                queteChoisie = queteProche.get(0);
                listeQuetesRestantes.add(listeQuetes.get(trouverIndiceListeQuete(listeQuetes, 0)));
            }
            else
                queteChoisie = queteProche.get(0);
        }
        else
            queteChoisie = 10000;

        return queteChoisie;
    }


    /**
     * Effectue la solution efficace ou exhaustive en fonction du type de solution donné en paramètre
     * @param joueur
     * @param solution
     */
    public void efficaceOuExhaustif(Joueur joueur, String solution){
        while (! joueur.getParcoursNum().contains(0)){
            // on cherche la liste des quetes les plus proches realisables pour le joueur
            ArrayList<Integer> queteProche = trouverQueteProche(joueur);
            
            int queteChoisie = choisirQueteDansQuetesProches(queteProche, solution); // on a le num de la quete
            Quete queteDansListe = listeQuetesRestantes.get(trouverIndiceListeQuete(listeQuetesRestantes, queteChoisie)); // on a la quete
            
            // on rajoute la quete choisie dans la liste des quetes parcourues
            joueur.ajoutQueteParcours(queteDansListe);
            if (affichageTerminal)
                System.out.println("Le joueur choisi d'aller à la quête " + queteChoisie);



            // on met a jour la durée totale
            joueur.setDureeTotal(queteDansListe.getDuree());
            joueur.setDureeTotal(distanceEntrePos( joueur.getPos(), queteDansListe.getPos()) );
            if (affichageTerminal)
                System.out.println("Le joueur augmente sa durée totale de : " + joueur.getDureeTotal());

            // on met a jour la position du joueur sur la quête sur laquelle il est allé
            joueur.setPos(queteDansListe.getPos());
            if (affichageTerminal)
                System.out.println("Le joueur se rend donc en position " + "(" + queteDansListe.getPos()[0] + ", " +  queteDansListe.getPos()[1] + ")");

            // on met a jour son expérience
            joueur.setExperience(queteDansListe.getExperience());
            if (affichageTerminal)
                System.out.println("Le joueur gagne " + queteDansListe.getExperience());

            // on retire la quete choisie des quetes restantes
            listeQuetesRestantes.remove(queteDansListe);

            // on montre le parcours du joueur en cours
            if (affichageTerminal)
                System.out.println(joueur.getParcoursNum());

            //saut de ligne terminal
            if (affichageTerminal)    
                System.out.println();
        }
    }

    /**
     * Renvoie le joueur avec la solution efficace ou exhaustive en fonction du type de solution donné en paramètre
     * @param choixSolution
     * @return Joueur
     */
    public Joueur niveau1(String choixSolution){
        Joueur joueur = new Joueur();

        if (choixSolution == "exhaustive"){
            listeQuetesRestantes.remove(trouverIndiceListeQuete(listeQuetesRestantes, 0));
        }

        efficaceOuExhaustif(joueur, choixSolution);
        return joueur;
    }
}
