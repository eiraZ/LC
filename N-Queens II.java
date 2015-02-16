/*
Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.

Solution: (1) DFS
          (2) Bit-maniputlation.
*/
public int totalNQueens_DFS(int n) {
  if (n <= 0) return 0;
  int[] res = new int[1];
  int[] occupied = new int[n];
  dfsHelper(res, n, occupied, 0);
  return res[0];
}
private void dfsHelper(int[] res, int n, int[] occupied, int step){
    if (step == n){
        res[0]++;
        return;
    }
    for (int i = 0; i < n; i++){
        if(isValid(occupied, step, i)){
            occupied[step] = i;
            dfsHelper(res, n, occupied, step + 1);
            occupied[step] = 0;
        }
    }
}

private boolean isValid(int[] occupied, int step, int loc){
    for (int i = 0; i<step; i++){
        if (occupied[i] == loc || Math.abs(i-step) == Math.abs(occupied[i] - loc)){
            return false;
        }
    }
    return true;
}


public int totalNQueens_bit(int n) {
    if (n <=0) return 0;
    int[] res = new int[1];
    bitHelper(res, n, 0, 0, 0);
    return res[0];
}
private void bitHelper(int[] res, int n, int row, int leftDi, int rightDi){
    if( row == (1<<n)-1){
        res[0]++;
        return;
    }
    int mask = (1<<n) - 1;
    int avail = mask & (~(row|leftDi|rightDi));
    while (avail!=0){
        int pos = avail & (-avail);
        avail -= pos;
        bitHelper(res, n, (row|pos), (leftDi|pos)<<1, (rightDi|pos)>>1);
    }
}
