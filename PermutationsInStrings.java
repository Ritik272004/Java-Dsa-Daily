
import java.util.*;

public class PermutationsInStrings {
    /*Program to solve Permutation in a given String Problem
You are given two strings, s1 and s2, which only contain lowercase letters.

Your task is to determine if any permutation of string s1 can be found as a substring within string s2. 

In other words, you need to check if there exists a rearranged version of s1 that appears as a contiguous part of s2. If such a permutation exists, return true; otherwise, return false. */

public static boolean check_permutation(String s1 , String s2){
    // 1. Brute force approach => O(n^3logn) ,O(1)
    // if(s1.length() > s2.length()){
    //     return false;
    // }
    // // Sort s1 string
    // char [] s1charArray = s1.toCharArray();
    // Arrays.sort(s1charArray);
    // String sortedS1 = new String(s1charArray); // O(n)
    // for(int i =0;i<s2.length();i++){
    //     for(int j =i;j<s2.length();j++){
    //         char [] s2substringcharArray = s2.substring(i,j+1).toCharArray();
    //         Arrays.sort(s2substringcharArray);
    //         String sortedS2 = new String(s2substringcharArray);
    //         if(sortedS1.equals(sortedS2)){
    //             return true;
    //         }
    //     }
    // }
    // return false;

    // Best Method for this is : Sliding - Window Method => O(n) , O(1)
    if(s1.length() > s2.length()){
        return true;
    }
    int countS1 [] = new int[26];
    int countS2 [] = new int[26];

    for(int i =0;i<s1.length();i++){
        countS1[s1.charAt(i) - 'a']++;
        countS2[s2.charAt(i) - 'a']++;
    }
    if(Arrays.equals(countS1 , countS2)){
        return true;
    }
    for(int i =s1.length() ; i<s2.length();i++){
        // remove one character from start
        countS2[s2.charAt(i-s1.length()) - 'a']--;
        // add one new character from back
        countS2[s2.charAt(i) - 'a']++;
        if(Arrays.equals(countS1, countS2)){
            return true;
        }
    }
    return false;
}
    public static void main(String[] args) {
        String s1 = "abc", s2 = "lecabee";
        System.out.println(check_permutation(s1,s2));
    }
}
