// Name - Biprarshi Biswas
// Roll No - 002410501094
// BCSE-II A3

// Question:
// Extract the words and their frequencies from a text file. Then store them as key value
// pairs in a TreeMap. Sort them in descending order using Comparator. Now, display the
// greatest and the least key value pairs from the collection.

package Assignment3.q2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class q2 {
    // slurps the whole file into a single string
    public static String readFileAsString(String fileName) throws Exception {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    // sorts the map by value in descending order
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
        // dump entries into a list so we can sort them
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());

        // sort by value descending using a comparator
        list.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

        // LinkedHashMap preserves our sorted order
        HashMap<String, Integer> result = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> me : list) {
            result.put(me.getKey(), me.getValue());
        }

        return result;
    }

    public static void main() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // hard-coded path to a sample text file
        String path = "/run/media/biprarshi/COMMON/files/JUlabs/sem4_OOPS/Python/text.txt";

        String data = readFileAsString(path);

        // basic whitespace split and word count
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : data.split(" ")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // sort it by frequency descending
        Map<String, Integer> map_sorted = sortByValue(map);

        System.out.println("Sorted by Value");
        for (Map.Entry<String, Integer> entry : map_sorted.entrySet()) {
            System.out.println("Key : " + entry.getKey() + ", Value : " + entry.getValue());
        }
    }
}
