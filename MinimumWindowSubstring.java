
import java.util.*;

public class MinimumWindowSubstring {
    /*Program for Smallest Substring in a string that contains all the characters of another string Problem
    You are given two strings, s and t. Your task is to find the smallest substring in s that contains all the characters of t, including their respective frequencies (i.e., duplicates must also be accounted for).
    If no such substring exists, return an empty string (“”). You can assume that, if a valid substring exists, it will always be unique, meaning there won’t be multiple shortest substrings satisfying the condition. */

    public static String smallest_substring_contain_characters_of_t(String s , String t){
        // sliding - window method => O(n) , O(m) where n is the length of String s and m is the no. of unique characters in string t , s.
        if(t.length() == 0) return " ";
        HashMap<Character , Integer> countT = new HashMap<>(); // store characters in t and their respective frequency
        HashMap<Character , Integer> window = new HashMap<>(); // store characters andd their frequency from current window

        for(int i = 0;i<t.length();i++){
            countT.put(t.charAt(i) , countT.getOrDefault(t.charAt(i) , 0) + 1);
        }
        int l = 0; // helpful in shrinking
        int have = 0 ; // how many unique characters match required characters
        int need = countT.size() ; // how many total unique characters are required.
        int resLen = Integer.MAX_VALUE;
        int res[] = {-1,-1};
        for(int r = 0;r<s.length();r++){
            window.put(s.charAt(r) , window.getOrDefault(s.charAt(r) , 0) +1);
            if(countT.containsKey(s.charAt(r)) && window.get(s.charAt(r)).equals(countT.get(s.charAt(r)))){
                have++;
            }
            while(have == need){
                if((r-l+1) < resLen){
                    resLen = r-l+1;
                    res[0] = l;
                    res[1] = r;
                }
                // Start shrinking beacuse we want smallest substring
                window.put(s.charAt(l) , window.get(s.charAt(l)) -1);
                if(countT.containsKey(s.charAt(l)) && window.get(s.charAt(l)) < countT.get(s.charAt(l))){
                    have--;
                }
                l++;
            }
        }
        return resLen == Integer.MAX_VALUE ? " " : s.substring(res[0] , res[1]+1);
    }
    public static void main(String[] args) {
        String s = "OUZODYXAZV"; 
        String t = "XYZ";
        String resStr = smallest_substring_contain_characters_of_t(s,t);
        System.out.println(resStr);

    }
}
