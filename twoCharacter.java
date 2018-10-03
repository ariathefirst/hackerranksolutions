import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the alternate function below.
    static int alternate(String s) {
    /*
        use a set to get all distinct chars in s
        iterate through set for every two elements
        remove in string then update count
    */
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        int res = 0;
        for (Character a: set) {
            for (Character b : set) {
                if (a != b) {
                    StringBuilder dup_s = new StringBuilder(s);
                    int ct = dup_s.length();
                    int i = 0;
                    int length = dup_s.length();
                    while (i < length) {
                        if (dup_s.charAt(i) != a && dup_s.charAt(i) != b) {
                            dup_s = dup_s.deleteCharAt(i);
                            ct--;
                            length--;
                            if (i > 0) {
                                i--;
                            }
                        } else {  
                            i++;
                        }
                    }
                    if (hasRepeat(dup_s) == false) {
                        System.out.println(dup_s);                        
                        System.out.println("no repeat");

                        res = Math.max(ct, res);
                    }
                }
            }
        }
        return res;
    }
    static boolean hasRepeat(StringBuilder dup_s) {
        for (int i = 0; i < dup_s.length() - 1; i++) {
            if (dup_s.charAt(i) == dup_s.charAt(i+1)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
/*
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    // get keys whose value is min
    // static void printKeys(Map<Character,Integer> map) {
    //     // System.out.println("map content is:\n");
    //     for (Character key : map.keySet()) {
    //     //    System.out.println("map key is " + key + map.get(key));
    //     }
    // }
    // static void test (Map<Character,Integer> map) {
    //     // System.out.println("removing e\n");
    //     String h = "e";
    //     map.remove(h.charAt(0));
    //     printKeys(map);
    // }    
    public static Character getKey(Map<Character, Integer> map) {
        int curMin = Integer.MAX_VALUE;
        Character curKey = '\0';
        // System.out.println("map passed to getKey is\n");
        // printKeys(map);
        for (Character key : map.keySet()) {
        //    System.out.println("map key is " + key);
            // System.out.println("keys are " + keys);
            // System.out.println("while (map_size > 2)" + map_size);
            // if (map_size <= 2) return keys;
            if (map.get(key) < curMin) {
                // System.out.println("key val in comparison is " + map.get(key));
                // keys.add(key);
                curMin = map.get(key);
                curKey = key;
                // map_size--;
            }       
        }
        if (map.size() < 4) {
            // System.out.println("key to remove is " + curKey);
        }
        return curKey;
    }
    static String removeDup(String sb) {
        int cur_sz = sb.length();
        Character cur_ch = '\0';
        for (int i = 0; i < cur_sz; i++) { // removes dups
            for (int j = i; j < cur_sz; j++) {
                // inc num of occurrences of char
                // int num = (map.get(sb.charAt(j)) == null) ? 1 : (map.get(sb.charAt(j)) + 1);
                // map stores char and num of occurrences
                // map.put(sb.charAt(j), num); 
                if ((j < cur_sz -1) && sb.charAt(j) == sb.charAt(j+1)) {    
                    cur_ch = sb.charAt(j); // get cur_ch
                    sb = sb.replace(Character.toString(cur_ch), "");
                    cur_sz = sb.length(); // gets sz of str after removing repeated ch
                    // map.remove(cur_ch); // removes repeated ch from map
                }
            }
        }
    }
    // Complete the twoCharaters function below.
    static int twoCharaters(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        String sb = s;
        Character cur_ch = '\0';
        int cur_sz = sb.length();
        // StringBuilder sb = new StringBuilder(s);
        
        String sb = removeDup(sb);
        Map<Character, Integer> map = new HashMap<>();
        int num = (map.get(sb.charAt(i)) == null) ? 1 : (map.get(sb.charAt(i)) + 1);
        for (int i = 0; i < sb.length(); i++) {
            map.put(sb.charAt(i), num); 
        }
        int k = 0;
        char[] keys= new char[map.size()+1];
        int mapSz = map.size();       
        while (mapSz > 2) {     
            keys[k] = getKey(map);
            map.remove(keys[k]); // removing val from map immediately after finding it to be of least occurrence
            k++;
            mapSz--;
            // System.out.println("mapSz is " + mapSz);
            // System.out.println("key in returned getKey is " + keys[j-1]);
        }
        cur_sz = sb.length();
        for (Character c : keys) {
            // System.out.println("sb sz is " + sb.length());
            sb = sb.replace(Character.toString(c), "");  
            // System.out.println("c is " + Character.toString(c) + " sb is " + sb);
        }
        // System.out.println(sb);
        
        return sb.length();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = twoCharaters(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

*/

