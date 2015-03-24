/*
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Return 0 if the array contains less than 2 elements.

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.

Solution: (1) sort and find maximum gap. O(nlogn)
          (2) bucket sort + drawer theory. O(n)
              we really care about "gap", bucket sort provides a fix-size of bucket. this fix-size is "gap". we can make a 
              bucket size as our average gap. maximum gap > bucket size.
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
    
 int maxVal = num[0];
        int minVal = num[0];
        
        for (int i = 1; i < num.length; i++){
            maxVal = Math.max(maxVal, num[i]);
            minVal = Math.min(minVal, num[i]);
        }
        
        //int avgGap = (int)(Long.valueOf(maxVal - minVal + 1)/Long.valueOf(num.length + 1));
        
        Node[] nodes = new Node[num.length + 1];
        for (int i = 0; i < num.length+1; i++){
            nodes[i] = new Node();
        }
        
        for (int i = 0; i < num.length; i++){
            //int index = (num[i] - minVal)/avgGap;
            int index = (int)(Long.valueOf(num[i] - minVal) * Long.valueOf(num.length + 1) /Long.valueOf(maxVal - minVal + 1));
            if(nodes[index].low == -1){
                nodes[index].low = num[i];
                nodes[index].high = num[i];
            }else{
                nodes[index].low = Math.min(nodes[index].low, num[i]);
                nodes[index].high = Math.max(nodes[index].high, num[i]);
            }
        }
        int res = Integer.MIN_VALUE;
        int pre = nodes[0].high;
        for (int i = 1; i<=num.length; i++){
            if(nodes[i].low!= -1){
                res = Math.max(res, nodes[i].low - pre);
                pre = nodes[i].high;
            }
        }
        return res;
    
}
