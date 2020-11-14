public class Arbre {

    private int freq;
    private char lettre;
    private Arbre filsG;
    private Arbre filsD;

    public Arbre() {
        this.freq = -1;
    }

    public Arbre(int freq, char lettre) {

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
    }

    public int freq() {
        return this.freq;
    }

    public char lettre() {
        return this.lettre;
    }

    public boolean vide() {
        if (this.freq == -1)
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

    public boolean feuille() {
        if (this.filsDroit().vide() && this.filsGauche().vide())
            return true;
        else
            return false;
    }

    public void afficher() {
        // affiche d'abord info, fils gauche puis fils droit
        if (!vide()) {
            System.out.println("freq : " + this.freq + " lettre : " + this.lettre);

            if (!this.filsGauche().vide())
                this.filsGauche().afficher();
            if (!this.filsDroit().vide())
                this.filsDroit().afficher();

        }

    }

    public void afficherInfixe() {
        if (!vide()) {
            filsGauche().afficherInfixe();
            System.out.println("freq : " + this.freq + " lettre : " + this.lettre);
            filsDroit().afficherInfixe();

        }
    }

    public boolean contenu(Arbre a) {
        // on teste si this appartient à a

        if (this.vide())
            return true;
        else if (a.vide())
            return false;
        else if (a.lettre() == this.lettre() && a.freq() == this.freq())
            return (this.filsGauche().contenu(a) || this.filsDroit().contenu(a));
        else
            return (this.contenu(a.filsGauche()) || this.contenu(a.filsDroit()));

    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    public void setLettre(char lettre) {
        this.lettre = lettre;
    }

    public void setFilsGauche(Arbre arbre) {
        this.filsG = arbre;
    }

    public void setFilsDroit(Arbre arbre) {
        this.filsD = arbre;
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
/*
    public static void main(String[] args) {

        Arbre groot = new Arbre();
        groot.afficher();
        groot = new Arbre(1,'t');
        groot.afficher();
        groot = new Arbre(1,'t',new Arbre(3,'f'), new Arbre(9,'y'));
        groot.afficher();
        if (new Arbre(3,'f').contenu(groot))
            System.out.println("yes");
        groot.afficherInfixe();
        // System.out.println(contenu(new Liste(2,new Liste(3,new Liste())),root));
        // System.out.println(root.contains(6));
    }
*/
}
