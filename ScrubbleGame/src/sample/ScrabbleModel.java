package sample;


import java.util.*;

public class ScrabbleModel {

    private String inputWord;
    private String errorMsg = "";
    private static int totalPoints = 0;
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

    static HashMap<Character, Integer> points = new HashMap<Character, Integer>()
    {
        {
            put('a', 1);
            put('b', 3);
            put('c', 3);
            put('d', 2);
            put('e', 1);
            put('f', 4);
            put('g', 2);
            put('h', 4);
            put('i', 1);
            put('j', 8);
            put('k', 5);
            put('l', 1);
            put('m', 3);
            put('n', 1);
            put('o', 1);
            put('p', 3);
            put('q', 10);
            put('r', 1);
            put('s', 1);
            put('t', 1);
            put('u', 1);
            put('v', 4);
            put('w', 4);
            put('x', 8);
            put('y', 4);
            put('z', 10);
        }
    };

    public ScrabbleModel(String inputWord) {
        this.inputWord = inputWord.toLowerCase();
        process();
    }

    public String getInputWord() { return inputWord; }

    public void setInputWord(String inputWord) {
            this.inputWord = inputWord;
    }

    public int getTotalPoints() { return totalPoints; }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints += totalPoints;
    }

    public String getErrorMsg() { return errorMsg; }
    public void setErrorMsg(String errorMsg) { this.errorMsg = errorMsg; }
    public ArrayList<String> getAllAcceptedWords() { return allAcceptedWords; }

    public int getCalculatedScore(String inputWord){
        int calculatedScore = 0;
        for (char ch : inputWord.toCharArray()){
            for (Character key : bag.keySet()) {
                if(key == ch){
                    calculatedScore = calculatedScore + points.get(key);
                }
            }
        }
        return calculatedScore;
    }

    public boolean setAllAcceptedWords(String inputWord) {

        for (char ch : inputWord.toCharArray()){
            for (Character key : bag.keySet()) {
                if(bag.get(ch) < 0){
                    setErrorMsg("Word contains letter " + ch + " that is no longer available “in bag” ");
                    return false;
                }

                if(key == ch){
                    bag.put(key, bag.get(key) - 1);
                }
            }

        }
        System.out.println(getCalculatedScore(inputWord));
        return this.allAcceptedWords.add(inputWord);

    }

    public boolean validateHandledWord(String inputWord){

        if(!inputWord.matches("[a-zA-Z]+")){
            setErrorMsg("Only words are allowed");
            return false;
        }
        int vowelCount = 0;
        // Check if the word is short
        if(inputWord.length() <= 1){
            setErrorMsg("Word is too short");
            return false;
        }
        if(inputWord.length() > 8){
            setErrorMsg("Word is too long");
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
            setErrorMsg("Word does not include vowel");
            return false;
        }

        // Check if the user already used the word
        if(allAcceptedWords.contains(inputWord)){
            setErrorMsg("You already used that word");
            return false;
        }
        return setAllAcceptedWords(inputWord);
    }

    public String formattedArrayList(ArrayList allAcceptedWords){
        String formattedString = allAcceptedWords.toString()
                .replace("[", "")  //remove the right bracket
                .replace("]", "")  //remove the left bracket
                .trim();
        return formattedString;
    }

    public void process(){
        System.out.println("Bag before " + bag.entrySet());
        if(validateHandledWord(inputWord)){
            setInputWord(inputWord);
            setTotalPoints(getCalculatedScore(inputWord));
        }
        System.out.println(getAllAcceptedWords());
        System.out.println("Bag after " + bag.entrySet());
    }

}
