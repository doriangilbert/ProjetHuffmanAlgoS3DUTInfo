import java.util.ArrayList;

public class Arbre {

    private int freq;
    private char lettre;
    private Arbre filsG;
    private Arbre filsD;

    public Arbre(int freq, char lettre) {
        feuille = true;
        vide = false;

        this.freq = freq;
        this.lettre = lettre;
        filsG = new Arbre();
        filsD = new Arbre();

    }

    public Arbre(int freq, char lettre, Arbre fg, Arbre fd) {

        this.freq = freq;
        this.lettre = lettre;
        this.filsG = fg;
        this.filsD = fd;
        if (filsDroit().vide() && this.filsGauche().vide())
            feuille = true;

    }

    public int freq() {
        return this.freq;
    }

    public int freq() {
        return this.freq;
    }

    public boolean vide() {
        if(this.info == null)
            return true;
        else
            return false;
    }

    public Arbre filsGauche() {

        return filsG;
    }

    public Arbre filsDroit() {

        return filsD;
    }

    public void afficher() {
        // affiche d'abord info, fils gauche puis fils droit
        if (!vide()) {
            System.out.println(this.info);

            if (!filsGauche().vide())
                filsGauche().afficher();
            if (!filsDroit().vide())
                filsDroit().afficher();

        }

    }

    public void afficherInfixe() {
        if (!vide()) {
            filsGauche().afficherInfixe();
            System.out.println(this.info);
            filsDroit().afficherInfixe();

        }
    }

    public static boolean contenu(Liste l, Arbre a) {
        // on test si l appartient à a

        if (l.vide())
            return true;
        if (a.vide())
            return false;
        if (a.info() == l.tete())
            return (contenu(l.reste(), a.filsGauche()) || contenu(l.reste(), a.filsDroit()));
        else
            return (contenu(l, a.filsGauche()) || contenu(l, a.filsDroit()));

    }

    public void setFilsGauche(Arbre arbre){
        this.filsD = arbre;
    

    public void setFilsDroit(Arbre arbre){
        this.fd = arbre;
    }

    /*
     * public boolean contains ( int val) { // si val est contenu dans notre arbre
     * if ( !vide) { if ( val == info()) return true; else { return
     * filsGauche().contains(val) || filsDroit().contains(val); }
     * 
     * } return false;
     * 
     * }
     */
    public static void main(String[] args) {


        Arbre root = new Arbre(1, new Arbre(2, new Arbre(4), new Arbre(5)), new Arbre(3, new Arbre(10), new Arbre()));
        root.afficher();
        // System.out.println(contenu(new Liste(2,new Liste(3,new Liste())),root));
        // System.out.println(root.contains(6));

    }

}
