package Codes.BackTrackking;

import java.util.Arrays;

public class AllPaths {
    public static void main(String[] args) {
        boolean[][] maze ={{true,true,true},{true,true,true},{true,true,true}};
        int path[][] = new int[maze.length][maze[0].length];
        allPathMatrix("",maze,0,0,path,1);
    }

    //printing path as a matrix
    static void allPathMatrix(String p ,boolean maze[][], int r ,int c ,int [][]path ,int step){
        if(r==maze.length-1 && c== maze[0].length-1){
            path[r][c]=step;
            for(int []a : path){
                System.out.println(Arrays.toString(a));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        if(!maze[r][c]){
            return;
        }

        //this is where we update the path as visited for current function call.
        maze[r][c]=false;
        path[r][c]=step;
        if(r< maze.length-1){
            allPathMatrix(p+"D",maze,r+1,c,path,step+1);
        }
        if(c< maze[0].length-1){
            allPathMatrix(p+"R",maze,r,c+1,path,step+1);
        }
        if(r>0){
            allPathMatrix(p+"U",maze,r-1,c,path,step+1);
        }
        if(c>0){
            allPathMatrix(p+"L",maze,r,c-1,path,step+1);
        }
        //this is where the function is over so we remove the changes made by this function
        maze[r][c] =true;
        path[r][c]=0;
    }
    static void allPath(String p ,boolean maze[][], int r ,int c){
        if(r==maze.length-1 && c== maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return;
        }

        //this is where we update the path as visited for current function call.
        maze[r][c]=false;

        if(r< maze.length-1){
            allPath(p+"D",maze,r+1,c);
        }
        if(c< maze[0].length-1){
            allPath(p+"R",maze,r,c+1);
        }
        if(r>0){
            allPath(p+"U",maze,r-1,c);
        }
        if(c>0){
            allPath(p+"L",maze,r,c-1);
        }
        //this is where the function is over so we remove the changes made by this function
        maze[r][c] =true;
    }
}
