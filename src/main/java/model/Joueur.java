package model;

import java.util.ArrayList;
import java.util.List;

public class Joueur {

    private List<Tuile> carteEnMain;
    private String name;
    private int index;

    public Joueur(String name, int index) {
        carteEnMain = new ArrayList<>();
        this.name = name;
        this.index = index;
    }

    public List<Tuile> getCarteEnMain() {
        return carteEnMain;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public void setCarteEnMain(List<Tuile> carteEnMain) {
        this.carteEnMain = carteEnMain;
    }

    public void choixTuile(Tuile tuile) {
        carteEnMain.add(tuile);
    }

    public void removeTuile(Tuile tuile) {
        carteEnMain.remove(tuile);
    }

}
