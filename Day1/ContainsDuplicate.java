
import java.util.*;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int arr[]){
        // 1. Brute force approach => T.C = O(n^2)
        // for(int i =0;i<arr.length;i++){
        //     for(int j =i+1;j<arr.length;j++){
        //         if(arr[i] == arr[j]){
        //             return true;
        //         }
        //     }
        // }
        // return false;

        // 2. Sorting method => T.C = O(nlogn)
        // Arrays.sort(arr);
        // for(int i =0;i<arr.length-1;i++){
        //     if(arr[i] == arr[i+1]){
        //         return true;
        //     }
        // }
        // return false;
        // 3. HashMap method => T.C = O(n)
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i =0;i<arr.length;i++){
            if(map.containsValue(arr[i])){
                return true;
            }
            map.put(i,arr[i]);
        }
        return false;
    }
    public static void main(String[] args) {
        int arr[] = {2,1,2,8,5,4};
        System.out.println(containsDuplicate(arr));
    }
}
