import java.util.HashMap;
import java.util.Scanner;
import java.util.File;

public class Huffman {

    public void createTree(HashMap<Character, Integer> occurences) {

    }

    public static void main(String[] args){
        HashMap<Character, Integer> coupleFreq = new HashMap<Character, Integer>();
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
        read.close();
    }
}
