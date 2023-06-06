package modele;

import java.net.PasswordAuthentication;
import java.text.BreakIterator;
import java.util.*;

import javafx.scene.paint.Stop;

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

    // ##################################################
    //partie sur le niv 2
    // ##################################################

    /**
     * Mettre a jour les info du joueur info de connaitre les caractéristiques d'un joueur et donc de savoir si une solution est mieux qu'une autre (les comparer)
     * 
     * @param joueur
     * @param uneListeDeQuetes
     */
    private void mettreInfoJoueur(Joueur joueur, ArrayList<Quete> uneListeDeQuetes){
        for (Quete uneQuete : uneListeDeQuetes){
            int[] poseQuete = uneQuete.getPos();
            int distanceJouerQuete = distanceEntrePos(joueur.getPos(), poseQuete);
            // mis a jour de la durée total
            joueur.setDureeTotal(distanceJouerQuete);
            //mis a jour du nombre de déplacement
            joueur.setDeplacement(distanceJouerQuete);
            joueur.setDureeTotal(uneQuete.getDuree());
            if (uneQuete.getNumero() != 0){
                joueur.setExperience(uneQuete.getExperience());
            }
            //mis a jour de la position
            joueur.setPos(uneQuete.getPos());
            joueur.ajoutQueteParcours(uneQuete);
        }
    }

    /**
     * Met a jour les caractéristiques essentielles d'une joueur en ajoutant la quete en parametre
     * 
     * @param joueur
     * @param parQuete
     */
    private void ajoutCaracteristiqueQueteToJoueur(Joueur joueur, Quete parQuete){
        if (parQuete.getNumero() != 0){
            joueur.setExperience(parQuete.getExperience());
        }
        joueur.setPos(parQuete.getPos());
        joueur.ajoutQueteParcours(parQuete);
        listeQuetesRestantes.remove(parQuete);
    }

    /**
     * Met a jour les caractéristique essentielles d'une joueur en supprimant sa derniere quete
     * 
     * @param joueur
     */
    private void retireCaracteristiqueQueteToJoueur(Joueur joueur){
        ArrayList<Quete> listeQueteRealisee = joueur.getParcoursQuete();
        Quete queteEnlevee = listeQueteRealisee.get(listeQueteRealisee.size() - 1);
        if (queteEnlevee.getNumero() != 0){
            joueur.removeExperience(queteEnlevee.getExperience());
        }
        joueur.removeDerniereQuete();
        joueur.setPos(queteEnlevee.getPos());
        listeQuetesRestantes.add(queteEnlevee);
    }

    /**
     * Trouve la quete en fonction du numéro de celle-ci en parametre
     * 
     * @param numQuete
     * @return Quete
     */
    private Quete trouverQueteParNumero(int numQuete){
        for (Quete quete : listeQuetes){
            if (quete.getNumero() == numQuete)
                return quete;
        }
        return null;
    }

    /**
     * Donne la liste de toutes les sources du scénario (les quetes qu'y n'ont pas de préconditions)
     *
     * @return ArrayList<Integer>
     */
    private ArrayList<Quete> trouverListeSource(){
        ArrayList<Quete> listeSource = new ArrayList<>();
        for (Quete quete : listeQuetes){
            if (quete.getPrecond()[0] == 0)
                listeSource.add(quete);
        }
        return listeSource;
    }

    private int indiceTrouverMeilleur(Joueur[] solutions, String objectEtudiee){
        int meilleurSolution = getChamp(solutions[0], objectEtudiee);
        int indiceMeilleurSolution = 0;
        for (int i = 1; i < solutions.length; i++){
            int champActuel = getChamp(solutions[i], objectEtudiee);
            if (champActuel < meilleurSolution){
                meilleurSolution = champActuel;
                indiceMeilleurSolution = i;
            }
        }
        return indiceMeilleurSolution;
    }


    private int indiceTrouverPire(Joueur[] solutions, String objectEtudiee){
        int pireSolution = getChamp(solutions[0], objectEtudiee);
        int indicePireSolution = 0;
        for (int i = 1; i < solutions.length; i++){
            int champActuel = getChamp(solutions[i], objectEtudiee);
            if (champActuel < pireSolution){
                pireSolution = champActuel;
                indicePireSolution = i;
            }
        }
        return indicePireSolution;
    }


    private void metSolutionDansListe(Joueur[] solutions, Joueur joueur, String objectEtudiee, String typeSolution, String meilleurPire){
        int longeurListe = solutions.length;
        Joueur joueur2 = joueur.copy();
        
        
        for (int i = 0; i < longeurListe; i++){
            if (solutions[i].getParcoursNum().size() == 0){
                solutions[i] = joueur2;
                return; //on sort de la méthode puisqu'on a insérer la valeur dans les solutions
            }
        }

        // si on est la c'est qu'il n'y a plus de place dans la liste
        // on cherche donc la valeur min ou max
        if (meilleurPire.equals("meilleur")){
            // on cherche donc la pire des solutions dans la liste des meilleurs
            int indicePireSolutionDansListe = indiceTrouverPire(solutions, objectEtudiee);
            if (getChamp(joueur2, objectEtudiee) < getChamp(solutions[indicePireSolutionDansListe], objectEtudiee)){
                solutions[indicePireSolutionDansListe] = joueur2;
            }
        }

        else if (meilleurPire.equals("pire")){
            // on cherche donc la meilleur des solutions dans la liste des pires
            int indiceMeilleurSolutionDansListe = indiceTrouverMeilleur(solutions, objectEtudiee);
            if (getChamp(joueur2, objectEtudiee) > getChamp(solutions[indiceMeilleurSolutionDansListe], objectEtudiee)){
                solutions[indiceMeilleurSolutionDansListe] = joueur2;
            }
        }
    }

    private boolean solutionIsEfficace(String typeSolution){
        return typeSolution.equals("efficace");
    }

    private boolean solutionIsExhaustif(String typeSolution){
        return typeSolution.equals("exhaustif");
    }


    /**
     * Trouve toutes les solutions d'un scénario de façon récursive
     * 
     * @param solutions
     * @param numQuete
     * @param joueur
     */
    private void trouveSolutionsRecursivement(Joueur[] solutions, int numQuete, Joueur joueur, String objectEtudiee, String typeSolution, String meilleurPire){
        ajoutCaracteristiqueQueteToJoueur(joueur, trouverQueteParNumero(numQuete));
        
        if (numQuete == 0){
            if (joueur.getExperience() >= trouverQueteParNumero(0).getExperience()){
                // on ajoute la solution trouvée
                Joueur joueurBis = new Joueur();
                mettreInfoJoueur(joueurBis, joueur.getParcoursQuete());
                metSolutionDansListe(solutions, joueurBis, objectEtudiee, typeSolution, meilleurPire);
            }
        }

        else{
            ArrayList<Integer> listeQueteProche = trouverQueteProche(joueur);
            if ( solutionIsEfficace(typeSolution)){
                if (listeQueteProche.contains(0) && (joueur.getExperience() >= trouverQueteParNumero(0).getExperience())){
                    trouveSolutionsRecursivement(solutions, 0, joueur, objectEtudiee, typeSolution, meilleurPire);
                    retireCaracteristiqueQueteToJoueur(joueur);
                }
                else {
                    for (int numQueteBis : listeQueteProche){
                        if (numQueteBis != 0){
                            trouveSolutionsRecursivement(solutions, numQueteBis, joueur, objectEtudiee, typeSolution, meilleurPire);
                            retireCaracteristiqueQueteToJoueur(joueur);
                        }
                    }
                }
            }
            else if (solutionIsExhaustif(typeSolution)){
                if (listeQuetesRestantes.size() == 1){
                    trouveSolutionsRecursivement(solutions, 0, joueur, objectEtudiee, typeSolution, meilleurPire);
                    retireCaracteristiqueQueteToJoueur(joueur);
                }
                else {
                    for (int numQueteBis : listeQueteProche){
                        if (numQueteBis != 0){
                            trouveSolutionsRecursivement(solutions, numQueteBis, joueur, objectEtudiee, typeSolution, meilleurPire);
                            retireCaracteristiqueQueteToJoueur(joueur);
                        }
                    }
                }
            }
        }
    }

    /**
     * Pour toutes les sources on va chercher les solutions que l'on ajoute dans la liste de liste finale que l'on renvoie
     * 
     * @return ArrayList<ArrayList<Quete>>
     */
    public void trouverSolutions(Joueur[] solutionsReellees, int nbSolutions, String objectEtudiee, String typeSolution, String meilleurPire){
        //on cherche toutes les sources possibles
        ArrayList<Quete> sources = trouverListeSource();

        Joueur joueur = new Joueur();
        for (Quete nSource : sources){
            trouveSolutionsRecursivement(solutionsReellees, nSource.getNumero(), joueur, objectEtudiee, typeSolution, meilleurPire);
            retireCaracteristiqueQueteToJoueur(joueur);
        }
    }

    /**
     * permet de récupérer le champ d'un joueur
     * 
     * @param quete
     * @param fieldName
     * @return int
     */
    private static int getChamp(Joueur joueur, String nomDuCHamp) {
        if (nomDuCHamp.equals("deplacement")) {
            // on retourne le nombre de déplacement du joueur (distance cumulé entre chaque quetes)
            return joueur.getDeplacement();
        }
        else if (nomDuCHamp.equals("dureeTotal")){
            // on prend la taille du nombre de quetes parcourues
            return joueur.getDureeTotal();
        }
        else if (nomDuCHamp.equals("parcoursNum")){
            // on prend la taille du nombre de quetes parcourues
            return joueur.getParcoursNum().size();
        }
        else if (nomDuCHamp.equals("experience")){
            // on prend le nombre total d'experience
            return joueur.getExperience();
        }

        throw new IllegalArgumentException("Nom du champ invalide !!");
    }

    /**
     * Trie une liste de joueur en fonction de ses champs (experience, nombre de quetes réalisées, )
     * 
     * @param listeQuetes
     * @param fieldName
     */
    public static void trierLesJoueurs(ArrayList<Joueur> listeJoueurs, final String nomDuChamp, String meilleurPire) {
        Collections.sort(listeJoueurs, new Comparator<Joueur>() {
            @Override
            public int compare(Joueur joueur1, Joueur joueur2) {
                Object fieldValue1 = getChamp(joueur1, nomDuChamp);
                Object fieldValue2 = getChamp(joueur2, nomDuChamp);
                if (fieldValue1 instanceof Comparable && fieldValue2 instanceof Comparable) {
                    // Utilise la méthode compareTo pour comparer les valeurs
                    return ((Comparable) fieldValue1).compareTo(fieldValue2);
                } else {
                    // Les champs ne sont pas comparables, renvoie 0 pour conserver l'ordre d'origine
                    return 0;
                }
            }
        });
        if (meilleurPire.equals("pire")){
            Collections.reverse(listeJoueurs);
        }
    }

    private ArrayList<Joueur> redimentionnerListeSolution(Joueur[] listeDeJoueurs){
        ArrayList<Joueur> newListe = new ArrayList<>();
        for (int i = 0; i < listeDeJoueurs.length; i++){
            if (listeDeJoueurs[i].getParcoursNum().size() == 0)
                break;
            Joueur joueur = listeDeJoueurs[i];
            newListe.add(joueur);
        }
        return newListe;
    }

    /**
     * Renvoie une array list de joueur répondant au type de solution demandée, on peut donc travaillé avec afin de connaitre toutes les caractéristiques du joueur
     * 
     * @return ArrayList<ArrayList<Quete>>
     */
    public ArrayList<Joueur> niveau2(int nbSolutions, String typeSolution, String objectEtudiee, String meilleurPire){
        // toutes les solutions
        Joueur[] solutions = new Joueur[nbSolutions];
        for (int i = 0; i < solutions.length; i++){
            solutions[i] = new Joueur();
        }
        
        trouverSolutions(solutions, nbSolutions, objectEtudiee, typeSolution, meilleurPire);

        ArrayList<Joueur> listeJoueur = redimentionnerListeSolution(solutions);

        trierLesJoueurs(listeJoueur, objectEtudiee, meilleurPire);
        

        // la solution demandée
        //ArrayList<Joueur> solutionTrier = trierSolutionEnfonctionDe(solutions, nbSolutions, objectifEtudiee, meilleurPire);

        // prendre les solution efficace ou exhaustive uniquement (voir tout si on veut)
        //ArrayList<Joueur> solutionDemandeeFinale = prendreSolutionEfficaceExhaustive(solutions, typeSolution);

        //return solutionDemandeeFinale;
        return listeJoueur;
    }
}
