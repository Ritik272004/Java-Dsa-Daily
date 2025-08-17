import java.util.*;

public class subsetLeetCode {
    public static List<List<Integer>> subsets_by_backtracking(List<List<Integer>> res,List<Integer> nums , List<Integer> tempRes , int i){
        // O(n) , O(n)
        // base case
        if(i == nums.size()){ 
            res.add(new ArrayList<>(tempRes));
            return res;
        }
        tempRes.add(nums.get(i));
        subsets_by_backtracking(res, nums, tempRes, i+1);
        // backtraking steps
        tempRes.remove(tempRes.size()-1);
        subsets_by_backtracking(res, nums, tempRes, i+1);

        return res;

    }
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(); 
        nums.add(1);
        nums.add(2);
        nums.add(3);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempRes = new ArrayList<>();
        List<List<Integer>> finalRes = subsets_by_backtracking(res ,nums , tempRes , 0 );
        System.out.println(finalRes);

    }
}
