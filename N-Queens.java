/*
Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]

Solution: (1)DFS+ backtracking. 
          check row by row ->check availability -> if valid, mark ->next row
                                                    not valid, back to previous level
          (2) bit manipulation.
*/

    public List<String[]> solveNQueens(int n) {
        List<String[]> res = new ArrayList<String[]>();
        if (n <= 0) return res;
        int[] occupied = new int[n];
        solve(res, n, occupied, 0);
        return res;
    }
    private void solve(List<String[]> res, int n, int[] occupied, int step){
        if(step == n){
            String[] sol = printSolution(occupied);
            res.add(sol);
            return;
        }
        for (int i = 0; i < n; i++){
            if(isValid(occupied, step, i)){
                occupied[step] = i;
                solve(res, n, occupied, step+1);
                occupied[step] = 0;
            }
        }
    }
    private boolean isValid(int[] occupied, int step, int loc){
        for (int i =0; i < step; i++){
            if(occupied[i] == loc ||(Math.abs(i-step) == Math.abs(occupied[i] - loc))){
                return false;
            }
        }
        return true;
    }
    private String[] printSolution(int[] occupied){
        String[] sol = new String[occupied.length];
        for(int i =0; i<occupied.length; i++){
            StringBuilder sb = new StringBuilder();
            for (int j =0; j < occupied.length; j++){
                char c = (occupied[i] == j? 'Q': '.');
                sb.append(c);
            }
            sol[i] = sb.toString();
        }
        return sol;
    }
    
    public List<String[]> solveNQueens_bit(int n) {
        List<String[]> res = new ArrayList<String[]>();
        if (n <= 0) return res;
        List<Integer> rec = new ArrayList<Integer>();
        bitHelper(res, n, rec, 0, 0, 0);
        return res;
    }
    
    private void bitHelper(List<String[]> res, int n, List<Integer> rec, int row, int leftDi, int rightDi){
        if (row == (1<<n) - 1){
            String[] sol = print(rec);
            res.add(sol);
            return;
        }
        int mask = (1<<n) -1;
        int avail = mask & (~( row | leftDi | rightDi));
        while (avail != 0){
            int pos = avail & (-avail);
            rec.add(pos);
            avail -= pos;
            bitHelper(res, n, rec, row|pos, (leftDi|pos)<<1, (rightDi|pos)>>1);
            rec.remove(rec.size() - 1);
        }
        
    }
    
    private String[] print(List<Integer> rec){
        String[] sol = new String[rec.size()];
        for(int i = 0; i < sol.length; i++){
            StringBuilder sb = new StringBuilder();
            int cur = rec.get(i);
            for (int j = 0; j < sol.length; j++){
                int bit = (cur>>j) & 1;
                char c = (bit==1? 'Q': '.');
                sb.append(c);
            }
            sol[i] = sb.toString();
        }
        return sol;
    }
