/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.

Solution: DFS
find a particular path exists. 
BFS is not a good choice because this is not a shortest path finding problem. Once we found a "wrong" path, we have to backtrace
to the divergent point.
*/
public boolean exist(char[][] board, String word) {
    if (word.length() == 0) return true; 
    if(board.length == 0 || board[0].length == 0){
        return false;
    }
    boolean[][] visited = new boolean[board.length][board[0].length];
    for (int i = 0; i<board.length; i++){
        for (int j = 0; j< board[0].length; j++){
            if (board[i][j] == word.charAt(0) && helper(board, word, visited, 0, i, j)){
                return true;
            }
        }
    }
    return false;
}
private boolean helper(char[][] board, String word, boolean[][] visited, int step, int row, int col){
    if(step == word.length()) return true;
    
    if (row<0 || col < 0 || row >= board.length || col >= board[0].length) return false;
    if (visited[row][col] || (word.charAt(step) != board[row][col])) return false;
    
    visited[row][col] = true;
    
    if(helper(board, word, visited, step+1, row-1, col)) return true;
    if(helper(board, word, visited, step+1, row+1, col)) return true;
    if(helper(board, word, visited, step+1, row1, col-1)) return true;
    if(helper(board, word, visited, step+1, row, col+1)) return true;
    
    visited[row][col] = false;
    return false;
    
}
