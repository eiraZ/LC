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

Solution: DFS+ backtracking. 
          check row by row ->check availability -> if valid, mark ->next row
                                                    not valid, back to previous level
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
