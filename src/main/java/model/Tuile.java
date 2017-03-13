package model;

public class Tuile {

    private String nom;
    private String visu;
    private int index;
    private int point;
    private int[] cote;

    public static final int PORTE = 1;
    public static final int FENETRE = 2;
    public static final int RIEN = 3;
    public static final int DOUBLE_PORTE = 4;
    public static final int JARDIN = 5;

    public Tuile(String nom, String visu, int index, int[] cote, int point) {
        this.nom = nom;
        this.visu = visu;
        this.index = index;
        this.point = point;
        this.cote = new int[4];
        for (int i = 0; i < this.cote.length; i++) {
            this.cote[i] = cote[i];
        }
    }

    public String getVisu() {
        return visu;
    }

    public String getNom() {
        return nom;
    }

    public int getIndex() {
        return index;
    }

    public int getPoint() {
        return point;
    }

    public int[] getCote() {
        return cote;
    }

}