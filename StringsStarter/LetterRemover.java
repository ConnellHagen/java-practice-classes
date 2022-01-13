package StringsStarter;

public class LetterRemover{
    private String[] sentence;
    private String remove;

    public LetterRemover(String s, String r){
        sentence = s.split(" ");
        remove = r;
    }

    public void removeLetters(){
        for(int i = 0; i < sentence.length; i++){
            String word = sentence[i].replaceAll(remove, "");
            sentence[i] = word;
        }
    }

    public String toString(){
        String temp = "";
        for(String word : sentence){
            temp += word;
            temp += " ";
        }
        temp = temp.substring(0, temp.length()-1);
        return temp;
    }
}
