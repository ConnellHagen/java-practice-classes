package ArrayListWord;

public class Word {
    private String word;

    public Word(String p_word) {
        word = p_word;
    }

    public void setWord(String p_word) {
        word = p_word;
    }

    public int getNumVowels() {
        String tempWord = word.replaceAll("[^aeiou]", "");
        return tempWord.length() == 0 ? 1 : tempWord.length();
    }

    public int getLength() {
        return word.length();
    }

    public String toString() {
        return word;
    }
}