/*
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Return 0 if the array contains less than 2 elements.

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.

Solution: (1) sort and find maximum gap. O(nlogn)
          (2) bucket sort + drawer theory. 
          
          /*drawer theory: we have (n+1) drawers, and put n numbers in these drawers, there exists at least an empty drawer.
        since the drawer size is the same, we can guarantee that the max gap is between an empty drawer
            find maxVal and minVal,
            we want to put such n numbers in n+1 buckets: 
            calculate average gap: (maxVal + 1 - minVal) /(n+1) [a, b)
            index = (num[i] - minVal)/averGap
            we need a node class to mimic a bucket. we'll have several numbers in a bucket if these numbers are close and fall 
            into the same index.
            high bound, low bound
            node.highbound 
            node.lowbound
        */
*/
public int maximumGap1(int[] num) {
    if (num.length < 2) return 0;
    Arrays.sort(num);
    int res = Integer.MIN_VALUE;
    for (int i = 1; i< num.length; i++){
        res = Math.max(num[i]-num[i-1], res);
    }
    return res;
}

public int maximumGap2(int[] num){

    class Node{
        int low;
        int high;
        public Node(){
            low = -1;
            high = -1;
        }
    }
    if (num.length < 2) return 0;
    
    int max = num[0];
    int min = num[0];
    
    for (int i = 0; i<num.length; i++){
        max = Math.max(num[i], max);
        min = Math.min(num[i], min);
    }
    
    int averGap = (int)(Long.valueOf(max - min + 1)/Long.valueOf(num.length + 1));
    
    Node[] buckets = new Node[num.length + 1];
    
    for (int i = 0; i < buckets.length; i++){
        buckets[i] = new Node();
    }
    //buckets[0].high = min;
    //buckets[num.length].low = max;
    
    for (int i = 0; i< num.length; i++){
        int index = (num[i] - min)/averGap;
        if (buckets[index].low == -1){
            buckets[index].low = num[i];
            buckets[index].hight = num[i];
        }else{
            buckets[index].low = Math.min(num[i], buckets[index].low);
            buckets[index].hight = Math.max(num[i], buckets[index].high);
        }
    }
    
    int res = Integer.MIN_VALUE;
    int pre = buckets[0].high;
    for (int i = 1; i < buckets.length; i++){
        if (buckets[i].low!= -1){
            res = Math.max(buckets[i].low - pre, res);
            pre = buckets[i].high;
        }
    }
    return res;
    
}
