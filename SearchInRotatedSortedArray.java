public class SearchInRotatedSortedArray {

    public static int search_in_rotated_sorted_array(int nums[] , int target){
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int m = l + (r-l)/2;
            if(nums[m] == target){
                return m;
            }
            // Determine which half is sorted
            else if(nums[l] <= nums[m]){ // left half is sorted
                if(nums[l] <= target && target < nums[m]){
                    r = m-1;
                }else{
                    l = m+1;
                }
            }
            // right half is sorted
            else{
                if(target <= nums[r] && target > nums[m]){
                    l = m +1;
                }else{
                    r = m-1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int nums[] = {4,5,6,7,0,1,2};
        int target = 7;
        System.out.println("Index of target element: " + search_in_rotated_sorted_array(nums,target));
    }
}
