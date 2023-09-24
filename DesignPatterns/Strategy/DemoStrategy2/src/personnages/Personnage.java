package personnages;

import strategies.ComportementArme;

public abstract class Personnage {

    protected String name;
    protected int score;
    protected ComportementArme comportementArme;

    public abstract void combattre();

    public void setArme(ComportementArme a) {
        this.comportementArme = a;
    }
}
