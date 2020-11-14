import java.util.HashMap;

public class Arbre {

    private HashMap<Integer, String> info = new HashMap<Integer,String>();
    private Arbre filsG;
    private Arbre filsD;
    private boolean vide;
    private boolean feuille = false;

    public Arbre() {
        vide = true;

    }

    public Arbre(int tete) {
        feuille = true;
        vide = false;

        this.info = tete;
        filsG = new Arbre();
        filsD = new Arbre();

    }

    public Arbre(int info, Arbre fg, Arbre fd) {
        vide = false;

        this.info = info;
        this.filsG = fg;
        this.filsD = fd;
        if (filsDroit().vide() && this.filsGauche().vide())
            feuille = true;

    }

    public int info() {
        return info;
    }

    public boolean vide() {

        return vide;
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
            System.out.println(info);

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
        // TODO Auto-generated method stub
        Arbre root = new Arbre(1, new Arbre(2, new Arbre(4), new Arbre(5)), new Arbre(3, new Arbre(10), new Arbre()));
        root.afficher();
        // System.out.println(contenu(new Liste(2,new Liste(3,new Liste())),root));
        // System.out.println(root.contains(6));
    }

}
