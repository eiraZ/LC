/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Solution: (1) Moore voting algorithm. assume there always exists a majority element.
          (2) Bit manipulation. compare it one-bit by one-bit. # of one or zero
          (3) hashtable
          (4) Quick selection. target must be the median in this array: find kth element. O(n)
*/
public int majorityElement_Moore(int[] num) {
    // res: target, count: # of times for current target. Assume majority element always exists 
    if (num.length == 0 ) return -1;
    int count = 1;
    int res = num[0];
    for (int i = 1; i<num.length; i++){
        if (count == 0){
            res = num[i];
            count = 1;
            continue;
        }
        if (res == num[i]) count++;
        else count--;             //num[i] is not res, it means percentage decreases
    }
    return res;
}

public int majorityElement_BitMani(int[] num) {
    if(num.length == 0 ) return -1;
    if (num.length == 1) return num[0];
    int res = 0;
    for (int i = 0; i<32; i++){
        int one = 0;
        int zero = 0;
        for (int j = 0; j<num.length; j++){
            if (((num[j]>>i) & 1) == 1) one++;
            else zero++;
        }
        if(one > zero){
            res = res|(1<<i);
        }
    }
    return res;
    
}

public int majorityElement(int[] num){
        if(num.length == 0 ) return -1;
        if (num.length == 1) return num[0];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<num.length; i++){
            if(!map.containsKey(num[i])){
                map.put(num[i], 1);
            }else{
                map.put(num[i], map.get(num[i])+1);
            }
        }
        int m = num.length/2;
        int res = num[0];
        Iterator<Map.Entry<Integer, Integer>> iter = map.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<Integer, Integer> entry = iter.next();
            int v = entry.getValue();
            int k = entry.getKey();
            if(v>=m){
                res = v>(map.get(res))? k : res;
            }
        }
        return res;
    
}

    public int majorityElementQS(int[] num) {
        int len = num.length;
        return findKth(num, 0, num.length-1, len/2);
    }
    
    private int findKth(int[] num, int left, int right, int k){
        if(left == right)   return num[left];
        while (left <= right){
            int index = partition(num, left, right);
            if (k == index){
                return num[k];
            }else if(index < k){
                left = index + 1;
            }else{
                right = index - 1;
            }
        }
        return -1;
    }
    
    private int partition(int[] num, int left, int right){
        if(left > right)    return -1;
        int pivot = num[(left+right)/2];
        swap(num, (left+right)/2, right);
        int start = left;
        for (int i = left; i < right; i++){
            if(num[i] < pivot){
                swap(num, i, start);
                start++;
            }
        }
        swap(num, start, right);
        return start;
    }
    
    private void swap(int[] num, int left, int right){
        int temp = num[right];
        num[right] = num[left];
        num[left] = temp;
    }
