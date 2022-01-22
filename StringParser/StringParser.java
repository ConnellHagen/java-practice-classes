package StringParser;

import java.util.Scanner;
import java.io.File;

public class StringParser {

    private String temp;

    public StringParser(String a) {

        temp = a.toLowerCase();

    }

    public StringParser(File file){

        try{
            Scanner fileScanner = new Scanner(file);
            while(fileScanner.hasNextLine()){
                temp += fileScanner.nextLine().toLowerCase();
                temp += " ";
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

        Scanner wordCounter = new Scanner(temp);
        wordCounter.useDelimiter("[^a-z]+");
        while(wordCounter.hasNext()){
            wordCount++;
            wordCounter.next();
        }
        wordCounter.close();

        return wordCount;

    }

    public int countVowels() {

        int vowelCount = -1;
        Scanner vowelCounter = new Scanner(temp);
        vowelCounter.useDelimiter("[aeiou]");

        while(vowelCounter.hasNext()){
            vowelCount++;
            vowelCounter.next();
        }

        vowelCounter.close();

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

        Scanner wordScanner = new Scanner(temp);

        while(wordScanner.hasNext()){

            String word = wordScanner.next();
            boolean withinVowelString = false;
            int wordSyllables = 0;

            for(int j = 0; j < word.length(); j++){

                if(isVowel(word.charAt(j))){

                    if(j == word.length() - 1 && word.charAt(j) == 'e'){
                        break;
                    }
                    else if(!withinVowelString){
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

        Scanner sentenceScanner = new Scanner(temp);
        sentenceScanner.useDelimiter("[\\.!?]");

        while(sentenceScanner.hasNext()){
            senCount++;
            sentenceScanner.next();
        }

        sentenceScanner.close();
        
        return senCount;
    }

    public float readingEase(){
        return (float)(206.835 - (1.015 * ((float)countWords() / countSentences())) - (84.6 * ((float)countSyllables() / countWords())));
    }

    public int gradeLevel(){
        return (int)(0.39 * ((float)countWords() / countSentences()) + 11.8 * ((float)countSyllables() / countWords()) - 15.59);
    }

    public String toString() {
        return "words: " + countWords() + ", vowels: " + countVowels() + ", sentences: " + countSentences() + ", syllables: " + countSyllables() + ", reading ease: " + readingEase() + ", reading grade level: " + gradeLevel();
    }
}