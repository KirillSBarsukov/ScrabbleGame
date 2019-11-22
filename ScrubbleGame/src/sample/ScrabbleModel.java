package sample;



import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ScrabbleModel {
    private String inputWord;
    private static ArrayList<String> allAcceptedWords = new ArrayList<String>();

    static HashMap<Character, Integer> bag = new HashMap<Character, Integer>()
    {
        {
            put('e', 12);
            put('a', 9);
            put('r', 6);
            put('o', 8);
            put('i', 8);
            put('t', 6);
            put('s', 4);
            put('n', 6);
            put('l', 4);
            put('d', 4);
            put('u', 4);
            put('g', 3);
            put('p', 2);
            put('m', 2);
            put('b', 2);
            put('h', 2);
            put('c', 2);
            put('w', 2);
            put('y', 2);
            put('f', 2);
            put('v', 2);
            put('k', 1);
            put('x', 1);
            put('z', 1);
            put('j', 1);
            put('q', 1);
        }
    };

    static HashMap<Character, Integer> bag = new HashMap<Character, Integer>()
    {
        {
            put('e', 12);
            put('a', 9);
            put('r', 6);
            put('o', 8);
            put('i', 8);
            put('t', 6);
            put('s', 4);
            put('n', 6);
            put('l', 4);
            put('d', 4);
            put('u', 4);
            put('g', 3);
            put('p', 2);
            put('m', 2);
            put('b', 2);
            put('h', 2);
            put('c', 2);
            put('w', 2);
            put('y', 2);
            put('f', 2);
            put('v', 2);
            put('k', 1);
            put('x', 1);
            put('z', 1);
            put('j', 1);
            put('q', 1);
        }
    };

    public ScrabbleModel(String inputWord) {
        this.inputWord = inputWord;

        process();
    }

    public String getInputWord() {
        return inputWord;
    }

    public void setInputWord(String inputWord) {
        this.inputWord = inputWord;
    }

    public ArrayList<String> getAllAcceptedWords() {
        return allAcceptedWords;
    }


    public void setAllAcceptedWords(String inputWord) {

        for (char ch : inputWord.toCharArray()){
            for (Character key : bag.keySet()) {

                if(key == ch){
                    //System.out.println("Hahaha" + bag.get(key));
                    bag.put(key, bag.get(key) - 1);
                }
            }
        }

        this.allAcceptedWords.add(inputWord);


    }

    public boolean validateHandledWord(String inputWord){

        int vowelCount = 0;
        // Check if the word is short
        if(inputWord.length() <= 1 || inputWord.length() > 8){
            return false;
        }

        // Check if the word does not include vowels
        for (int index = 0;  index < inputWord.length(); ++index) {
            switch(inputWord.charAt(index)) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    vowelCount++;
                    break;
            }

        }
        // Word does not contain a vowel
        if(vowelCount == 0){
            return false;
        }


        // Check if the user already passed the word
        if(allAcceptedWords.contains(inputWord)){
            return false;
        }

        setAllAcceptedWords(inputWord);
        return true;
    }

    public void process(){
        System.out.println("Bag before " + bag.entrySet());
        System.out.println("Processed");
        System.out.println(validateHandledWord(inputWord));
        System.out.println(allAcceptedWords.toString());
        System.out.println("Bag after " + bag.entrySet());
    }

}
