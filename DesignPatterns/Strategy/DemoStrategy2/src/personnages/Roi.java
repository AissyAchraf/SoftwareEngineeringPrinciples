package personnages;

import strategies.ComportementArcEtFleches;
import strategies.ComportementPoignard;

public class Roi extends Personnage{

    public Roi() {
        this.comportementArme = new ComportementPoignard();
    }

    @Override
    public void combattre() {
        System.out.println("Je suis un roi ...");
        this.comportementArme.utiliserArme();
    }
}
