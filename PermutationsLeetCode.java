import java.util.*;

public class PermutationsLeetCode {

    public static List<List<Integer>> find_permutation(List<Integer> numsList , List<Integer> curr ,  List<List<Integer>> res ){
        // base case
        if(numsList.isEmpty()){
            res.add(new ArrayList<>(curr));
            return res;
        }

        for(int i =0;i<numsList.size();i++){
            curr.add(numsList.get(i));
            List<Integer> remaining = new ArrayList<>(numsList);
            remaining.remove(i);
            find_permutation(remaining, curr, res);
            // backtracking step
            curr.remove(curr.size()-1);
        }
        return res;
    }
    public static void main(String[] args) {
        List<Integer> numsList = new ArrayList<>();
        numsList.add(1);
        numsList.add(2);
        numsList.add(3);

        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        List<List<Integer>> finalRes = find_permutation(numsList,curr,res);
        System.out.println(finalRes); 

    }
}
