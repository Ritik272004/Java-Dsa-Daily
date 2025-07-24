
public class TwoSumSortedArray { // O(n) , O(1)
    public static int[] two_sum(int nums[] , int target){
        int l = 0, r = nums.length-1;
        while(l<r){
            int curr = nums[l] + nums[r];
            if(curr == target){
                return new int[]{l+1,r+1};
            }else if(curr < target){
                l++;
            }else{
                r--;
            }
        }
        return new int[0];
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int target = 7;
        int res[] = two_sum(arr,target);
        for(int i =0;i<res.length-1;i++){
            System.out.print("["+res[i]+","+res[i+1]+"]");
        }
    }
}
