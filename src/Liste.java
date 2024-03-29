//Projet Huffman Algo S3 : Dorian GILBERT - Richard MOREL - Matteo SERRANO
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

        if (this.vide()) {
            return this.prefixer(arbre);
        }
        else
            return this.reste().inserer(arbre).prefixer(this.tete());
               

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
            return this.reste().insererOrd(arbre).prefixer(this.tete());

    }

    public static void main(String[] args) {

  
        Liste l = new Liste(new Arbre(5,'y'),new Liste(new Arbre(9,'t'),new Liste()));

        l = l.insererOrd(new Arbre(15,'b'));
        //l=l.prefixer(new Arbre(2,'b'));

        l.afficher();
    }

}