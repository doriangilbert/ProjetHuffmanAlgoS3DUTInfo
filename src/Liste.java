public class Liste {

    private Arbre tete;
    private Liste reste;

    public Liste() {
        this.tete = new Arbre();
        //this.reste = null;
    }

    public Liste(Arbre arbre, Liste liste) {
        this.tete = arbre;
        this.reste = liste;
    }

    public Arbre tete() {
        if (!this.vide())
            return this.tete;
        else
            return null;
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
        else
            return new Liste();
    }

    public Liste prefixer(Arbre arbre) {
        return new Liste(arbre, this);
    }

    public static void afficherInverse(Liste l) {
        // System.out.println("salut");

        if (!l.vide()) {

            afficherInverse(l.reste());
            System.out.println(l.tete());

        }

    }

    public void afficher() {
        if (this.vide())/*!(this.vide()))*/ {
            //this.tete.afficher();
            //this.reste.afficher();
            System.out.println("vide");
        }
        else {
            //System.out.println("vide");
            this.tete.afficher();
            this.reste.afficher();
        }
    }

    public Liste inserer(Arbre arbre) {

        if (!this.vide()) {
            return this.reste().inserer(arbre);
        }
        else {
            return this.prefixer(arbre);
        }

    }

    public Liste supprimerOrd(Arbre arbre) {
        if (this.vide())
            return this;
        if (this.tete().freq() == arbre.freq())
            return this.reste.supprimerOrd(arbre);
        // return l.tete() + supprimerOrd(l.reste,val);
        return this.reste.supprimerOrd(arbre);
    }

    public Liste insererOrd(Arbre arbre) {

        if (this.vide() || arbre.freq() < this.tete().freq())
            return this.prefixer(arbre);
        else
            return this.reste().insererOrd(arbre);

    }

    public static void main(String[] args) {

        //Liste l = new Liste();

        
        // System.out.println(l.inserer(6,l).reste().reste().reste().reste().reste().tete());
        //l.inserer(new Arbre(1,'a'));
        //l.inserer(new Arbre(2,'b'));
        //l.supprimerOrd(l, 10);
        // System.out.println(l.prefixer(86).reste().tete());
        //l.afficher();
        // afficherInverse(l);
         //l.supprimerOrd(l, 10);
        Liste l2 = new Liste(new Arbre(5,'y'),new Liste(new Arbre(9,'t'),new Liste()));
        // System.out.println(l.prefixer(86).reste().tete());

        l2 = l2.inserer(new Arbre(2,'b'));
        //l2=l2.prefixer(new Arbre(2,'b'));

        l2.afficher();
        // afficherInverse(l);
    }

}
