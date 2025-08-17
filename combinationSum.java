import java.util.*;

public class combinationSum {
    public static List<List<Integer>> combination_sum_by_backtracking(int nums[] , int target , List<List<Integer>> res , List<Integer> curr , int i ){
        // Everytime , we subtract nums[i] from target(update target) to check how much sum is left to reach original target
        // When target become 0 we add curr combination to res list

        // base case
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return res;
        }
        if(target < 0 || i>= nums.length){ // It is the case when last added element is subtracted from target , target becomes negative or when i becomes equal to length of nums(means combination sum doesn't give original target) . In this case move to next index element
            return res;
        }

        curr.add(nums[i]);
        // use same index many times as you need
        combination_sum_by_backtracking(nums, target-nums[i], res, curr, i);
        // backtracking step 
        curr.remove(curr.size()-1);
        // Move to next index to make suitable combination
        combination_sum_by_backtracking(nums, target, res, curr, i+1);

        return res;

    }
    public static void main(String[] args) {
        int nums[] = {2,3,6,7} ; 
        int target = 7;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> finalRes = combination_sum_by_backtracking(nums,target,res,curr,0);
        System.out.println(finalRes);
    }
}
