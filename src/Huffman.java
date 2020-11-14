import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Huffman {

    public static HashMap<Character, Integer> coupleFreq = new HashMap<Character, Integer>();

    public static String cheminFreq = "";
    public static String cheminTexte = "../toto.txt";

    // public Arbre créerArbre(HashMap<Character, Integer> occurences) {
        


    // }

    // public huffman(Liste liste){

    //     Liste l = new Liste();
        
    //     if(!l.reste().vide()){

    //         Arbre z = new Arbre();
            
    //         Arbre x = l.tete();

    //         z.setFilsGauche(x);
    //         Arbre y = l.reste().tete();
    //         z.setFilsDroit(x);

    //         z.setFreq(x.freq()+y.freq());
    //         return créerArbre(l.reste().reste().insererOrd(z));
    //     }
        
    //     return 


    // }

    // public HashMap<Character, Integer> calculCodage(Arbre a) {
    //     //Convertir les lettres/fréquences en codage binaire grace a l'arbre de Huffman
    // }

    // public String encoder(String texte) {
    //     /*Comparer le texte avec la table de codage obtenue avec calculCodage pour récupérer le codage de chaque lettre et 
    //     ajouter les codages de chaque lettre cote a cote dans la string pour obtenir un texte*/
    //     Scanner read = null;
    //     String binaire;

    //     File file = new File("../src/"+texte);
 
    //     try (FileReader fr = new FileReader(file)) {
    //         int content;
    //         while ((content = fr.read()) != -1) {
    //             /*for (Character i : coupleFreq.keySet()) {
    //                 if((char) content == coupleFreq.get(i)) //Si pas ça remplacer par i
    //                 {

    //                 }
    //                 System.out.println("key: " + i + "value: " + coupleFreq.get(i));
    //             }*/
    //         }
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }

    //     for (Character i : coupleFreq.keySet()) {
    //         System.out.println("key: " + i + "value: " + coupleFreq.get(i));
    //     }

    //     return String null;

        
    // }

    // public /*Texte*/ decoder(String s) {
    //     /*Comparer chaque lettre codée avec la table de codage obtenue avec calculCodage pour récupérer la lettre correspondante
    //     à chaque valeur codée et ajouter les lettres cote a cote dans un fichier texte*/
    // }

    // public static Liste lireFrequences() {

    //     //HashMap<Character, Integer> coupleFreq = new HashMap<Character, Integer>();
    //     Liste liste = new Liste();
        
        
    //     char lettre;
    //     String freqStr;
    //     int freq;
    //     Scanner read = null;

    //     try {
    //         read = new Scanner(new File("../src/freq.txt"));
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    //     read.useDelimiter(",|\n");
    //     while (read.hasNext()) {
    //         String str = read.next();
    //         if (str == "")
    //         {
    //             lettre = '\s';
    //         }
    //         else if(str.charAt(0) == '\"')
    //         {
    //             lettre = str.charAt(1);
    //         }
    //         else
    //         {
    //             lettre = str.charAt(0);
    //         }
    //         freqStr = read.next();
    //         freq = Integer.parseInt(freqStr);
    //         liste.insererOrd(new Arbre(freq,lettre));
    //         //coupleFreq.put(lettre, freq);
    //     }
    //     /*for (Character i : coupleFreq.keySet()) {
    //         System.out.println("key: " + i + "value: " + coupleFreq.get(i));
    //     }*/
    //     read.close();

    //     return liste;
    // }

    /*public static void main(String[] args) {

        Liste coupleFreq = lireFrequences();

    }*/
}
