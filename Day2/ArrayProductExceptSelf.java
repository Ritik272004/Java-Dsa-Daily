public class ArrayProductExceptSelf {
    /*Given an integer array nums, return an array output where output[i] is the product of all the elements of nums except nums[i]. */
    public static int[] product_of_array_except_self(int nums[]){ // O(n^2) , O(1)
        // int n = nums.length;
        // int res[] = new int[n];

        // for(int i =0;i<n;i++){
        //     int prod = 1;
        //     for(int j =0;j<n;j++){
        //         if(i!=j){
        //             prod *= nums[j];
        //         }
        //     }
        //     res[i] = prod;
        // }

        // return res;

        int n = nums.length;
        int res[] = new int[n];
        int prefix[] = new int[n];
        int suffix[] = new int[n];

        prefix[0] = 1;
        suffix[n-1] = 1;

        for(int i = 1;i<n;i++){
            prefix[i] = nums[i-1] * prefix[i-1];
        }

        for(int i = n-2;i>=0;i--){
            suffix[i] = nums[i+1] * suffix[i+1];
        }

        for(int i =0;i<n;i++){ 
            res[i] = prefix[i] * suffix[i];
        }
        return res;
    }
    public static void main(String[] args) {
        int nums[] = {1,2,4,6};
        int res[] = product_of_array_except_self(nums);
        for(int i =0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
        System.out.println();
    }
}
