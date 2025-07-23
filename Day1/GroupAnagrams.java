
import java.util.*;

public class GroupAnagrams {
    public static ArrayList<ArrayList<String>> groupAnagrams(String strs[]){
        // 1. Sorting Method => T.C = O(m*nlogn) , S.C = O(m*n) where m is the length of String array and n is the length of longest String
        // HashMap<String ,ArrayList<String>> map = new HashMap<>();
        // for(int i =0;i<strs.length;i++){
        //     char[] charArray = strs[i].toCharArray(); // O(n)
        //     Arrays.sort(charArray); // O(nlogn)
        //     String sortedS = new String(charArray); // O(n)
        //     /* How charArray changes to String 
        //      * Java provides a constructor in the String class like this: public String(char[] value)
        //         Takes a char[] (character array) as parameter.
        //         Converts it into a String by concatenating all characters in order
        //      */
        //     map.putIfAbsent(sortedS , new ArrayList<>()); // O(1)
        //     map.get(sortedS).add(strs[i]); // O(1)
        // }
        // return new ArrayList<>(map.values());

        // 2. HashMap Method => T.C = O(m*n) , S.C = O(m)

       HashMap<String ,ArrayList<String>> map = new HashMap<>();

       for(int i=0;i<strs.length;i++){
            String s = strs[i];

            int count[] = new int[26];
            char[] charArray = s.toCharArray();
            for(int j=0;j<charArray.length;j++){
                char c = charArray[j];
                count[c-'a']++;
            }
            String key = Arrays.toString(count);
            /*
             * For example, for "ate":
            'a' - 'a' = 0 → count[0]++
            't' - 'a' = 19 → count[19]++
            'e' - 'a' = 4 → count[4]++
            So the final array will be:
            [1, 0, 0, 0, 1, 0, ..., 1, ..., 0]   // 1 'a', 1 'e', 1 't'
            Arrays.toString(count) :  converts the int array to a String format, like:
            "[1, 0, 0, 0, 1, 0, 0, ..., 1, ..., 0]"
            */

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
       }

       return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        String strs[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
        ArrayList<ArrayList<String>> list = groupAnagrams(strs);
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }
}
