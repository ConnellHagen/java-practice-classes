package VowelWord;

public class Word implements Comparable<Word> {

	private String word;

	public Word(String p_word) {
		word = p_word;
	}

	public int compareTo(Word word2) {
		int compare = word.length() - word2.getWord().length();
		if(compare != 0) return compare;
		
		return word.compareTo(word2.word);
	}

	public String getWord() {
		return word;
	}

	@Override
	public String toString() {
		return word;
	}
}