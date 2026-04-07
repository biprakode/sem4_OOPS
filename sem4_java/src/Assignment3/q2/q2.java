package Assignment3.q2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class q2 {
    public static String readFileAsString(String fileName) throws Exception {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
    {
        // Creating a list from elements of HashMap
        List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

        // Sorting the list using Collections.sort() method
        // using Comparator
        list.sort(Map.Entry.<String, Integer>comparingByValue().reversed());;

        // putting the  data from sorted list back to hashmap
        HashMap<String, Integer> result
                = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> me : list) {
            result.put(me.getKey(), me.getValue());
        }

        // returning the sorted HashMap
        return result;
    }

    public static void main() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Reading File name
        String path = "/run/media/biprarshi/COMMON/files/JUlabs/sem4_OOPS/Python/text.txt";

        String data = readFileAsString(path);

        HashMap<String, Integer> map = new HashMap<>();
        for (String word : data.split(" ")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        Map<String, Integer> map_sorted = sortByValue( map);

        System.out.println("Sorted by Value");
        for (Map.Entry<String, Integer> entry : map_sorted.entrySet()) {
            System.out.println("Key : " + entry.getKey() + ", Value : " + entry.getValue());
        }

    }
}
