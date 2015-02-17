/*
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.

*/
public String getPermutation(int n, int k) {
    if ( n < 0 || k < 0) return "";
    ArrayList<Integer> num = ArrayList<Integer>();
    
    for (int i = 1; i<=n; i++){
        num.add(i);
    }
    int factorial = 1;
    for (int i = 2; i < n; i++){
        factorial *= i;
    }
    
    k--;
    int round = n - 1;
    StringBuilder sb = new StringBuilder();
    while (round >= 0){
        int index = k/factorial;
        sb.append(num.get(index));
        num.remove(index);
        k %= factorial;
        if ( round > 0 ){
            factorial /= round;
        }
        round--;
        
    }
    return sb.toString();
    
}
