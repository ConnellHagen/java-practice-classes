package StringParser;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class StringParser {

    private ArrayList<String> temp;

    public StringParser(String a) {

        temp = new ArrayList<String>();
        temp.add(a.toLowerCase());

    }

    public StringParser(File file){

        temp = new ArrayList<String>();

        try{
            Scanner fileScanner = new Scanner(file);
            while(fileScanner.hasNextLine()){
                temp.add(fileScanner.nextLine());
            }
            fileScanner.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    /**
     * countWords(); A "word" is defined as a contiguous string of alphabetic
     * characters i.e. any upper or lower case characters a-z or A-Z. This method
     * completely ignores numbers when you count words, and assumes that the
     * document/paragraph does not have any strings that combine numbers and
     * letters.
     */
    public int countWords() {

        int wordCount = 0;
        for(int i = 0; i < temp.size(); i++){

            Scanner wordCounter = new Scanner(temp.get(i));
            while(wordCounter.hasNext()){
                wordCount++;
                wordCounter.next();
                    
            }
            wordCounter.close();

        }

        return wordCount;

    }

    public int countVowels() {

        int vowelCount = 0;
        for(int i = 0; i < temp.size(); i++){
            for(int j = 0; j < temp.get(i).length(); j++){
                char letter = temp.get(i).charAt(j);
                if(isVowel(letter)){
                    vowelCount++;
                }
            }
        }
        return vowelCount;

    }

    private boolean isVowel(char letter) {

        switch(letter){
            case 'a': case 'e': case 'i': case 'o': case 'u': case 'y':
                return true;
            default:
                return false;
        }

    }

    /**
     * Get the total number of syllables in the document (the paragraph). To count
     * the number of syllables in a word, use the following rules: Each contiguous
     * sequence of one or more vowels is a syllable, with the following exception: a
     * lone "e" at the end of a word is not considered a syllable unless the word
     * has no other syllables. You should consider y a vowel.
     */
    public int countSyllables() {

        int syllableCount = 0;

        for(int i = 0; i < temp.size(); i++){

            Scanner wordScanner = new Scanner(temp.get(i));

            while(wordScanner.hasNext()){
                String word = wordScanner.next();
                boolean withinVowelString = false;
                int wordSyllables = 0;

                for(int j = 0; j < word.length(); j++){
                    if(isVowel(word.charAt(j))){

                        if(j == word.length() - 1){
                            break;
                        }

                        if(!withinVowelString){
                            withinVowelString = true;
                            wordSyllables++;
                        }

                    }
                    else{
                        withinVowelString = false;
                    }
                }

                if(wordSyllables == 0){
                    wordSyllables = 1;
                }

                syllableCount += wordSyllables;

            }

            wordScanner.close();
        }

        return syllableCount;

    }
/**
   * Eventually write this one too. Get the number of sentences in the document/paragraph.
   * Sentences are defined as contiguous strings of characters ending in an 
   * end of sentence punctuation (. ! or ?) or the last contiguous set of 
   * characters in the document, even if they don't end with a punctuation mark.
   */
    public int countSentences() {

        int senCount = 0;

        for(int i = 0; i < temp.size(); i++){
            Scanner sentenceScanner = new Scanner(temp.get(i));
            sentenceScanner.useDelimiter("[\\.!?]");

            while(sentenceScanner.hasNext()){
                senCount++;
                sentenceScanner.next();
            }

            sentenceScanner.close();
        }
        return senCount;
    }

    public String toString() {
        return "words: " + countWords() + ", vowels: " + countVowels() + ", sentences: " + countSentences() + ", syllables: " + countSyllables();
    }
}