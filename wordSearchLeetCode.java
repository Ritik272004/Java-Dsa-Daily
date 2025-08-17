public class wordSearchLeetCode {
    /*You’re given:

        A grid of characters (m x n board).

        A target word (string).

        You need to check:
        ➡ Can this word be formed by starting at any cell and moving to horizontally or vertically adjacent cells?
        ➡ Rules:

        You can move up, down, left, or right (no diagonal).

        You cannot reuse the same cell in a single word path. */

        public static boolean wordSearch(char board[][] , String word){
            // Time Complexity : O(m*n*3^L-1) , where m is no. of rows , n is no. of cols , L is Length of String word
            int rows = board.length;
            int cols = board[0].length;

            for(int r = 0; r<rows;r++){
                for(int c = 0;c<cols;c++){
                    if(dfs(board,word , r , c , 0)){
                        return true;
                    }
                }
            }
            return false;
        }

        public static boolean dfs(char[][] board , String word , int r , int c , int index){
            // base case
            if(index == word.length()){
                return true;
            }
            // check boundary conditions
            if(r<0 || r>=board.length || c<0 || c>=board[0].length || board[r][c] != word.charAt(index)){
                return false;
            }
            // Mark current cell as visited
            char temp = board[r][c];
            board[r][c] = '#';

            // Explore all 4 possible directions (for first cell we can explore 4 directions , but for second or so on cells we can only explore 3 directions because we cann't reuse visited cell again in the word path)
            boolean found = dfs(board,word,r+1,c,index+1) || dfs(board,word,r-1,c,index+1) || dfs(board,word,r,c+1,index+1) || dfs(board,word,r,c-1,index+1);

            // backtrack(unmark visited cell)
            board[r][c] = temp;

            return found;
        }


    public static void main(String[] args) {
        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };

        String word = "ABCCED";
        System.out.println(wordSearch(board , word));

    }
}
