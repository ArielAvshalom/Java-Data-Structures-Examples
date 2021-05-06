//For this problem, you're give an array of integers. You have an array of integers between 1 and n inclusive where n is the size of the array.
//IF every value between 1 and n is used, great, otherwise
//Return the first duplicate value you see in the array.

//Look through the array and try finding the first duplicate and if you do find it, return it, and if you don't then return False

//[1,2,3,4,4,5,6,7] -> return 4
//[1,5,4,6,4,6,2,3,4] -> 4
//[7,6,4,5,2,1,0] -> False

//Caveat: Time and space complexity of O(n), there is a method of O(n) time and O(1) space.

//Try figuring out the O(n) time and O(1) space on your own as an exercise.


//This solution takes O(n^2) time and O(1) space.
import java.util.*;


public class removeFirstDuplicate_S1 {
    public int firstDuplicateValue(int[] array) {
        int position = array.length;
            for (int i = 0; i < array.length; i++){
                int value = array[i];
                for (int j = i + 1; j < array.length; j ++) {//Still o(n^2) but an obvious speedup technique
                    int compare = array[j];
                    
                    if (value == compare){
                        position = Math.min(position, j);
                    }
                }
            }
            if (position == array.length){
                return -1;
            }
            return array[position];
      }
    }

    //put in a main here.

    public static void main(String[] args) {
        System.out.print("Wheeee");
    }
}
