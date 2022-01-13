package StringsStarter;

public class StringRemover{
    private String remove;
    private String sentence;

    public StringRemover(String sen, String rem){
        sentence = sen;
        remove = rem;
    }

    public void removeStrings(){
        for(int i = 0; i < sentence.length() - remove.length() + 1; i++){
            if(sentence.substring(i, i + remove.length()).equals(remove)){
                try{
                    sentence = sentence.substring(0, i - 1) + sentence.substring(i + remove.length(), sentence.length());
                }
                catch(Exception e){
                    sentence = sentence.substring(0, i) + sentence.substring(i + remove.length(), sentence.length());
                }
            }
        }
    }

    public String toString(){
        return sentence;
    }
}
