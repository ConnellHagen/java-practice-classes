package PermutationList;
import java.util.ArrayList;

public class PermutationList{
    private ArrayList<Integer> numList = new ArrayList<Integer>();
    private int upper;
    private int lower;

    public PermutationList(){
        lower = 1;
        upper = 10;
        fillNumList();
    }
    //Precondition: numberOfEntries >= 1
    public PermutationList(int numberOfEntries){
        lower = 1;
        upper = numberOfEntries;
        fillNumList();
    }
    //Precondition: upperBound >= lowerBound
    public PermutationList(int lowerBound, int upperBound){
        lower = lowerBound;
        upper = upperBound;
        fillNumList();
    }
    public PermutationList(int[] numberList){
        //since these numbers may not be in order, lower and upper are placeholders so loops work
        lower = 0;
        upper = numberList.length - 1;
        for(int i = 0; i < numberList.length; i++){
            numList.add(numberList[i]);
        }
    }

    private void fillNumList(){
        for(int i = lower; i <= upper; i++){
            numList.add(i);
        }
    }

    public ArrayList<Integer> randomPermutation(){
        ArrayList<Integer> returnList = new ArrayList<Integer>();
        ArrayList<Integer> cloneList = new ArrayList<Integer>();
        for(int i = 0; i < numList.size(); i++){
            cloneList.add(numList.get(i));
        }
        for(int i = lower; i <= upper; i++){
            returnList.add(cloneList.remove((int)Math.floor(Math.random() * cloneList.size())));
        }
        return returnList;
    }
    
    //not done
    public int totalPermutations(){
        int numP = 1;
        ArrayList<Integer> unique = uniqueList();
        ArrayList<Integer> duplicateNums = new ArrayList<Integer>();
        for(int i = 0; i < unique.size(); i++){
            duplicateNums.add(numOccurrences(unique.get(i)));
        }
        //total permutations possible if no duplicates
        for(int i = numList.size()-1; i >= 0; i--){
            numP *= (i + 1);
        }
        for(int i = 0; i < duplicateNums.size(); i++){
            numP /= PermutationList.factorial(duplicateNums.get(i));
        }
        return numP;
    }

    //not done
    private ArrayList<Integer> uniqueList(){
        ArrayList<Integer> uniqueList = new ArrayList<Integer>();
        for(int i = 0; i < numList.size(); i++){
            if(uniqueList.indexOf(numList.get(i)) == -1) uniqueList.add(numList.get(i));
        }
        return uniqueList;
    }

    //number of times that a value appears within the list
    private int numOccurrences(int val){
        int occurrences = 0;
        for(int i = 0; i < numList.size(); i++){
            if(numList.get(i) == val) occurrences++;
        }
        return occurrences;
    }

    private static int factorial(int num){
        if(num == 0) return 1;
        if(num == 1) return num;
        else return num * PermutationList.factorial(num - 1);
    }

    @Override
    public String toString(){
        String tempString = "";
        for(int i = 0; i < numList.size(); i++){
            tempString += numList.get(i).toString();
        }
        return tempString;

    }
}