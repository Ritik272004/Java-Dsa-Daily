
import java.util.*;
public class threeSum {
    /*Given an array of integers, nums, find all unique sets of three numbers [nums[i],nums[j],nums[k]] that add up to zero (nums[i]+nums[j]+nums[k]=0).
    Make sure each number in a triplet has a different index, and the result should not include duplicate triplets. You can return the triplets in any order. */
    public static List<List<Integer>> three_sum(int nums[]){
        // 1. Brute Force Approach => O(n^3) , O(n)
        // Set<List<Integer>> set = new HashSet<>();
        // Arrays.sort(nums); // sort array to avoid duplicate
        // // set use .equals() to compare two lists. for eg: [-1,0,1] , [1,0,-1] ->  .equals() return false for these two lists because order of elements are mattered. 
        // // So to avoid set to contain both of these lists we sort array firstly
        // for(int i =0;i<nums.length;i++){
        //     for(int j =i+1;j<nums.length;j++){
        //         for(int k= j+1 ;k<nums.length;k++){
        //             if(nums[i] + nums[j] + nums[k] == 0){
        //                 set.add(Arrays.asList(nums[i],nums[j],nums[k])); 
        //             }
        //         }
        //     }
        // }
        // return new ArrayList<>(set);

        // 2. 2-pointer approach O(n^2) , O(1)
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        // In 2 - pointer approach we fix first first element and get another two elements using 2 pointers
        for(int i =0;i<nums.length;i++){
            if(nums[i] > 0) break;
            // check for dupliacte
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int l = i+1 , r = nums.length-1;
            while(l<r){
                int sum = nums[i]+nums[l]+nums[r];
                if(sum == 0){
                    list.add(Arrays.asList(nums[i] , nums[l] , nums[r]));
                    l++;
                    r--;
                    while(l<r && nums[l] == nums[l-1]){
                        l++;
                    }
                }
                else if(sum<0){
                    l++;
                }
                else{
                    r--;
                }
            }
        }
        return new ArrayList<>(list);
    }
    public static void main(String[] args) {
        int nums[] = {-1,0,1,2,-1,-4};
        List<List<Integer>> resList = three_sum(nums);
        for(int i =0;i<resList.size();i++){
            System.out.print(resList.get(i)+" ");
        }
        System.out.println();

        
    }
}
