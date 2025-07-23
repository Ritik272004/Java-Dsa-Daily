
import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int arr[] , int target){
        // 1. Brute force approach => T.C = O(n^2)
        // for(int i =0;i<arr.length;i++){
        //     for(int j = i+1 ;j<arr.length;j++){
        //         if(arr[i] + arr[j] == target){
        //             return new int[]{i,j};
        //         }
        //     }
        // }
        // return new int[0];




        // 2. Sorting Method => T.C = O(nlogn)

        // int A [][] = new int [arr.length][2]; // 2-d Array , 1st column store the values and next column store the index
        // for(int i=0;i<arr.length;i++){
        //     A[i][0] = arr[i];
        //     A[i][1] = i;
        // }
        // Sort the array , to sort 2-d array we use comparator
        // Arrays.sort(A,Comparator.comparingInt(a -> a[0])); // It will sort the array on the basis of value

        // Use two pointer approach now

        // int i = 0 , j = arr.length-1;

        // while(i<j){
        //     int curr = A[i][0] + A[j][0];

        //     if(curr == target){
        //         return new int[]{Math.min(A[i][1] , A[j][1]) , Math.max(A[i][1] , A[j][1])};
        //     }

        //     else if(curr < target){
        //         i++;
        //     }
        //     else{
        //         j--;
        //     }

        // }
        // return new int[0];

        // 3. HashMap Method => T.C = O(n)
        HashMap<Integer , Integer> map = new HashMap<>();

        for(int i =0;i<arr.length;i++){
            map.put(arr[i] , i);
        }
        for(int i =0;i<arr.length;i++){
            int diff = target - arr[i];
            if(map.containsKey(diff) && map.get(diff) != i){
                return new int[]{i,map.get(diff)};
            }
        }
        return new int[0];
    }
    public static void main(String[] args) {
        int arr[] = {4,5,2,1,6,7};
        int b[] = twoSum(arr, 8);

        for(int i =0;i<b.length-1;i++){
            System.out.print("["+b[0]+","+b[1]+"]");
        }
        System.out.println();
    }
}
