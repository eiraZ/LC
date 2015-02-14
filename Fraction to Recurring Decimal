/*
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
    
Solution: (1) negative
          (2) overflow
          (3) repeating part: hashmap<Long, Integer>. key: remain, value: index in stringbuilder
          (4) before dot
*/

public String fractionToDecimal(int numerator, int denominator) {
    boolean isNeg = (numerator<0) ^ (denominator < 0);
    
    long numer = Math.abs((long)numerator);
    long deno = Math.abs((long)denominator);
    
    if (deno == 0) return Integer.toString(Integer.MAX_VALUE);
    if (numer == 0) return "0";
    
    StringBuilder sb = new StringBuilder();
    
    if(isNeg) sb.append("-");
    long cur = numer/deno;
    sb.append(cur);
    long remain = numer%deno;
    if (remain == 0) return sb.toString();
    sb.append(".");
    
    HashMap<Long, Integer> map = new HashMap<Long, Integer>();
    
    while (remain > 0){
        if (map.containsKey(remain)){
            sb.insert(map.get(remain), "(");
            sb.append(")");
            break;
        }
        map.put(remain, sb.length());
        remain *= 10;
        sb.append(remain/deno);
        remain %= deno;
        
    }
    return sb.toString();
    
    
}
