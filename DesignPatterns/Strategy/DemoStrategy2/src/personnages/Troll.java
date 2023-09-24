package personnages;

import strategies.ComportementHache;

public class Troll extends Personnage {

    public Troll() {
        this.comportementArme = new ComportementHache();
    }

    @Override
    public void combattre() {
        System.out.println("Je suis un troll ...");
        this.comportementArme.utiliserArme();
    }
}
