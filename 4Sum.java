/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
    
    Solution: 1. sort, 2 pointers. O(n^3)
              2. Divide and conquer: 4 sum->2 sum. get All combinations of 2 sum, store in a hashmap.
                 take care for the duplicates.
*/
public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(num.length<4){
            return res;
        }
        Arrays.sort(num);
        /* if: remove duplicates;
            or: at the end, apply while
        */
        for (int i=0; i<num.length-3; i++){
            if (i>0 && num[i] == num[i-1]){
                continue;
            }
            for (int j = i+1; j<num.length-2; j++){
                if (j>i+1 && num[j] == num[j-1]) continue;
                int left = j+1;
                int right = num.length -1;
                while(left<right){
                    int temp = num[i] + num[j] + num[left] + num[right];
                    if (temp==target){
                        List<Integer> ele = new ArrayList<Integer>();
                        ele.add(num[i]);
                        ele.add(num[j]);
                        ele.add(num[left]);
                        ele.add(num[right]);
                        res.add(ele);
                        
                        left++;
                        right--;
                        while (left<right && num[left-1]==num[left]) left++;
                        while (left<right && num[right+1] ==num[right]) right--;
                        
                    }else if(temp<target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return res;
    }
    
    
    public List<List<Integer>> fourSum_DivideConquer(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num.length < 4) return res;
        Map<Integer, List<List<Integer>>> twoSum = new HashMap<Integer, List<List<Integer>>>();
        
        for (int i = 0; i< num.length - 1; i++){
            for (int j = i+1; j< num.length; j++){
                int temp = num[i] + num[j];
                if (!twoSum.containsKey(temp)){
                    List<List<Integer>> pairList = new ArrayList<List<Integer>>();
                    twoSum.put(temp, pairList);
                }
                List<Integer> pairs = new ArrayList<Integer>();
                pairs.add(i);
                pairs.add(j);
                twoSum.get(temp).add(pairs);
            }
        }
        //twoSum.entrySet();
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        for(Integer sum: twoSum.keySet()){
            List<List<Integer>> pairList = twoSum.get(sum);
            if(twoSum.containsKey(target - sum)){
                for (List<Integer> pair: pairList){
                    for(List<Integer> otherPair: twoSum.get(target- sum)){
                        List<Integer> ele = new ArrayList<Integer>();
                        
                        if(pair.contains(otherPair.get(0))) continue;
                        if(pair.contains(otherPair.get(1))) continue;
                        // if(pair.get(0).equals(otherPair.get(0)))    continue;
                        // if(pair.get(0).equals(otherPair.get(1)))    continue;
                        // if(pair.get(1).equals(otherPair.get(0)))    continue;
                        // if(pair.get(1).equals(otherPair.get(1)))    continue;
                        
                        ele.add(num[pair.get(0)]);
                        ele.add(num[pair.get(1)]);
                        ele.add(num[otherPair.get(0)]);
                        ele.add(num[otherPair.get(1)]);
                        Collections.sort(ele);
                        
                        set.add(ele);
                    }
                }
            }
        }
        
        Iterator<List<Integer>> iter = set.iterator();
        while(iter.hasNext()){
            res.add(iter.next());
        }
        
        return res;
        
    }
