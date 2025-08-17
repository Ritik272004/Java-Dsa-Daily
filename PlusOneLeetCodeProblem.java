import java.util.*;

public class PlusOneLeetCodeProblem {
    /*Plus One Leetcode Problem :
You are given a large integer represented as an integer array digits, where each digits[i] is the i th digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0’s.

Increment the large integer by one and return the resulting array of digits.

Example :
Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123. Incrementing by one gives 123 + 1 = 124. Thus, the result should be [1,2,4]. */

    public static List<Integer> plus_one(List<Integer> digits){
        // At start digits = [9,9,9]

        int n = digits.size();
        digits.set(n-1,digits.get(n-1)+1); // Last digit = 9 + 1 =10 , digits=[9,9,10]
        for(int i = n-1;i>=0;i--){
            if(digits.get(i) == 10){
                digits.set(i , 0);
                if(i-1>=0){
                    digits.set(i-1,digits.get(i-1)+1);
                }else{
                    digits.add(0);
                    digits.set(0,digits.get(0)+1);
                }
            }
        }
        return digits;
    }
    public static void main(String[] args) {
        List<Integer> digits = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Add Elements into list");
        for(int i =0;i<3;i++){
            digits.add(sc.nextInt());
        }
        List<Integer> finalRes = plus_one(digits);
        System.out.println("Resultant output is : " + finalRes);
    }
}
