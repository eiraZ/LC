/*
Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.

Solution: (1)Bit manipulation. simulate subtract operation with bit. 
              corner cases: overflow, neg or pos?
              check neg first: eg. -2147483648, 1 is still valid
              
              e.g. 15/2: 15- (2<<0) = 13; res += 1<<0 
                  13 - (2<<1) = 13 -4 = 9; res += 1<<1
                  .....
*/
public int divide(int dividend, int divisor) {
    // pos or neg?
    boolean isNeg = (dividend < 0) ^ (divisor < 0);
    //consider overflow...
    long lend = Math.abs((long)dividend);
    long lsor = Math.abs((long)divisor);
    
    long res = 0;
    while (lend >= lsor){
        long c = lsor;
        for (int i = 0; (c<<i) <=lend; i++){
            lend -= c<<i;
            res += 1<<i;
        }
    }
    
    if (isNeg) res = -res;
    if ( res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
    return (int)res;
}
