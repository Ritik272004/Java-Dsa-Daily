import java.util.HashMap;

public class LongestRepeatingCharcaterReplacement {
    /*Finding Longest Repeating Character Replacement Problem
You are given a string s that contains only uppercase English letters and an integer k. Your task is to determine the length of the longest substring in s that can consist of just one distinct character(all characters are same) after modifying the string.

You are allowed to make up to k replacements, where each replacement involves changing any character in the substring to another uppercase English letter.

The goal is to maximize the length of this uniform substring by carefully choosing which characters to replace while staying within the limit of k changes. */
    public static int longest_substring_repeating_character(String s , int k){
        // Sliding - window method 
        // Use Map to store count of each character 
        // Also store maximum frequnecy means count of most frequent character
        // If window size - maxFreq > k  , then move left pointer to change window size
        HashMap<Character , Integer> count = new HashMap<>();
        int l = 0;
        int res = 0 , maxFreq = 0;
        for(int r = 0;r<s.length();r++){
            count.put(s.charAt(r) , count.getOrDefault(s.charAt(r) , 0)+1);
            maxFreq = Math.max(maxFreq , count.get(s.charAt(r)));
            while((r - l +1) - maxFreq > k){
                count.put(s.charAt(l) , count.get(s.charAt(l))-1);
                l++;
            }
            res = Math.max(res , r-l+1);
        }
        return res;
    }
    public static void main(String[] args) {
        String str = "AAABABB";
        int k =1;
        int res = longest_substring_repeating_character(str , k);
        System.out.println(res);
    }
}
