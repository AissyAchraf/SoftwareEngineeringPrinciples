package generics;

import java.util.ArrayList;

public class MaPile<T> {

    private ArrayList<T> elements;

    public MaPile () {
        elements = new ArrayList<>();
    }

    public void empiler(T e) {
        elements.add(0, e);
    }

    public void depiler() {
        if(!elements.isEmpty()) {
            elements.remove(0);
        }
    }

    public boolean estVide() {
        return taille() == 0;
    }

    public int taille() {
        int n = 0;
        for (T e : elements) {
            n+=1;
        }
        return n;
    }

    public void vider() {
        elements = new ArrayList<>();
    }

    public ArrayList<T> getValues() {
        return elements;
    }
}
