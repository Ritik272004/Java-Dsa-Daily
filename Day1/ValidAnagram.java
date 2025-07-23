import java.util.*;

public class ValidAnagram {
    public static boolean check_for_anagram(String p , String q){
        // Two Strings are anagram if they contain same character but arranged differently
        // 1. Sorting Method => T.C = O(nlogn)
        // if(p.length() != q.length()){
        //     return false;
        // }
        // String m = p.toLowerCase();
        // String n = q.toLowerCase();

        // char [] sortedM = m.toCharArray();
        // char [] sortedN = n.toCharArray();

        // Arrays.sort(sortedM);
        // Arrays.sort(sortedN);

        // return Arrays.equals(sortedM , sortedN); // It will return true if both arrays contain same no. of charactes at same index.

        // 2. HashMap Method => T.C = O(n)
        // This method count the ocurrence of each character in both Strings using Hash Table. If it is same then , return true

        if(p.length() != q.length()){
            return false;
        }

        String m = p.toLowerCase();
        String n = q.toLowerCase();

        HashMap<Character , Integer> map1 = new HashMap<>();
        HashMap<Character , Integer> map2 = new HashMap<>();

        for(int i =0;i<m.length();i++){
            map1.put(m.charAt(i) , map1.getOrDefault(m.charAt(i), 0) + 1 ); // if map.getOrDefault(char , 0) , this means if character already exist in map then get its count . If not , then use 0 as default.
            map2.put(n.charAt(i) , map2.getOrDefault(n.charAt(i), 0) + 1 );
        }
       return map1.equals(map2);  
    }
    public static void main(String[] args) {
        String str1 = "silent";
        String str2 = "LISTEN";
        System.out.println(check_for_anagram(str1, str2));
    }
}
