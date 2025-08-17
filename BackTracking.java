
public class BackTracking {
    public static void print(int arr[]){
        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    // public static void changeArr(int arr[] , int i , int val){
    //     if(i == arr.length){
    //         print(arr);
    //         return;
    //     }
    //     arr[i] = val;
    //     changeArr(arr, i+1, val+1);
    //     // backtrack step
    //     arr[i] = arr[i]-2;
    // }
    // print all subsets
    public static void find_all_Subsets(String s , String ans , int i){
        // base case
        if( i == s.length()){ // O(2^n * n) because for each subset calculation we have to check choice of n characters , where 2^n represents Total no. of subsets
            if(ans.length() == 0){
                System.out.println("null");
            }else{
                System.out.println(ans);
            }
            return;
        }
        find_all_Subsets(s, ans+s.charAt(i), i+1);
        // backtarck step
        find_all_Subsets(s, ans, i+1);
    }
    // print all permutations of Strings
    // Total no. of permutations = n!
    // Time Complexity = O(n*n!) , for each permutation calculation we have to rearrange n characters.
    public static void print_permutation(String s , String ans){
        // base case
        if(s.length() == 0){
            System.out.println(ans);
            return;
        }
        for(int i =0;i<s.length();i++){
            char curr = s.charAt(i);
            String newStr = s.substring(0,i) + s.substring(i+1); // str.substring(0,0) always return empty string.
            print_permutation(newStr, ans+curr);
        }
    }
    // N queens Problem => O(n!) , for each row we have n choices so according to that T.C is O(n^n) but isSafe() function filter out invalid configuration , S.C = O(n^2)
    // We have to arrange N queens on N*N Chess board . So that no two Queens attack each other
    // We place Queen from top to bottom , So we check only for vertically up , diagonally right up , diagonally left up not for vertically down.
    // public static void nQueens(char board[][] , int row){
    //     // base case
    //     if( row == board.length){
    //         printBoard(board);
    //         return;
    //     }

    //     // Traverse each column to place Queen
    //     for(int j =0;j<board.length;j++){
    //         // Check is it Safe to place Queen on that particular cell.
    //         if(isSafe(board , row , j)){
    //             board[row][j] = 'Q';
    //             nQueens(board, row+1);
    //             // BackTrack Step
    //             board[row][j] = 'X';
    //         }
    //     }
    // }
    // public static boolean isSafe(char board[][] , int row , int col){
    //     // Check for Vertically Up
    //     for(int i = row-1 ; i>=0 ;i--){
    //         if(board[i][col]  == 'Q'){
    //             return false;
    //         }
    //     }
    //     // check for diagonally right up
    //     for(int i = row-1 , j = col-1 ; i>=0 && j>=0 ;i-- , j--){
    //         if(board[i][j] == 'Q'){
    //             return false;
    //         }
    //     }
    //     // check for diagonally left up
    //     for(int i = row-1 , j = col + 1 ; i>=0 && j <=board.length-1 ; i-- , j++){
    //         if(board[i][j] == 'Q'){
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    // public static void printBoard(char [][] board){
    //     System.out.println("---------------Chess Board----------------");
    //     for(int i =0;i<board.length;i++){
    //         for(int j = 0 ;j<board.length;j++){
    //             System.out.print(board[i][j] + " ");
    //         }
    //         System.out.println();
    //     }
    // }

    // Grid ways means calculate no. of ways to move from cell (0,0) to cell (n-1,m-1)
    // At each cell we have two choices either we move right or down
    // Time complexity is : O(2^n+m)
    // n-> no. of rows and m-> no. of columns
    // public static int grid_ways(int i , int j , int n , int m){
    //     // base case
    //     if(i == n-1 && j == m-1){
    //         return 1;
    //     }
    //     else if(i == n || j == m){ // backtrack step
    //         return 0;
    //     }
    //     int w1 = grid_ways(i+1, j, n, m);
    //     int w2 = grid_ways(i, j+1, n, m);
    //     return w1 + w2;
    // }
    // Short Trick for grid ways 
    //  Total Ways = (n-1 + m-1)! / (n-1)!*(m-1)! 

    // public static int grid_ways(int n , int m){
    //     int fact1 = 1;
    //     int x = (n-1 + m-1);
    //     for(int i =2 ;i<=x ;i++){
    //         fact1*=i;
    //     }

    //     int y = n-1;
    //     int fact2 = 1;
    //     for(int j = 2 ;j<=y;j++){
    //         fact2*=j;
    //     }

    //     int z = m-1;
    //     int fact3 = 1;
    //     for(int k = 2;k<=z;k++){
    //         fact3*=k;
    //     }

    //     return fact1 / (fact2 * fact3);
    // }
    

    // Sodoku Solver
//     public static boolean sodokuSolver(int board[][] , int row , int col){
//         // base case
//         if(row == 9){ // we use 0-based indexing. When you gone beyond last row , means we already fill all cells.That's why we return true;
//             return true;
//         }
//         int nextRow = row;
//         int nextCol = col +1;

//         if(col +1 == 9){
//             nextRow = row+1;
//             nextCol = 0;
//         }
//         // if element already exist then move to next column
//         if(board[row][col] != 0){
//             return sodokuSolver(board, nextRow, nextCol);
//         }
        
//         // add digits to empty cell
//         for(int digit = 1;digit<=9;digit++){
//             if(isSafe(board, row , col , digit)){
//                 board[row][col] = digit;
//                 if(sodokuSolver(board, nextRow, nextCol)){
//                     return true;
//                 }
//                 board[row][col] = 0; // backtracking step
//             }
//         }
//         return false;
//     }

// public static boolean isSafe(int board[][] , int row , int col , int digit){
//         // check for each row;
//         for(int j = 0;j<9;j++){
//             if(board[row][j] == digit){
//                 return false;
//             }
//         }
//         // check for each column
//         for(int i =0;i<9;i++){
//             if(board[i][col] == digit){
//                 return false;
//             }
//         }
//         // check for each grid
//         int sr = (row/3)*3;
//         int sc = (col/3)*3;
//         for(int i = 0 ;i<sr+3;i++){
//             for(int j = 0 ;j<sc+3;j++){
//                 if(board[i][j] == digit){
//                     return false;
//                 }
//             }
//         }
//         return true;
// }

// public static void printBoard(int board[][]){
//     for(int i =0;i<9;i++){
//         for(int j =0;j<9;j++){
//             System.out.print(board[i][j] + " ");
//         }
//         System.out.println();
//     }
// }
    

// Rat in Maze Problem

// public static boolean solveMaze(int maze[][] , int n){
//     // make sol matrix to store sol i.e path to destination
//     int sol[][] = new int[n][n];

//     if(solveMazeUtil(maze,0,0,sol,n) == false){
//         System.out.println("Solution doesn't exist");
//         return false;
//     }

//     printSol(sol);
//     return  true;
// }
// public static boolean solveMazeUtil(int maze[][] , int x , int y , int sol[][] ,int n){
//     // base case
//     if(x == n-1 && y == n-1 && maze[x][y] == 1){
//         sol[x][y] = 1;
//         return true;
//     }

//     if(isSafe(maze , x , y , n)){
//         // If safe then mark x,y as a part of solution
//         sol[x][y] = 1;
//         // Move forward in x direction 
//         if(solveMazeUtil(maze, x+1, y, sol, n)){
//             return true;
//         }
//         // Move down in y direction
//         if(solveMazeUtil(maze, x, y+1, sol, n)){
//             return true;
//         }
//         // It both forward or downward doesn't work then unmark x,y as part of solution
//         sol[x][y] = 0; // backtracking step
//         return false; // this show path doesn't lead to solution back to previous point.
//     }
//     return false;
// }
// public static boolean isSafe(int maze[][] , int x ,int y , int n){
//     return x>=0 && x<n && y>=0 && y<n && maze[x][y] == 1;
// }
// public static void printSol(int sol[][]){
//     for(int i =0;i<sol.length;i++){
//         for(int j = 0;j<sol[0].length;j++){
//             System.out.print(sol[i][j]+" ");
//         }
//         System.out.println();
//     }
// }

// letter Combination => O(k^m) , O(k) , where k is number of letters per digit and m is no. of digits in input string
// final static char[][] L = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y'}};

// public static void letterCombination(String D){
//     int len = D.length();
//     if(len == 0){
//         System.out.println(" ");
//         return;
//     }
//     bfs(0,len,new StringBuilder(),D);
// }
// public static void bfs(int pos , int len , StringBuilder sb , String D ){
//     // base case
//     if(pos == len){
//         System.out.println(sb.toString());
//         return;
//     }
//     char [] letters = L[Character.getNumericValue(D.charAt(pos))];
//     for(int i =0;i<letters.length;i++){
//         // append letter to StringBuilder
//         sb.append(letters[i]);
//         // Move to next digit and take its letter make combination with letters of first digit
//         bfs(pos+1 , len , sb , D);
//         // backtrack (delete last letter) to make another combination
//         sb.deleteCharAt(sb.length()-1);
//     }
// }


    public static void main(String[] args) {
        // int arr[] = new int [5];
        // changeArr(arr , 0 , 1);
        // print(arr);
        // find_all_Subsets("abc", "", 0);
        // print_permutation("abc", "");
    //     char[][] board = new char [4][4];
    //     // Initialize board
    //     for(int i =0;i<board.length;i++){
    //         for(int j =0;j<board.length;j++){
    //             board[i][j] = 'X';
    //         }
    //     }
    //  nQueens(board, 0);
    // System.out.println(grid_ways(3, 3));
    //  int board[][] = {
    //     {0,0,8,0,0,0,0,0,0},
    //     {4,9,0,1,5,7,0,0,2},
    //     {0,0,3,0,0,4,1,9,0},
    //     {1,8,5,0,6,0,0,2,0},
    //     {0,0,0,0,2,0,0,6,0},
    //     {9,6,0,4,0,5,3,0,0},
    //     {0,3,0,0,7,2,0,0,4},
    //     {0,4,9,0,3,0,0,5,7},
    //     {8,2,7,0,0,9,0,1,3}
    // };
    //     if(sodokuSolver(board,0,0)){
    //         System.out.println("Solution Exist");
    //         printBoard(board);
    //     }
    //     else{
    //         System.out.println("Solution Doesn't exist");
    //     }

    // int maze[][] ={{1,0,0,0} ,{1,1,0,1},{0,1,0,0},{1,1,1,1}};
    // int n = maze.length;
    // solveMaze(maze , n);
    // String D = "23";
    // letterCombination(D);

    }

}
