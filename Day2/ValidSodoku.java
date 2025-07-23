

import java.util.*;
public class ValidSodoku {

    // In this we use Set which is an interface in java and implemented through HashSet . set store only unique elements(no duplicates allowed)
    // In Set there is not indexing like ArrayList because Order is not gurranted in set.
    // Methods like .add() , .remove() , .contains() all of them take O(1) time.

    public static boolean isValidSodoku(char [][] board){ // O(n^2) 
        // check each row
        for(int row = 0;row<board.length;row++){
            Set<Character> seen = new HashSet<>();
            for(int col = 0;col<board[0].length;col++){
                char current = board[row][col];
                if(current == '.'){
                    continue;
                }
                if(seen.contains(current)){
                    return false;
                }
                seen.add(current);
            }
        }

        // check each column
        for(int col = 0;col<board[0].length;col++){
            Set<Character> seen = new HashSet<>();
            for(int row = 0;row<board.length;row++){
                char current = board[row][col];
                if(current == '.'){
                    continue;
                }
                if(seen.contains(current)){
                    return false;
                }
                seen.add(current);
            }
        }

        // check each 3*3 sub-grid(block)
        /*
            int startRow = (block / 3) * 3;
            int startCol = (block % 3) * 3;
            Why This Works:
            block / 3 gives the row index of the block (0, 1, 2).

            block % 3 gives the column index of the block (0, 1, 2).

            Multiply by 3 because each block spans 3 rows/columns. 
        */

        for(int block = 0;block<board.length;block++){
            Set<Character> seen = new HashSet<>();
            int startRow = (block / 3)*3;
            int startCol = (block % 3)*3;

            for(int i =0;i<3;i++){
                for(int j =0;j<3;j++){
                    char current = board[startRow+i][startCol+j];
                    if(current == '.') continue;
                    if(seen.contains(current)) return false;
                    seen.add(current);
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
    char[][] board = {
    {'5', '3', '4', '6', '7', '8', '9', '1', '2'},
    {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
    {'1', '9', '8', '3', '4', '2', '5', '6', '7'},
    {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
    {'4', '2', '6', '8', '5', '3', '7', '9', '1'},
    {'7', '1', '3', '9', '2', '4', '8', '5', '6'},
    {'9', '6', '1', '5', '3', '7', '2', '8', '4'},
    {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
    {'3', '4', '5', '2', '8', '6', '1', '7', '9'}
};
  
                    
                    System.out.println("Is Valid Sodoku : " + isValidSodoku(board));

    }
}


