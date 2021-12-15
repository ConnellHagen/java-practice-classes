import PermutationList.*;
import RegularPolygon.*;

public class Main {
    public static void main(String args[]){
        PermutationList test = new PermutationList(new int[]{2, 5, 7, 7, 3, 5, 6, 7});
        System.out.println(test.totalPermutations());
        /*RegularPolygon pentagon = new RegularPolygon(5, 8.2);
        System.out.println(pentagon.toString());*/
    }
    
}
