/*
Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X

Solution:   DFS: stack overflow
            BFS: a queue to store (i, j) position.
*/
public void solve(char[][] board) {
    if (board.length == 0 || board[0].length == 0 ) return;
    
    for (int i = 0; i< board.length; i++){
        for (int j = 0; j<board[0].length; j++){
            if ( i == 0|| j == 0 || i == board.length -1 || j == board[0].length - 1){
                //dfs(board, i, j);
                bfs(board, i, j);
            }
        }
    }
    
    for (int i = 0; i< board.length; i++){
        for (int j = 0; j<board[0].length; j++){
            if (board[i][j] == 'V'){
                board[i][j] = 'O';
            }else{
                board[i][j] = 'X';
            }
        }
    }
}
private void bfs(char[][] board, int i, int j){
    if (board[i][j] != 'O') return;
    
    LinkedList<Integer> queue = new LinkedList<Integer>();
    queue.offer(i);
    queue.offer(j);
    
    while (queue.size() > 0){
        int row = queue.poll();
        int col = queue.poll();
        if (row >= 0 && row < board.length && col >=0 && col <board[0].length){
            if (board[row][col] != 'O') continue;
            board[row][col] = 'V';
            
            queue.offer(row - 1);
            queue.offer(col);
            
            queue.offer(row + 1);
            queue.offer(col);
            
            queue.offer(row);
            queue.offer(col-1);
            
            queue.offer(row);
            queue.offer(col + 1);
        }
    }
}

private void dfs (char[][] board, int i, int j){
    if ( i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
    if (board[i][j] != 'O' ) return;;
    board[i][j] = 'V';
    
    dfs(board, i-1, j);
    dfs(board, i+1, j);
    dfs(board, i, j-1);
    dfs(board, i, j+1);
    
}
