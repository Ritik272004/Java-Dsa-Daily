public class SearchInSorted2DMatrix {
    public static boolean search_in_matrix(int matrix[][] , int target){
        // 1. Stair Case Approach O(m+n) ,O(1) where m is no. of rows and n is no. of columns
        // In the above method we consider most important element one is top right corner element(matrix[0][n-1]) and other is bottom left corner element(matrix[m-1][0])
        // if we start from top right corner element , then situation is that the elements in its left is smaller then it amd elements in its down are larger then it.

        // int row = 0;
        // int col = matrix[0].length-1;
        // int arr[] = new int[2];


        // while(row < matrix.length && col >= 0){
        //     if(target < matrix[row][col]){
        //         col--;
        //     }
        //     else if(target > matrix[row][col]){
        //         row++;
        //     }
        //     else{
        //         arr[0] = row;
        //         arr[1] = col;
        //         return arr;
        //         // return true;
        //     }
        // }
        // return new int[]{-1,-1};
        // return false;

        // 2. Binary Search Method  O(log(m*n)) , O(1) where m is no. of rows and n is no. of columns
        // In this method we treat 2d-matrix as 1d sorted array of length rows*cols(m*n) . Then apply binary search on it.
        
        int rows = matrix.length;
        int cols = matrix[0].length;

        // 1-D indexes
        // Indices of virtual 1D array
        int l = 0;
        int r = rows*cols-1;

        while(l<=r){
           int m = l + (r-l) / 2;
           
           // convert 1d indices into 2d indices

           int row = m / cols;
           int col = m % cols;

           if(target < matrix[row][col]){
             r = m-1;
           }
           else if(target > matrix[row][col]){
            l = m + 1;
           }
           else{
            return true;
           }
        }
        return false;
    }
    public static void main(String[] args) {
      int matrix[][] = {{1,2,4,8},{10,11,12,13},{14,20,30,40}};
      int target = 50;
      if(search_in_matrix(matrix,target)){
        System.out.println("Element is found");
      }else{
        System.out.println("Element is not Found");
      }
    // int resultArr[] = search_in_matrix(matrix, target);
    // if(resultArr[0] == -1){
    //     System.out.println("Element Doesn't exist");
    // }else{
    // System.out.println("Element Found At Cell : " + "[" + resultArr[0]  + "," + resultArr[1] + "]");
    // }
    }
}
