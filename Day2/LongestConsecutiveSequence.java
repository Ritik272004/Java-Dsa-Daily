import java.util.*;
public class LongestConsecutiveSequence {
    /*Given an array of integers nums, return the length of the longest consecutive sequence of elements.
    A consecutive sequence is a sequence of elements in which each element is exactly 1 greater than the previous element */
    // 1. Brute Force Approach => O(n^2) , O(n)
     public static int longest_consecutive_sequence_length(int nums[]){
    //     // We want unique elements so we use Set 
    //     Set<Integer> set = new HashSet<>();
    //     for(int num : nums){
    //         set.add(num); // Set store element in any order
    //     }
    //     int longest = 0;
    //     // This method check every possible sequence starting from each element in the array to calculate longest possible sequence
    //     for(int num : nums){
    //         int streak = 0 , curr = num;
    //         while(set.contains(curr)){
    //             streak++;
    //             curr++;
    //         }
    //         longest = Math.max(longest , streak);
    //     }
    //     return longest;

    // 2. HashSet Method => O(n) , O(n)
    // In this method we only start counting sequence if current element is the begining element of the sequence means its previous element doesn't exist in the Set.
    Set<Integer> set = new HashSet<>();
    for(int num : nums){
        set.add(num);
    }
    int longest = 0;
    for(int num : nums){
        // Only start counting if number is the begining of sequence
        if(!set.contains(num-1)){
            int length = 1;
            while(set.contains(num+length)){
                length++;
            }
            longest = Math.max(longest , length);
        }
    }
    return longest;
    }
    public static void main(String[] args) {
        int nums[] = {0,3,2,5,4,6,1,1};
        int result = longest_consecutive_sequence_length(nums);
        System.out.println("Length of Longest Consecutive Sequence is : " + result);
    }
}
