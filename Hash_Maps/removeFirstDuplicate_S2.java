//For this problem, you're give an array of integers. You have an array of integers between 1 and n inclusive where n is the size of the array.
//IF every value between 1 and n is used, great, otherwise
//Return the first duplicate value you see in the array.

//Look through the array and try finding the first duplicate and if you do find it, return it, and if you don't then return False

//[1,2,3,4,4,5,6,7] -> return 4
//[1,5,4,6,4,6,2,3,4] -> 4
//[7,6,4,5,2,1,0] -> False

//Caveat: Time and space complexity of O(n), there is a method of O(n) time and O(1) space.

//This method is O(n) time and space.
import java.util.*;

public class removeFirstDuplicate_S2 {
    public int firstDuplicateValue(int[] array) {
        HashSet<Integer> seen = new HashSet<Integer>();

        for (int value : array){
            if (seen.contains(value)) return value;
            seen.add(value);
        }
        return -1;
    }
}
