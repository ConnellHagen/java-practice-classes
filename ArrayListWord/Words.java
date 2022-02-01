package ArrayListWord;

import java.util.ArrayList;
import java.util.Iterator;

public class Words {
    private ArrayList<Word> words;

	public Words(String[] wordList) {
        words = new ArrayList<Word>();
        for(String word: wordList){
            words.add(new Word(word));
        }
	}

	public int countWordsWithXChars(int size) {
		int count = 0;
        
        Iterator<Word> i_words = words.iterator();
        while(i_words.hasNext()) {
            if(i_words.next().getLength() == size) {
                count++;
            }
        }

		return count;
	}
	
	//this method will remove all words with a specified size / length
	//this method will also return the sum of the vowels in all words removed
	public int removeWordsWithXChars(int size) {
        int vowelSum = 0;

        Iterator<Word> i_words = words.iterator();
        while(i_words.hasNext()) {
            Word tempWord = i_words.next();
            if(tempWord.getLength() == size) {
                vowelSum += tempWord.getNumVowels();
                i_words.remove();
            }
        }

		return vowelSum;
	}

	public int countWordsWithXVowels(int numVowels) {
		int count = 0;

        Iterator<Word> i_words = words.iterator();
        while(i_words.hasNext()) {
            if(i_words.next().getNumVowels() == numVowels) count++;
        }

		return count;
	}
	
	//add in a toString
    public String toString() {
        return words.toString();
    }
}