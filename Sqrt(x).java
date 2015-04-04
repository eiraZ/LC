/*
Implement int sqrt(int x).
Compute and return the square root of x.

Solution: (1) sqrt(x) < x/2+1. Binary search
          (2) Newton method. f(x) = x^2 - n. x^2 - n == 0. f'(x) = 2x.
                f(x) - f(xi) = 2xi * (x-xi) --> f(x) = f(xi) + 2xi * (x-xi) == 0. f(xi) = xi^2 - n.
                x = (xi + n/xi)/2.

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

public int sqrtNewton(int x) {
    if (x < 0) return -1;
    if (x == 0) return 0;
    
    double last = 0;
    double res = 1;
    while (res != last){
        last = res;
        res = (res + n/res)/2;
    }
    return (int)res;
}
