import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Huffman {

    public Arbre créerArbre(HashMap<Character, Integer> occurences) {
        
        Liste l = new Liste();
        
        if(!l.reste().vide()){

            Arbre z = new Arbre();
            
            Arbre x = l.tete();

            z.setFilsGauche(x);
            Arbre y = l.reste().tete();
            z.setFilsDroit(x);

            z.setFreq(x.freq());

        }
        


    }

    public HashMap<Character,Integer> calculCodage(Arbre a) {

    }

    public String encoder(/*Texte*/) {

    }

    public /*Texte*/ decoder(String s) {

    }

    public HashMap<Character, Integer> lireFrequences(){

        HashMap<Character, Integer> coupleFreq = new HashMap<Character, Integer>();
        char lettre;
        String freqStr;
        char freq2;
        int freq;
        Scanner read = null;
        try {
            read = new Scanner (new File("../src/freq.txt"));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        read.useDelimiter(",|\n");
        while (read.hasNext())
        {
            String str = read.next();
            lettre = str.charAt(0); //Problème string vide
            freqStr = read.next();
            freq = Integer.parseInt(freqStr);
            coupleFreq.put(lettre, freq);
        }
        for (Character i : coupleFreq.keySet()){
            System.out.println("key: "+ i +"value: "+ coupleFreq.get(i));
        }
        read.close();

        return coupleFreq;
    }

    public static void main(String[] args){
        /*HashMap<Character, Integer> coupleFreq = new HashMap<Character, Integer>();
        char lettre;
        String freqStr;
        char freq2;
        int freq;
        Scanner read = null;
        try {
            read = new Scanner (new File("../src/freq.txt"));
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        read.useDelimiter(",|\n");
        while (read.hasNext())
        {
            String str = read.next();
            lettre = str.charAt(0); //Problème string vide
            freqStr = read.next();
            freq = Integer.parseInt(freqStr);
            coupleFreq.put(lettre, freq);
        }
        for (Character i : coupleFreq.keySet()){
            System.out.println("key: "+ i +"value: "+ coupleFreq.get(i));
        }
        read.close();*/
    }
}
