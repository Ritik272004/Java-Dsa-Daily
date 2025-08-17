import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    /*Program to find Maximum of all subarrays of size K (Sliding Window Maximum) Problem
    You are provided with an array of integers, nums, and a positive integer, k. Imagine a sliding window of size k that begins at the far-left side of the array. 
    This window moves one position to the right at a time until it fully traverses the array, covering all possible subarrays of length k. 
    At each step of this sliding process, you need to identify and record the maximum element within the current window.
    Task is to return a list containing these maximum values for each position of the sliding window.
     */
    public static int[] sliding_window_maximum(int arr[] , int k){
        // 1. Brute Force Method => O(n^2) , O(1)
        // int n = arr.length;
        // int output[] = new int[n-k+1]; // output.length means total no. of subarrays having size k , if we move window by 1 step
        // for(int i =0;i<output.length;i++){
        //     int max = arr[i];
        //     for(int j = i ;j< i+ k ;j++){
        //         max = Math.max(arr[j] , max);
        //     }
        //     output[i] = max;
        // }
        // return output;
        // 2. Deque Method using Sliding Window => O(n) , O(n)
        int n = arr.length;
         // store indices of elements of current window
        Deque<Integer> q = new LinkedList<>(); 
        int l = 0 , r = 0;
        int output[] = new int[n-k+1];

        while(r<n){
            // We remove element from back of Deque , if they are smaller than arr[r]
            // Beacuse if arr[r] is larger , then smaller element can never give maximum in future windows.
            while(!q.isEmpty() && arr[q.getLast()] < arr[r]){
                q.removeLast();
            }
            q.addLast(r);
            if( l > q.getFirst()){ // This line is used whenever index at front of the deque is not inside current window.
                q.removeFirst();
            }
            if((r+1) >= k){ // we get one window
                output[l] = arr[q.getFirst()];
                l++;
            }
            r++;
        }
        return output;
    }
    public static void main(String[] args) {
       int arr[] = {1,2,1,0,4,2,6};
       int k = 3;
        int res[] = sliding_window_maximum(arr, k);
        for(int num : res){
            System.out.print(num+" ");
        }
        System.out.println();
    }
}
