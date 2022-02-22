package VowelWord;

public class VowelWord implements Comparable<VowelWord> {

	private String word;

	public VowelWord(String p_word) {
		word = p_word;
	}

	public int compareTo(VowelWord word2) {
		int compare = numVowels() - word2.numVowels();
		if(compare != 0) return compare;
		
		return word.compareTo(word2.getWord());
	}

	public String getWord() {
		return word;
	}

	public int numVowels() {
		char[] letters = word.toCharArray();
		int counter = 0;
		String vowels = "aeiouAEIOU";

		for(char letter : letters) {
			if(vowels.indexOf(letter) != -1) counter++;
		}
		return counter;
	}

	@Override
	public String toString() {
		return word;
	}
}