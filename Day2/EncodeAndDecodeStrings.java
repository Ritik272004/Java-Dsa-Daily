
import java.util.*;

public class EncodeAndDecodeStrings {
   /*You are given a list of strings (e.g., ["leet", "code", "love", "you"]), and you need to:
    Encode them into a single string.
    Then be able to decode that single string back to the original list of strings. */ 

    public static String encodeString(ArrayList<String> strs){ // O(n)
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();
    }
    public static ArrayList<String> decodedStrings(String str){ // O(n)
        // 2-pointer approach
        ArrayList<String> res = new ArrayList<>();
        int i = 0;
        while(i<str.length()){
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }
            int length = Integer.parseInt(str.substring(i,j)); // convert String to Integer like "4" -> 4
            i = j+1;
            j = i+length;
            res.add(str.substring(i,j));
            i = j;
        }
        return res;
    }
    // S.C for both of them is O(L) , where L is the total no. of characters in each String.

    public static void main(String[] args) {
        ArrayList<String> strs = new ArrayList<>();
        strs.add("leet");
        strs.add("code");
        String encodedString = encodeString(strs);
        System.out.println(encodedString);
        ArrayList<String> res = decodedStrings(encodedString);
        for(int i =0;i<res.size();i++){
            System.out.print(res.get(i)+ " ");
        }
        System.out.println();
    }
}
