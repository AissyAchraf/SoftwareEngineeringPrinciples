package DonnesMeteoPackage;

import java.util.Observable;

public class DonneesMeteo extends Observable {

    private float temperature;
    private float humidite;
    private float pression;

    public void actualiserMesures() {
        setChanged();
        notifyObservers();
    }
    public void setMesures(float temp, float hum, float press) {
        this.temperature = temp;
        this.humidite =  hum;
        this.pression = press;
        actualiserMesures();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidite() {
        return humidite;
    }

    public float getPression() {
        return pression;
    }
}
