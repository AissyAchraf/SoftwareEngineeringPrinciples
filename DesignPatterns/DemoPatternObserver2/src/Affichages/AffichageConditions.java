package Affichages;

import java.util.Observable;
import java.util.Observer;
import DonnesMeteoPackage.DonneesMeteo;

public class AffichageConditions implements Observer, Affichage {

    Observable observable;
    private float temperature;
    private float humidite;

    public AffichageConditions(Observable observable) {
        this.observable =  observable;
        observable.addObserver(this);
    }

    @Override
    public void afficher() {
        System.out.println("Conditions actuelles : "+temperature+" °C et "+humidite+" % humidité");
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof DonneesMeteo) {
            DonneesMeteo donneesMeteo = (DonneesMeteo) o;
            this.temperature = donneesMeteo.getTemperature();
            this.humidite = donneesMeteo.getHumidite();
            afficher();
        }
    }
}
