import java.util.*;

public class PalindromePartitioning {
    /*Palindrome Partitioning Leetcode Problem :
Given a string s, partition s such that every substring of the partition is a palindrome . Return all possible palindrome partitioning of s.

Example :
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]] explain the problem briefly 

Time Complexity is : O(n*2^n-1) , The number of ways to partition a string of length n is 2^(n-1) (because there are n-1 possible cut positions, and each can be a cut or not).
We check if each substring is a palindrome inside isPalindrome, which takes:
O(n)

*/

    public static List<List<String>> palindromePartitioning(String s){
        List<List<String>> res = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        backTrack(s,0,curr,res);
        return res;
    }
    public static void backTrack(String s , int start , List<String> curr , List<List<String>> res ){
        // base case
        if(start == s.length()){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int end = start ; end<s.length();end++){
            if(isPalindrome(s,start,end)){
                curr.add(s.substring(start , end+1));
                backTrack(s, end+1, curr, res);
                // Backtracking Step
                curr.remove(curr.size()-1);
            }
        }
    }
    public static boolean isPalindrome(String s , int left , int right){
        while(left<right){
            if(s.charAt(left) != s.charAt(right)) return false;

            left ++;
            right --;
        }
        return true;
    }

    public static void main(String args[]){
        String s = "aab";
        List<List<String>> res = palindromePartitioning(s);
        System.out.println(res);
    }
}
