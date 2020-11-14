import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.util.*;
import java.io.IOException;

public class Huffman {

    public static HashMap<Character, Integer> coupleFreq = new HashMap<Character, Integer>();

    public static String cheminFreq = "";
    public static String cheminTexte = "../toto.txt";

    public Arbre creerArbre(HashMap<Character, Integer> occurences) {
        


    }

    public Arbre huffman(Liste liste){

        Liste l = new Liste();
        
        if(!l.reste().vide()){

            Arbre z = new Arbre();
            
            Arbre x = l.tete();

            z.setFilsGauche(x);
            Arbre y = l.reste().tete();
            z.setFilsDroit(x);

            z.setFreq(x.freq()+y.freq());
            return creerArbre(l.reste().reste().insererOrd(z));
        }
        
        return 


    }

    public HashMap<Character, Integer> calculCodage(Arbre a) {
        //Convertir les lettres/fréquences en codage binaire grace a l'arbre de Huffman
        if(a.info()){
            freq+"0";
        }
        else{
            freq+"1";
        }

        // Ca ca renvoie un hashmap genre : {('a',0),('b',011),...}
    }

    public ArrayList<String> encoder(String texte) {
        /*Comparer le texte avec la table de codage obtenue avec calculCodage pour récupérer le codage de chaque lettre et 
        ajouter les codages de chaque lettre cote a cote dans la string pour obtenir un texte*/
        Scanner read = null;
        String binaire;
        ArrayList<String> arrList = new ArrayList<String>(5);

        File file = new File("../src/"+texte);
 
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

    public static Liste lireFrequences() {

        //HashMap<Character, Integer> coupleFreq = new HashMap<Character, Integer>();
        Liste liste = new Liste();
        
        
        char lettre;
        String freqStr;
        int freq;
        Scanner read = null;

        try {
            read = new Scanner(new File("../src/freq.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        read.useDelimiter(",|\n");
        while (read.hasNext()) {
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
            freqStr = read.next();
            freq = Integer.parseInt(freqStr);
            liste.insererOrd(new Arbre(freq,lettre));
            //coupleFreq.put(lettre, freq);
        }
        /*for (Character i : coupleFreq.keySet()) {
            System.out.println("key: " + i + "value: " + coupleFreq.get(i));
        }*/
        read.close();

        return liste;
    }

    /*public static void main(String[] args) {

        Liste coupleFreq = lireFrequences();

    }*/
}
