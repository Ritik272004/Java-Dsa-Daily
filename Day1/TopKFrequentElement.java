import java.util.*;
public class TopKFrequentElement {

    public static int[] topKFrequent(int arr[] , int k){
        // 1. Sorting Method => T.C -> O(nlogn) , S.C -> O(n)
        // HashMap<Integer , Integer> count = new HashMap<>();
        // for(int i=0;i<arr.length;i++){
        //     count.put(arr[i] , count.getOrDefault(arr[i] , 0)+1); // count map store key-value pairs , where key is array element and value is its frequency
        // }

        // ArrayList<int[]> list = new ArrayList<>(); // List of arrays

        // for(Map.Entry<Integer , Integer> entry : count.entrySet()){ // count.entrySet() -> gives all key value pairs from the map , Map.Entry(Integer , Integer) hold one such key-value pair
        //     int freq = entry.getValue();
        //     int val = entry.getKey();
        //     list.add(new int[] {freq,val});
        // }

        // list.sort((a,b) -> b[0] - a[0]); // sort in descending order (if b[0] - a[0] > 0 (positive) then b comes before a , if b[0] - a[0] < 0 (negative) then a stays before b  )


        // int res [] = new int[k];

        // for(int i =0;i<k;i++){
        //     res[i] = list.get(i)[1];
        // }
        // return res;
    
    // 2. Heap Method => T.C -> O(nlogk) , S.C -> O(n) , where k is the top k frequent elements
    // In this we use Priority Queue which is Heap based Data Structure

    HashMap<Integer , Integer> count = new HashMap<>();
    for(int i =0;i<arr.length;i++){
        count.put(arr[i] , count.getOrDefault(arr[i] , 0)+1);
    }

    PriorityQueue<int []> heap = new PriorityQueue<>((a,b)->a[0]-b[0]); // by default Priority Queue is min-heap.

    for(Map.Entry<Integer , Integer> entry : count.entrySet()){
        heap.offer(new int[]{entry.getValue() , entry.getKey()}); // heap.offer() -> add elements into PriorityQueue
        if(heap.size() > k){
            heap.poll(); // It removes head element from Queue
        }
    }

    int res[] = new int[k];

    for(int i =0;i<k;i++){
        res[i] = heap.poll()[1];
    }

    return res;

    }
    public static void main(String[] args) {
        int arr[] = {1,2,2,3,3,3} , k = 2;
        int sol[] = topKFrequent(arr , k);
        for(int i =0;i<sol.length;i++){
            System.out.print(sol[i] + " ");
        }
        System.out.println();
    }
}
