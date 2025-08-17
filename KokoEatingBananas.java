
import java.util.Arrays;

public class KokoEatingBananas {
    /*You are given an array piles(karate of bananas), where each element piles[i] represents the number of bananas in the i-th pile. You also have h hours to eat all the bananas. You can choose an eating rate of k bananas per hour. In each hour, you can eat up to k bananas from one pile.

If a pile has fewer than k bananas, you finish that pile but cannot switch to another pile during the same hour.

Your task is to find the minimum value of k that allows you to eat all the bananas within h hours. */

    public static int rate_of_bananas_eated_per_hour(int piles[] , int h){
        // 1. Brute Force Approach , O(m*n) where m is the maximum no. of bananas in piles and n is the length of piles array.
        // int speed = 1;
        // while(true){
        //     int totalTime = 0;

        //     for(int pile : piles){
        //         totalTime += Math.ceil(pile/speed);
        //     }

        //     if(totalTime <= h){
        //         return speed;
        //     }
        //     speed++;
        // }

        // 2. Binary Search Method , O(n*log(m))
        // In this method we consider minimum speed ie. l = 1 and maximum speed ie. max(piles) 
        // After that we try middle speed if it works then we again search in left side beacuse may be smaller speed also exist that works fine.
        // If middle speed is too slow search in right side

        int l = 1; // minimum speed to eat bananas is eating 1 banana per hour
        int r = Arrays.stream(piles).max().getAsInt(); // (shortcut way to find maximum value of array) maximum speed to eat bananas and it is max(piles)
        int res = r;
        while(l<=r){
            int k = l + (r-l)/2; // try the middle speed
            int totalTime = 0;
            for(int pile : piles){
                totalTime += Math.ceil(pile / k); // ceil method is helpful if no. of bananas in pile is less than k , then still it takes 1 hour not jump to another pile
            }
            if(totalTime <= h){
                res = k;
                r = k-1; // search in left side because may be smaller speed also works
            }
            else{
                l = k+1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int piles[] = {5,4,3,2};
        int h = 9;
        System.out.println("Rate of Bananas : " + rate_of_bananas_eated_per_hour(piles,h));
    }
}
