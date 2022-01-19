package StringParser;

import java.util.Scanner;

public class StringParser {

    private String temp;

    public StringParser(String a) {

        temp = a.toLowerCase();

    }

    /**
     * countWords(); A "word" is defined as a contiguous string of alphabetic
     * characters i.e. any upper or lower case characters a-z or A-Z. This method
     * completely ignores numbers when you count words, and assumes that the
     * document/paragraph does not have any strings that combine numbers and
     * letters.
     */
    public int countWords() {

        Scanner wordCounter = new Scanner(temp);
        int wordCount = 0;

        while(wordCounter.hasNext()){
            wordCount++;
            wordCounter.next();
        }

        wordCounter.close();

        return wordCount;

    }

    public int countVowels() {

        int vowelCount = 0;
        for(int i = 0; i < temp.length(); i++){
            char letter = temp.charAt(i);
            if(isVowel(letter)){
                vowelCount++;
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

        Scanner wordScanner = new Scanner(temp);

        int syllableCount = 0;

        while(wordScanner.hasNext()){
            String word = wordScanner.next();
            boolean withinVowelString = false;
            int wordSyllables = 0;

            for(int i = 0; i < word.length(); i++){
                if(isVowel(word.charAt(i))){

                    if(i == word.length() - 1){
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

        return syllableCount;

    }
/**
   * Eventually write this one too. Get the number of sentences in the document/paragraph.
   * Sentences are defined as contiguous strings of characters ending in an 
   * end of sentence punctuation (. ! or ?) or the last contiguous set of 
   * characters in the document, even if they don't end with a punctuation mark.
   */
    public int countSentences() {
        Scanner sentenceScanner = new Scanner(temp);
        sentenceScanner.useDelimiter("[\\.!?]");

        int senCount = 0;
        while(sentenceScanner.hasNext()){
            senCount++;
            sentenceScanner.next();
        }

        sentenceScanner.close();

        return senCount;
    }

    public String toString() {
        return "words: " + countWords() + ", vowels: " + countVowels() + ", sentences: " + countSentences() + ", syllables: " + countSyllables();
    }
}
// words 10
// vowels 15
// sentences 2
// syllables 13

//https://en.wikipedia.org/wiki/Flesch%E2%80%93Kincaid_readability_tests
//https://www.azquotes.com/author/22245-Rudolf_Flesch
// Ease of reading: 83.32000000000004
// Grade Level 2//
