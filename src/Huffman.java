//Projet Huffman Algo S3 : Dorian GILBERT - Richard MOREL - Matteo SERRANO
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.util.*;
import java.io.IOException;
import java.net.URL;

public class Huffman {

    public static HashMap<Character, Integer> coupleFreq = new HashMap<Character, Integer>();

    public static String cheminFreq = "freq.txt";
    public static String cheminTexte = "texteSE.txt";
 
    public static Arbre huffman(Liste liste){
        
        if(!liste.reste().vide()){

            Arbre z = new Arbre();
            
            Arbre x = liste.tete();

            z.setFilsGauche(x);
            Arbre y = liste.reste().tete();
            z.setFilsDroit(y);

            z.setFreq(x.freq()+y.freq());
            return huffman(liste.reste().reste().insererOrd(z));
        }
        else
            return liste.tete();
        
    }

    

  /*  public HashMap<Character, Integer> calculCodage(Arbre arbre) {

        if(!arbre.vide()){
            if(arbre.feuille){
                System.out.println(lettre,freq);
            }
            else{
                creerCodage(arbre.filsGauche());
                creerCodage(arbre.filsDroit());
            }
        } 


    }*/

    public ArrayList<String> encoder(String texte) {
        /*Comparer le texte avec la table de codage obtenue avec calculCodage pour récupérer le codage de chaque lettre et 
        ajouter les codages de chaque lettre cote a cote dans la string pour obtenir un texte*/
        Scanner read = null;
        String binaire;
        ArrayList<String> arrList = new ArrayList<String>(5);
        
        URL url = Huffman.class.getResource(cheminFreq);
        
        File file = new File(url.getPath());
 
        try (FileReader fr = new FileReader(file)) {
            int content;
            while ((content = fr.read()) != -1) {
                for (Character i : coupleFreq.keySet()) {//Remplacer par hashmap calculcodage
                    if((char) content == i)
                    {
                        arrList.add(coupleFreq.get(i));
                    }
                    //System.out.println("key: " + i + "value: " + coupleFreq.get(i));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return arrList;
       
    }

    public ArrayList<String> decoder(ArrayList<String> binaire) {
        /*Comparer chaque lettre codée avec la table de codage obtenue avec calculCodage pour récupérer la lettre correspondante
        à chaque valeur codée et ajouter les lettres cote a cote dans un fichier texte*/
        String str = "";

        for (String i : binaire) {
            for (Character j : coupleFreq.keySet()) {//Remplacer par hashmap calculcodage
                if(i == coupleFreq.get(j)) //Remplacer par hashmap calculcodage
                {
                    str += j;
                }
            }
        }

        return str;
    }

    public static HashMap<Character, Integer> lireFrequences() {

        HashMap<Character, Integer> coupleFreq = new HashMap<Character, Integer>();
        //Liste liste = new Liste();
        
        Scanner read = null;
        /*URL url = Huffman.class.getResource(cheminFreq);
            read = new Scanner(new File(url.getPath()));*/
            
        URL url = Huffman.class.getResource(cheminFreq);

        try {
            read = new Scanner(new File(url.getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        read.useDelimiter(",|\n");
        while (read.hasNext()) {

            char lettre;
            
            String str = read.next();
            if (str == "")
            {
                lettre = '\s';
            }
            else if(str.charAt(0) == '\"')
            {
                lettre = str.charAt(1);
            }
            else
            {
                lettre = str.charAt(0);
            }

            String freqStr = read.next();

            int freq = (int)freqStr.charAt(freqStr.length()-1);
            
            //freq = Integer.parseInt(freqStr);
            //liste.insererOrd(new Arbre(freq,lettre));
            coupleFreq.put(lettre, freq);
        }
        /*for (Character i : coupleFreq.keySet()) {
            System.out.println("key: " + i + "value: " + coupleFreq.get(i));
        }*/
        read.close();

        return coupleFreq;
    }

    public static void main(String[] args) {

        //HashMap<Character, Integer> coupleFreq = lireFrequences();
        Liste coupleFreq = new Liste(new Arbre(5,'y'),new Liste(new Arbre(9,'t'),new Liste(new Arbre(15,'w'),new Liste(new Arbre(18,'e'),new Liste()))));
        Arbre arbreHuffman = huffman(coupleFreq);
        arbreHuffman.afficher();
    }
}