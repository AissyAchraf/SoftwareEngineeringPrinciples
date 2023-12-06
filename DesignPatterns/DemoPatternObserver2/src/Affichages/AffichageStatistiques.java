package Affichages;

import java.util.Observable;
import java.util.Observer;
import DonnesMeteoPackage.DonneesMeteo;

public class AffichageStatistiques implements Observer, Affichage {

    float temperature;
    float moy;
    float min;
    float max;
    Observable observable;

    public AffichageStatistiques(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }
    @Override
    public void afficher() {
        System.out.println("Statistiques Temperature (Max/Moy/Min) : "+ max+"/"+moy+"/"+min);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof DonneesMeteo) {
            DonneesMeteo donneesMeteo = (DonneesMeteo) o;
            float newTemperature = donneesMeteo.getTemperature();
            this.moy = (temperature + newTemperature)/2;
            this.max = (temperature > newTemperature) ? temperature : newTemperature;
            this.min = (temperature < newTemperature) ? temperature : newTemperature;
            this.temperature = newTemperature;
            afficher();
        }
    }
}
