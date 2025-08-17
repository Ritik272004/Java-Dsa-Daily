// import java.util.*;

public class HappyNumber {
    /*What is a Non-Cyclical Number or Happy Number?
A non-cyclical number is defined by an iterative process where you repeatedly replace a number with the sum of the squares of its digits. The process ends in one of two ways:

The number eventually equals 1 (making it a non-cyclical number).
The number falls into a repetitive cycle that does not include 1.
If the process stops at 1, the number is classified as non-cyclical. Otherwise, it is cyclical. */

    public static boolean check_happy_number(int n){
        // 1. Brute Force Approach , O(logn) ,O(logn)
    //     Set<Integer> visit = new HashSet<>();

    //     while(!visit.contains(n)){
    //         visit.add(n);
    //         n = sumOfSquares(n);
    //         if( n == 1){
    //             return true;
    //         }
    //     }
    //     return false;
    // }
    // public static int sumOfSquares(int n){
    //     int output = 0;
    //     while(n > 0){
    //         int digit = n % 10;
    //         digit = digit * digit;
    //         output += digit;
    //         n/=10;
    //     }
    //     return output;


    // 2. Floyd Cycle Detection or Slow-fast pointer approach (O(logn) ,O(1))
        int slow = n; // this pointer moves only 1 step in each loop
        int fast = sumOfSquares(n); // this pointer moves 2 steps in each loop

        while(slow != fast){
            fast = sumOfSquares(fast);
            fast = sumOfSquares(fast);
            slow = sumOfSquares(slow);
        }
        return fast == 1;
    }
    public static int sumOfSquares(int n){
        int output = 0;
        while(n != 0){
            output += (n % 10) * (n % 10); 
            n/=10;
        }
        return output;
    }
    public static void main(String[] args) {
        int n = 19;
        System.out.println("Is It Happy Number: " + check_happy_number(n));
    }
}
