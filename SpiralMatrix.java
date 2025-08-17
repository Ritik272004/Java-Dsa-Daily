public class SpiralMatrix {
    public static void print_spiral_matrix(int matrix[][]){
        int startRow = 0 , endRow = matrix.length-1 , startCol = 0 , endCol = matrix[0].length-1;
        
        while(startRow <= endRow && startCol <= endCol){
            // print top
            for(int j = startCol ;j<=endCol ;j++){
                System.out.print(matrix[startRow][j] +" ");
            }
            // print right
            for(int i = startRow + 1; i<=endRow;i++){
                System.out.print(matrix[i][endCol]+" ");
            }
            // print bottom
            for(int j = endCol-1;j>=startCol;j--){
                if(startRow == endRow){
                    break;
                } // This condition is benenficial when we take case of 3*4 matrix(single inner row) or 4*3 matrix(single inner column)
                System.out.print(matrix[endRow][j]+" ");
            }
            // print left
            for(int i = endRow-1;i>=startRow+1;i--){
                if(startCol == endCol){
                    break;
                }
                System.out.print(matrix[i][startCol]+" ");
            }

            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
    }
    public static void main(String[] args) {
        int matrix[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        print_spiral_matrix(matrix);
    }
}
