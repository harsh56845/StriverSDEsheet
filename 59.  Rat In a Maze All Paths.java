// Coding Ninjas Ques Link :- https://www.codingninjas.com/studio/problems/rat-in-a-maze-all-paths_8230705?challengeSlug=striver-sde-challenge
import java.util.* ;
import java.io.*; 
public class Solution {
    static int[] x = {-1, 0, 1, 0};
    static int[] y = {0, -1, 0, 1};
    public static ArrayList<ArrayList<Integer>> ratInAMaze(int[][] maze, int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int[][] vis = new int[n][n];
        vis[0][0] = 1;
        solve(maze, 0, 0, vis, ans);

        return ans;
    }

    static void solve(int[][] mat, int row, int col, int[][] vis, ArrayList<ArrayList<Integer>> ans){
        if(row == mat.length-1 && col == mat.length - 1){
            addMaze(vis, ans);
            return;
        }

        for(int i=0; i<4; i++){
            int nr = row + x[i];
            int nc = col + y[i];

            if(nr >= 0 && nc >= 0 && nr < mat.length && nc < mat.length && mat[nr][nc] == 1 && vis[nr][nc] == 0){
                vis[nr][nc] = 1;
                solve(mat, nr, nc, vis, ans);
                vis[nr][nc] = 0;
            }
        }
    }

    static void addMaze(int[][] mat, ArrayList<ArrayList<Integer>> ans){
        ArrayList<Integer> temp = new ArrayList<>();
        for(int[] arr: mat){
            for(int el: arr){
                temp.add(el);
            }
        }

        ans.add(temp);
        return;
    }
}

// GFG link :- https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
class Solution {
    ArrayList<String> ans = new ArrayList<>();
    int arr[][] ;
    
    public  ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<Character> list = new ArrayList<>();
        arr = m;
        solve(0, 0, n, list);
        return ans;
    }
    
    void solve(int r , int c , int n , List<Character> list ){
        
        if(arr[r][c] == 0) return;
        
        if(r == n-1 && c == n-1) {
            StringBuilder path = new StringBuilder();
            for(char ch: list) path.append(ch);
            ans.add(path.toString());
            return;
        }
        
        arr[r][c] = 0;
        if(r>0 ){;
            list.add('U');
           solve(r -1 , c, n, list);
           list.remove(list.size()-1);
           
        }
        if(r<n-1){
            list.add('D');
            solve(r +1 , c, n,list);
            list.remove(list.size()-1);
        }
        
        if(c>0){
            list.add('L');
            solve(r , c-1, n, list);
            list.remove(list.size()-1);
        }
        
        if(c<n-1){
            list.add('R');    
            solve(r , c+1, n, list);
            list.remove(list.size()-1);
        }
        arr[r][c]=1;
        
    }
}
