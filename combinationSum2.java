import java.util.*;

public class combinationSum2 {
    /*📘 Problem Statement (Simplified)
            You're given:
            An array of integers candidates[] (can have duplicates).
            A target integer target.
            🎯 Goal:
            Find all unique combinations of numbers from candidates[] that add up to the target.
            Rules:
            Each number in the array can be used only once per combination.
            The output must not contain duplicate combinations.
            The numbers in a combination can be in any order. 
    */

    static List<List<Integer>> res = new ArrayList<>();
    static Map<Integer,Integer> count = new HashMap<>();

    public static List<List<Integer>> combinationSumTwo(int nums[] , int target){
        List<Integer> curr = new ArrayList<>();
        List<Integer> A = new ArrayList<>(); // store unique numbers of nums array

        for(int num : nums){
            if(!count.containsKey(num)){
                A.add(num);
            }
            count.put(num , count.getOrDefault(num , 0) + 1);
        }

        backTrack(A,target,curr,0);
        return res;
    }

    public static void backTrack(List<Integer> nums , int target , List<Integer> curr , int i ){
        if(target == 0){
        res.add(new ArrayList<>(curr));
        return;
        }

        if(target < 0 || i >= nums.size()){
            return;
        }

        if(count.get(nums.get(i)) > 0){
            curr.add(nums.get(i));
            count.put(nums.get(i)  , count.getOrDefault(nums.get(i) , 0) - 1);//decrease count
            backTrack(nums, target-nums.get(i), curr, i);
            curr.remove(curr.size()-1);// backtrack step
            count.put(nums.get(i)  , count.getOrDefault(nums.get(i) , 0) + 1);// restore count
        }
        backTrack(nums, target, curr, i+1); // move to next index
    }

    public static void main(String[] args) {
        int nums[] = {1,1,2};
        int target = 3;
        List<List<Integer>> finalRes = combinationSumTwo(nums,target);
        System.out.println(finalRes);
    }
}
