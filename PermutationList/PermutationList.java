package PermutationList;
import java.util.ArrayList;

public class PermutationList{
    private ArrayList<Integer> numList = new ArrayList<Integer>();

    public PermutationList(){
        fillNumList(1, 10);
    }
    //Precondition: numberOfEntries >= 1
    public PermutationList(int numberOfEntries){
        fillNumList(1, numberOfEntries);
    }
    //Precondition: upper >= lower
    public PermutationList(int lower, int upper){
        fillNumList(lower, upper);
    }
    public PermutationList(int[] numberList){
        for(int i = 0; i < numberList.length; i++){
            numList.add(numberList[i]);
        }
    }

    public ArrayList<Integer> nextPermutation(){
        ArrayList<Integer> returnList = new ArrayList<Integer>();
        ArrayList<Integer> cloneList = new ArrayList<Integer>();
        for(int i = 0; i < numList.size(); i++){
            cloneList.add(numList.get(i));
        }
        for(int i = cloneList.size() - 1; i >= 0; i--){
            returnList.add(cloneList.remove((int)Math.floor(Math.random() * cloneList.size())));
        }
        return returnList;
    }
    
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

    /*public int totalCombinations(){

    }*/

    //for solving permutations in the form nPr
    //precondition n >= r
    public static int numPermutations(int n, int r){
        int numPerms = 1;
        for(int i = n - r + 1; i <= n; i++){
            numPerms *= i;
        }
        return numPerms;
    }

    //for solving permutations in the form nCr
    //precondition n >= r
    /*public static int numCombinations(int n, int r){

    }*/

    private void fillNumList(int lower, int upper){
        for(int i = lower; i <= upper; i++){
            numList.add(i);
        }
    }

    //gets list of all unique entries within a permutation list
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

    //since java.util.Math does not include a factorial method
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