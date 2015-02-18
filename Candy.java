/*
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

Solution: from left to right;
          from right to left
*/

public int candy(int[] ratings) {
    if (ratings.length == 0 ) return 0;
    int[] candies = new int[ratings.length];
    
    int res = 0;
    
    candies[0] = 1;
    for (int i = 1; i< ratings.length; i++){
        candies[i] = (ratings[i] > ratings[i-1])? candies[i-1] + 1 : 1;
    }
    
    //int right = candies[candies.length - 1];
    //res = right;
    res = candies[candies.length - 1];
    for (int i = ratings.length -2; i>=0; i--){
        if ( ratings[i] > ratings[i + 1]){
            candies[i] = Math.max(candies[i+1]+1, candies[i]);
        }
        res += candies[i];
    }
    
    return res;
    
}
