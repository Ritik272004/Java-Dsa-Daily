import java.util.*;

public class subset2LeetCode {

    public static List<List<Integer>> subsets_two_problem(List<Integer> nums,Set<List<Integer>> res, List<Integer> tempList , int i){
        // base case
        if(i == nums.size()){
            res.add(new ArrayList<>(tempList)); 
           return new ArrayList<>(res);
        }
        tempList.add(nums.get(i));
        subsets_two_problem(nums, res, tempList, i+1);
        // common backtracking step
        tempList.remove(tempList.size()-1);
        subsets_two_problem(nums, res, tempList, i+1);
        return new ArrayList<>(res);
    }
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(1);
        nums.add(2);
        Collections.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> tempList = new ArrayList<>();
        List<List<Integer>> finalResList = subsets_two_problem(nums,res,tempList,0);
        System.out.println(finalResList);
    }
}

/*Time Complexity : Copy a list of size n take O(n) time and we have total 2^n subsets(beacuse for each element we have two choices include or exclude)
 * Copy a list is called for each subset . Therefore , time complexity is O(n*2^n) 
 * Space Complexity is : O(n)
 */
