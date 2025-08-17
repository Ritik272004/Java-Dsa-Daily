
import java.util.Arrays;

public class MedianOfTwoSortedArray {
    public static double find_median_of_two_sorted_arrays(int a[] , int b[]){
         // 1. Using Brute Force Approach , O((n+m)*log(n+m)) , O(n+m) where n is size of 1 array and m is size of 2nd array
        // int n = a.length;
        // int m = b.length;
        // int [] merged = new int[n+m];
        
        // // Copy both the arrays
        // System.arraycopy(a,0,merged,0,n); // System.arraycopy(source array,start index in source , destination array, start index in destination , number of elements to copy)4
        // System.arraycopy(b,0,merged,n,m);

        // Arrays.sort(merged);

        // int total = merged.length;

        // // odd case (0-based indexing)
        // if(total % 2 != 0){
        //     return merged[total/2]; 
        // }
        // // even case
        // else{
        //     return (merged[total/2-1] + merged[total/2]) /2.0;
        // }

        // 2. Binary Search method , In this approach we find median of combined sorted arrays without actually merging them , o(log(min(n,m)))

        int n = a.length;
        int m = b.length;

        // We apply binary search on smaller array so that search space is minimum
        if ( n > m){
            return find_median_of_two_sorted_arrays(b, a);
        }

        // Now apply binary search in range [0,n] in a[]

        int lo = 0;
        int hi = n;

        while(lo<=hi){
            int mid1 = (lo+hi)/2; // mid1 is binary search cut in a . It means a's left is [0...mid-1] and a's right is [mid1...n-1]

            int totalLeft = (n+m+1)/2; // why this ? So that left halves of both arrays contains exactly the half of total elements(if total is odd , left contain 1 extra)

            int mid2 = totalLeft - mid1; // cut in b

            // maximum in a's left
            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : a[mid1-1];
            // minimum in a's right
            int r1 = (mid1 == n) ? Integer.MAX_VALUE : a[mid1];

            // maximum in b's left
            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : b[mid2-1];
            // minimum in b's right
            int r2 = (mid2 == m) ? Integer.MAX_VALUE : b[mid2];

            // Valid partititon

            if(l1<=r2 && l2<=r1){
                // if total elements is even then median is average of two middle elements
                if((n+m) % 2 == 0){
                    return (Math.max(l1,l2) + Math.min(r1,r2)) / 2.0;
                }
                // if total elements is odd median is middle element
                else{
                    return Math.max(l1,l2);
                }
            }

            if(l1 > r2){// left side from a is too large , move cut left decrease mid1
                hi = mid1-1;
            }

            else{ // left side from a is too small . move cut right increase mid1
                lo = mid1+1;
            }

        }

        return 0;
    }
    public static void main(String[] args) {
        int a[] = {1,12,16,26,38};
        int b[] = {2,13,17,30,45,65};
        System.out.println("Median of two arrays : " + find_median_of_two_sorted_arrays(a,b));
    }
}
