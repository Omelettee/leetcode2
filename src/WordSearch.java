/**
 * LC 79 mediun backtracking
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */


public class WordSearch {


    // DFS
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0);

        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (search(board, i, j, chars, 0 )) return true;
            }
        }
        return false;
    }

    public boolean search(char[][] board, int r, int c,  char[] chars, int i){
        if (i == chars.length) return true;
        boolean found = false;
        if (r >= 0 && r < board.length && c >=0 && c < board[0].length){
            if (board[r][c] == chars[i]) {
                board[r][c] = '0'; // this is used to reduce the step of searching
                found = search(board, r-1, c , chars, i+1)
                        || search(board, r+1, c , chars, i+1)
                        || search(board, r, c-1 , chars, i+1)
                        || search(board, r, c+1 , chars, i+1) ;
                board[r][c] = chars[i];
            }
        }
        return found;
    }
}

