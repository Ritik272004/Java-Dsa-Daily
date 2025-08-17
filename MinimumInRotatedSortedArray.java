

public class MinimumInRotatedSortedArray {
    public static int minimum_in_rotated_sorted_array(int nums[]){
        // 1. Brute Force Approach , O(n) ,O(1)
        // return Arrays.stream(nums).min().getAsInt();

        // 2. Binary Search Method O(logn) , O(1)

        int l = 0;
        int r = nums.length-1;
        int ans = nums[0];
        while(l<=r){
            if(nums[l] <= nums[r]){ // It means entire range is sorted so first element is the minimum element.
                ans = Math.min(ans,nums[l]);
                break;
            }

            int m = l + (r-l) / 2; // formula avoids Integer overflow

            // Determine which half is sorted
            if(nums[l] <= nums[m]){ /* It means left half is sorted(minimum is nums[l] in l to m range) , so min is in the right half because If one half is sorted and the other half’s last element is smaller than the sorted half’s smallest element,
→ the minimum is in the other sorted half (here, the right side).*/
                l = m +1;
            }else{ // It means right half is sorted , so min is in left half
                r = m-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int nums[] = {4,5,6,7,0,1,2};
        System.out.println("Minimum is Array is : " + minimum_in_rotated_sorted_array(nums));
    }
}
