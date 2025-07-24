

public class ValidPalindrome {
    // 1. Simple Method(it doesn't handle String if it contains non-alphaNumeric Characters)
    public static boolean isValidPalindrome(String str){
        // for(int i =0;i<str.length()/2;i++){
        //     if(str.charAt(i) != str.charAt(str.length()-i-1)){
        //         return false;
        //     }
        // }
        // return true;

    /*Program to check Valid Palindrome – Medium Level
        Given a string s, return true if it is a palindrome, otherwise return false.
        A palindrome is a string that reads the same forward and backward. It is also case-insensitive and ignores all non-alphanumeric characters. 
    */
    // 2. Two Pointer Approach O(n) , O(1)
    int l = 0 , r = str.length()-1;
    
    while(l<r){ // T.C is O(n) because each character is traverse only one time
        while(l<r && !alphaNum(str.charAt(l))){
            l++;
        }
        while(r>l && !alphaNum(str.charAt(r))){
            r--;
        }
        if(Character.toLowerCase(str.charAt(l)) != Character.toLowerCase(str.charAt(r))){
            return false;
        }
        l++;
        r--;
    }
    return true;
    }
    public static boolean alphaNum(char c){
        return (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z' || c >= '0' && c <= '9');
    }
    public static void main(String[] args) {
        // String str1 = "madam";
        String str = "Was it a car or a cat I saw?";
        System.out.println(str.length());
        System.out.println(isValidPalindrome(str));
    }
}
