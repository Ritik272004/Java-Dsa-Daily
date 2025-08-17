import java.util.*;

public class LongestSubStringWithoutRepeating {
    /*Finding Longest Substring Without Repeating Characters
Given a string s, your task is to find the length of the longest substring that contains only unique characters, meaning no character repeats within this substring.

A substring is defined as a continuous block of characters within the string, and it must maintain the original order of characters.

For example, in the string “abcabcbb”, the longest substring without repeating characters is “abc”, which has a length of 3. */

    public static int longest_substring_without_repeat(String str){
        // Sliding Window Method  => O(n) , O(m) ( n is the length of String , m is the no. of unique characters in Set)
        /*Use two pointers to create a dynamic window that adjusts based on character repetition. Slide the window by removing characters from the start until all characters in the current window are unique. */

        Set<Character> charSet = new HashSet<>();
        int l = 0; 
        int res = 0;

        for(int r=0;r<str.length();r++){
            while(charSet.contains(str.charAt(r))){
                charSet.remove(str.charAt(l));
                l++; // move left pointer until duplicate is gone
            }
            charSet.add(str.charAt(r));
            res = Math.max(charSet.size() , res);
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "zxyxzyyx";
        int res = longest_substring_without_repeat(s);
        System.out.println(res);
    }
 
}
