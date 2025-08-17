

public class NQueensProblem {
    public static boolean n_queens(char[][] chessboard , int row){
        // base case
        if(row == chessboard.length){
            // printBoard(chessboard);
            return true;
        }
        // Traverse each column to place Queen
        for(int j =0;j<chessboard[0].length;j++){
            if(isSafe(chessboard , row , j)){
                chessboard[row][j] = 'Q';
               if(n_queens(chessboard,row+1)){
                return true;
               }
                // backTrack
                chessboard[row][j] = 'X';
            }
        }
        return false;
    }
    public static boolean isSafe(char[][] chessboard , int row , int col){
        // check for vertically up
        for(int i = row-1;i>=0;i--){
            if(chessboard[i][col] == 'Q'){
                return false;
            }
        }
        // check for diagonally left up
        for(int i = row-1 , j = col-1 ; i>=0 && j >=0 ;i-- , j--){
            if(chessboard[i][j] == 'Q'){
                return false;
            }
        }
        // check for diagonally right up
        for(int i = row-1 , j = col+1 ;i>=0 && j<=chessboard[0].length-1;i--,j++){
            if(chessboard[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
    public static void printBoard(char[][] chessboard ){
        System.out.println("--------chessBoard------");
        for(int i =0;i<chessboard.length;i++){
            for(int j =0;j<chessboard[0].length;j++){
                System.out.print(chessboard[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        char[][] chessboard = new char [4][4];
        for(int i =0;i<chessboard.length;i++){
            for(int j = 0;j<chessboard[0].length;j++){
                chessboard[i][j] = 'X';
            }
        }
        if(n_queens(chessboard, 0)){
            System.out.println("Solution Exist");
            printBoard(chessboard);
        }else{
            System.out.println("Solution Doesn't Exist");
        }

    }
}
