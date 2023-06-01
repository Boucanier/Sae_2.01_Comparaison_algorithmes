package modele;

import java.util.*;

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
        ArrayList<Quete> listeQuetesRecup = parScenario.getListeQuetes();
        this.listeQuetes = new ArrayList<>();
        this.listeQuetesRestantes = new ArrayList<>();
        this.listeQuetes.addAll(listeQuetesRecup);
        this.listeQuetesRestantes.addAll(listeQuetesRecup);
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
        TreeMap<Integer, Integer> dicoQueteProhe = new TreeMap<>(); // clé : une quete atteignable, valeur distance de la pos du joueur a la quete
        ArrayList<Integer> listeQueteProche = new ArrayList<>(); //liste des num des quetes les plus proches possibles

        //boucle qui enregistre toutes les quetes possibles dans le dico avec les distances réspectives par quetes
        for (int i = 0; i < listeQuetesRestantes.size(); i++){

            if ( peutCommencerQuete(joueur.getParcoursNum(), listeQuetesRestantes.get(i).getPrecond()) ){
                int distance = distanceEntrePos(joueur.getPos(), listeQuetesRestantes.get(i).getPos());
                // si la quetes est possible
                dicoQueteProhe.put(listeQuetesRestantes.get(i).getNumero(), distance);
            }
        }

        // récupérer les entrées du TreeMap
        Set<Map.Entry<Integer, Integer>> entries = dicoQueteProhe.entrySet();

        // tri personnalisé basé sur les valeurs associées aux clés
        Comparator<Map.Entry<Integer, Integer>> comparator = Map.Entry.comparingByValue();

        // convertir les entrées en liste et trier
        List<Map.Entry<Integer, Integer>> sortedEntries = new ArrayList<>(entries);
        Collections.sort(sortedEntries, comparator);

        // ajouter les clés triées dans la liste
        for (Map.Entry<Integer, Integer> entry : sortedEntries) {
            listeQueteProche.add(entry.getKey());
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
    protected boolean peutCommencerQuete(List<Integer> parcoursDuJoueur, int[] parPrecond){
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
     * Renvoie le numéro de la quete la plus proche en fonction de si l'on souhaite une solution efficace ou exhausistive
     * @param queteProche
     * @param typeSolution
     * @return int
     */
    private int choisirQueteDansQuetesProches(Joueur joueur, ArrayList<Integer> queteProche, String typeSolution){
        int queteChoisie;
        if (typeSolution == "efficace"){
            // si c'est une solution efficace alors :
            if (queteProche.contains(0)){
                Quete quete0 = listeQuetes.get(trouverIndiceListeQuete(listeQuetes, 0));
                if (joueur.getExperience() >= quete0.getExperience())
                    queteChoisie = 0;
                else{
                    int indiceQuete0 = queteProche.indexOf(0);
                    if (indiceQuete0 == 0)
                        queteChoisie = queteProche.get(1);
                    else
                        queteChoisie = queteProche.get(0);
                }
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
            
            int queteChoisie = choisirQueteDansQuetesProches(joueur, queteProche, solution); // on a le num de la quete
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
            

            if (queteDansListe.getNumero() != 0)
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
