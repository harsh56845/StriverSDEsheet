// Leetcode link :- https://leetcode.com/problems/sudoku-solver/
class Solution {
    public void solveSudoku(char[][] board) {
        int[] complete = new int[1];
        solver(board,0,0,complete);
    }
    public static void solver(char[][] board,int row,int col,int[] complete) {
        if (row == board.length-1 && col == board[0].length) {
            complete[0] = 1;
            return;
        }
        if (col == board[0].length) {
            solver(board,row+1,0,complete);
            return;
        }
        if (board[row][col] == '.') {
            for (int i = 1; i<= 9;i++) {
                if (isValid(board,row,col,(char)(i + '0'))) {
                    board[row][col] = (char)(i + '0');
                    solver(board,row,col+1,complete);
                    if (complete[0] != 1) {
                    board[row][col] = '.';
                    }
                } 
            }
        } else {
            solver(board,row,col+1,complete);
        }
    }
    public static boolean isValid(char[][] board,int row,int col,char ch) {   
        //row
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == ch) {
                return false;
            }
        }
        //col
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == ch) {
                return false;
            }
        }
        // 3x3 Grid
        int r = (row/3)*3;
        int c = (col/3)*3;
        for (int i = r; i < r+3; i++) {
            for (int j = c; j < c+3; j++) {
                if (board[i][j] == ch) {
                    return false;
                }
            }
        }

        return true;
    }
}

// Coding Ninjas :-  https://www.codingninjas.com/studio/problems/valid-sudoku_8230704?challengeSlug=striver-sde-challenge&leftPanelTab=1
public class Solution {

	public static boolean isSafe(int[][] matrix, int row, int col, int num) {

		for (int i = 0; i < matrix.length; i++) {

			if (matrix[i][col] == num) {

				return false;

			}

		}

		for (int j = 0; j < matrix.length; j++) {

			if (matrix[row][j] == num) {

				return false;

			}

		}

		int x = (row / 3) * 3;

		int y = (col / 3) * 3;

		for (int i = x; i < x + 3; i++) {

			for (int j = y; j < y + 3; j++) {

				if (matrix[i][j] == num) {

					return false;

				}

			}

		}

		return true;

	}

	public static boolean helper(int[][] matrix, int row, int col) {

		if (row == matrix.length) {

			return true;

		}

		int nrow, ncol;

		if (col == matrix.length - 1) {

			nrow = row + 1;

			ncol = 0;

		} else {

			nrow = row;

			ncol = col + 1;

		}

		if (matrix[row][col] != 0) {

			return helper(matrix, nrow, ncol);

		} else {

			for (int i = 1; i <= 9; i++) {

				if (isSafe(matrix, row, col, i)) {

					matrix[row][col] = i;

					if (helper(matrix, nrow, ncol)) {

						return true;

					} else {

						matrix[row][col] = 0;

					}

				}

			}

			return false;

		}

	}

	public static boolean isItSudoku(int[][] matrix) {

		return helper(matrix, 0, 0);

	}

}
