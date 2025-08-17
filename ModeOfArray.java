import java.util.*;

public class ModeOfArray {

    public static int find_mode(int nums[]){
        Map<Integer , Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num , map.getOrDefault(num, 0) + 1);
        }

        int mode = nums[0];
        int maxCount = 0;

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > maxCount){
                mode = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        return mode;
    }
    public static void main(String[] args) {
        int nums[] = {1,4,2,3,1,4,2,2,5,5,1,1,4,6,8,2,1,4};
        System.out.println("Mode of arrays is : " + find_mode(nums));
    }
}
