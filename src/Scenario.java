import java.util.ArrayList;

public class Scenario {
    ArrayList<Quete> listeQuetes;

    public String toString() {
        return listeQuetes.size() + " " + listeQuetes;
    }

    public void ajout(Quete parQuete) {
        listeQuetes.add(parQuete);
    }
}