import personnages.Personnage;
import personnages.Reine;
import personnages.Roi;
import personnages.Troll;
import strategies.ComportementArcEtFleches;
import strategies.ComportementHache;
import strategies.ComportementPoignard;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Personnage newReine = new Reine();
        Personnage newRoi = new Roi();
        Personnage newTroll = new Troll();

        newReine.combattre();
        newRoi.combattre();
        newTroll.combattre();

        System.out.println("-------- Changement des armes ---------");
        newReine.setArme(new ComportementHache());
        newReine.combattre();

        newRoi.setArme(new ComportementArcEtFleches());
        newRoi.combattre();

        newTroll.setArme(new ComportementPoignard());
        newTroll.combattre();
    }
}