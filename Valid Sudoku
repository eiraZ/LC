/*
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

Solution: DFS
          check row, col, box
*/

public boolean isValidSudoku(char[][] board) {
    if (board.length != 9 || board.length != board[0].length) return false;
    
    //check row for every cell
    for (int i =0; i<9; i++){
        boolean[] visited = new boolean[9];
        for (int j = 0; j < 9; j++){
            if(!isValid(visited, board[i][j])) return false; 
        }
    }
    //column
    for (int i = 0; i < 9, i++){
        boolean[] visited = new boolean[9];
        for (int j = 0; j < 9; j++){
            if(!isValid(visited, board[j][i])) return false;
        }
    }
    //box
    for (int i = 0; i < 3; i++){
        for (int j= 0; j<3; j++){
            boolean[] visited = new boolean[9];
            for (int r = i*3; r < i*3 +3; r++){
                for (int c = j*3; c< j*3 + 3; c++){
                    if (!isValid(visited, board[r][c])) return false;
                }
            }
        }
    }
    return true;
    
}

private boolean isValid(boolean[] visited, char c){
    if(c=='.') return true;
    if(visited[c-'1']) return false;
    visited[c-'1'] = true;
    return true;
}
