public class SetMatrixZero {
    // Set entire row and column to zero if any element is zero

    public static void set_matrix_zero(int matrix[][]){
        //1. Brute Force Approach ,O(n*m) ,O(n*m)

//         int n = matrix.length , m = matrix[0].length;
//         int mark[][] = new int[n][m];

//         // copy values from matrix to mark matrix
//         for(int r = 0 ; r<n;r++){
//             System.arraycopy(matrix[r],0,mark[r],0,m);
//         }

//         for(int r = 0;r<n;r++){
//             for(int c = 0;c<m;c++){
//                 if(matrix[r][c] == 0){ /*In your second loop, you check if (matrix[r][c] == 0) but you’re reading from matrix, not from mark.

// This is correct for avoiding cascading — because matrix still has original values.

// Then you write zeros into mark (not into matrix), which is safe. */
//                     // set entire row to zero
//                     for(int col = 0;col<m;col++){
//                         mark[r][col] = 0;
//                     }
//                     // set entire column to zero
//                     for(int row = 0;row<n;row++){
//                         mark[row][c] = 0;
//                     }
//                 }
//             }
//         }

//         // copy values from mark to matrix
//         for(int r = 0 ; r<n;r++){
//             System.arraycopy(mark[r],0,matrix[r],0,m);
//         }

        //2. Better Approach , O(n*m) ,O(1)

        int n = matrix.length , m = matrix[0].length;

        boolean firstRowZero = false; // This flag remembers if the first row needs to be zero out later

        for(int r = 0;r<n;r++){
            for(int c = 0;c<m;c++){
                if(matrix[r][c] == 0){
                    matrix[0][c] = 0; // Mark the column at first row as 0 , "this column must be zero"

                    if(r>0){
                        matrix[r][0] = 0; // Mark the row at first column as 0 , "this row must be zero"
                    }else{
                        firstRowZero = true;
                    }
                }
            }
        }

        // Set cells to zero except first row & column
        for(int r = 1;r<n;r++){
            for(int c =1 ;c<n;c++){
                if(matrix[0][c] == 0 || matrix[r][0] == 0){
                    matrix[r][c] = 0;
                }
            }
        }

        // Handle first column
        if(matrix[0][0] == 0){
            for(int r = 0;r<n;r++){
                matrix[r][0] = 0;
            }
        }

        // Handle first row
        if(firstRowZero){
            for(int c = 0;c<m;c++){
                matrix[0][c] = 0;
            }
        }

    }
    public static void main(String[] args) {
        int matrix[][] = {{1,2,3},{4,0,5},{6,7,8}};
        // Matrix before modification
        for(int i =0;i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j] +" ");
            }
            System.out.println();
        }
        set_matrix_zero(matrix);
        // Matrix after modification
        System.out.println();
        for(int i =0;i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j] +" ");
            }
            System.out.println();
        }
    }
}
