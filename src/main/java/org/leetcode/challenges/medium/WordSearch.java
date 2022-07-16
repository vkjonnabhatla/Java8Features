package org.leetcode.challenges.medium;

/**
 *Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 * Example 2:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 * Example 3:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 *
 *
 * Constraints:
 *
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board and word consists of only lowercase and uppercase English letters.
 *
 */
public class WordSearch {

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','E','C','S'},{'A','D','E','E'}};
        String word = "SEE";
        WordSearch obj = new WordSearch();
        System.out.println(obj.exist(board, word));
    }
    public boolean exist(char[][] board, String word) {

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0) && dfs(board, i , j , word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, String word, int pos){
        if(pos == word.length()) return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        if(board[i][j] != word.charAt(pos)) return false;

        char temp = board[i][j];
        board[i][j] = ' ';

        if(dfs(board, i + 1, j, word, pos + 1) ||
                dfs(board, i - 1, j, word, pos + 1) ||
                dfs(board, i, j + 1, word, pos + 1) ||
                dfs(board, i, j - 1, word, pos + 1))
            return true;
        board[i][j] = temp;
        return false;
    }
}
