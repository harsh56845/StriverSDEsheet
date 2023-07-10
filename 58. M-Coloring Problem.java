// Coding Ninjas Ques Link :-  https://www.codingninjas.com/studio/problems/m-coloring-problem_8230777?challengeSlug=striver-sde-challenge
import java.util.*;

public class Solution {
   public static boolean isSafe(int node,int []color,List<List<Integer>>adjList,int col){
       for(int it:adjList.get(node)){
           if(color[it]==col) return false;
       }
       return true;
   }
   public static boolean checkGraphColoring(List<List<Integer>>adjList,int[]color,int node,int m){
       if(node==adjList.size()) return true;
       for(int col = 1;col<=m;col++){
           if(isSafe(node,color,adjList,col)){
               color[node] = col;
               if(checkGraphColoring(adjList, color, node+1, m)) return true;
               color[node] = 0;
           }
       }
       return false;
   }
   public static String graphColoring(int [][]mat, int m) {

       // creating the adjacency list from adjacency matrix !!
       int n = mat.length;
       List<List<Integer>>adjList = new ArrayList<>();
       for(int i=0;i<n;i++){
           adjList.add(new ArrayList<>());
       }
       for(int i=0;i<mat.length;i++){
           for(int j=0;j<mat[i].length;j++){
               if(mat[i][j]!=0) adjList.get(i).add(j);
           }
       }

       int[]color = new int[n];
       if(checkGraphColoring(adjList,color,0,m)) return "YES";
       return "NO";
   }
}

// Gfg Link :- https://practice.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1#
https://p.ip.fi/z26h
