public class RatInMazeProblem {
    public static boolean rat_in_maze(int maze[][] , int n){
        int sol[][] = new int[n][n];
        if(solveMazeUtil(maze,0,0,sol,n) == false){
            System.out.println("Sol doesn't exist");
            return false;
        }
        printSol(sol);
        return true;
    }
    public static boolean solveMazeUtil(int maze[][] , int x , int y , int sol[][] , int n){
        // base case
        if(x == n-1 && y == n-1 && maze[x][y] == 1){
            sol[x][y] = 1;
            return true;
        }
        if(isSafe(maze,x,y,n)){
            sol[x][y] = 1;
            // Move Forward in x direction
            if(solveMazeUtil(maze, x+1, y, sol, n)){
                return true;
            }
            // Move Downward in y direction
            if(solveMazeUtil(maze, x, y+1, sol, n)){
                return true;
            }
            // if neither forward nor downward works , then unmark x,y as part of solution
            sol[x][y] = 0;
            return false; // this path doesn't lead to solution backtrack to previous point
        }
        return false;
    }
    public static void printSol(int sol[][]){
        for(int i =0;i<sol.length;i++){
            for(int j =0;j<sol[0].length;j++){
                System.out.print(sol[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static boolean isSafe(int maze[][] , int x , int y ,int n){
        return x>=0 && x<n && y>=0 && y<n && maze[x][y] == 1;
    }
    public static void main(String[] args) {
        int maze[][] ={{1,0,0,0} ,{1,1,0,1},{0,1,0,0},{1,1,1,1}};
        int n = maze.length;
        rat_in_maze(maze , n);
    }
}
