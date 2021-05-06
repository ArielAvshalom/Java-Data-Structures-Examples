import java.util.HashMap;

public class hashMap{
    public static void main(String[] args) {
        HashMap<String, String> cities = new HashMap<String, String>();

        //Put is a function which allows you to input a key-value pair

        cities.put("England", "London"); //let's say we add liverpool. The trick for that is to use an array instead of a String in the value side.
        cities.put("Ireland", "Dublin");
        cities.put("Germany", "Berlin");
        cities.put("Australia", "Canberra");
        cities.put("World", "New York City");

        //print the hashmap
        System.out.println(cities);
        
        //O(1) pull time
        String pulled;
        pulled = cities.get("England");

        System.out.println(pulled);

        //Remove (O(1) + some constant a where a is the number of collisions in that hash)

        cities.remove("England");
        System.out.println(cities);



    }
    
}