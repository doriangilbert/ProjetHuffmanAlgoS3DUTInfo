import java.util.ArrayList;

public class Liste {

    private Arbre tete;
    private Liste reste;

    public Liste() {
    }

    public Liste(int e, Liste l) {

        tete = e;
        reste = l;
    }

    public Arbre tete() {
        if (!this.vide())
            return tete;
        return 0;
    }

    public boolean vide() {
        if (this.tete.vide())
            return true;
        else
            return false;
    }

    public Liste reste() {
        if (!this.vide())
            return reste;

        return new Liste();
    }

    public Liste prefixer(int val) {
        return new Liste(val, this);
    }

    public static void afficherInverse(Liste l) {
        // System.out.println("salut");

        if (!l.vide()) {

            afficherInverse(l.reste());
            System.out.println(l.tete());

        }

    }

    public static void afficher(Liste liste) {
        if (!(liste.vide())) {
            System.out.println(liste.tete());
            afficher(liste.reste);
        }
    }

    public static Liste inserer(int val, Liste l) {

        if (l.vide()) {
            return l.prefixer(val);
        } else {
            return inserer(val, l.reste()).prefixer(l.tete());
        }

    }

    public static Liste supprimerOrd(Liste l, int val) {
        if (l.vide())
            return l;
        if (l.tete() == val)
            return supprimerOrd(l.reste(), val);
        // return l.tete() + supprimerOrd(l.reste,val);
        return supprimerOrd(l.reste(), val);
    }

    public Liste insererOrd(int val, Liste l) {

        if (l.vide() || val < l.tete())
            return l.prefixer(val);

        return insererOrd(val, l.reste()).prefixer(l.tete());

    }

    public static void main(String[] args) {

        Liste l = new Liste(1, new Liste(2, new Liste(3, new Liste(4, new Liste(5, new Liste())))));
        // System.out.println(l.inserer(6,l).reste().reste().reste().reste().reste().tete());
        l = inserer(6, l);
        l = inserer(10, l);
        l = supprimerOrd(l, 10);

        // System.out.println(l.prefixer(86).reste().tete());
        afficher(l);
        // afficherInverse(l);
    }

}
