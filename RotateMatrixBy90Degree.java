public class RotateMatrixBy90Degree {
    public static void rotate_matrix(int matrix[][]){
        //1. Brute Force Approach , O(n^2) ,O(n^2)

        // int n = matrix.length;
        // int m = matrix[0].length;

        // int [][] rotated = new int[n][m];

        // for(int i =0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         rotated[j][n-1-i] = matrix[i][j];
        //     }
        // }

        // for(int i=0;i<n;i++){
        //     for(int j =0;j<m;j++){
        //         matrix[i][j] = rotated[i][j];
        //     }
        // }

        // 2. Reverse and transpose method ,O(n^2) ,O(1)        
        int n = matrix.length;
        int m = matrix[0].length;

        reverse(matrix , n); // reverse the top row and bottom row

        // Transpose the matrix

        for(int i =0;i<n;i++){
            for(int j=i;j<m;j++){ // Here j = i , to avoid double swapping
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }

    public static void reverse(int matrix[][] , int n){
        for(int i =0;i<n/2;i++){
            int[] temp = matrix[i];
            matrix[i] = matrix[n-i-1];
            matrix[n-i-1] = temp;
        }
    }

    public static void main(String[] args) {
        int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
        // Matrix Before Rotating
        for(int i =0;i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j] +" ");
            }
            System.out.println();
        }
        rotate_matrix(matrix);
        // Matrix After Rotating
        System.out.println("---------------");
        for(int i =0;i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j] +" ");
            }
            System.out.println();
        }
    }
}
