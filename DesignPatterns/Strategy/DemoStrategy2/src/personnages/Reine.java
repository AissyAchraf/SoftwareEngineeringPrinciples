package personnages;

import strategies.ComportementArcEtFleches;

public class Reine extends Personnage {

    public Reine() {
        this.comportementArme = new ComportementArcEtFleches();
    }

    @Override
    public void combattre() {
        System.out.println("Je suis une reine ...");
        this.comportementArme.utiliserArme();
    }
}
