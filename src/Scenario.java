import java.util.ArrayList;

public class Scenario {
    ArrayList<Quete> listeQuetes;

    public Scenario() {
        listeQuetes = new ArrayList<Quete>();
    }

    public String toString() {
        return listeQuetes.size() + " " + listeQuetes;
    }

    public void ajout(Quete parQuete) {
        listeQuetes.add(parQuete);
    }
}