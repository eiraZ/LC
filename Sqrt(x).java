/*
Implement int sqrt(int x).
Compute and return the square root of x.

Solution: sqrt(x) < x/2+1. Binary search
*/
public int sqrt(int x) {
    if (x < 0) return -1;
    if (x == 0) return 0;
    
    int left = 1;
    int right = x/2 + 1;
    while (left <= right){
        int mid = (left + right)/2;
        if ( mid == x/mid ) return mid;
        else if(mid < x/mid){
            left = mid + 1;
        }else{
            right = mid - 1;
        }
    }
    return right;
}
