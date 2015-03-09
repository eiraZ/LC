/*
Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.

Solution: implement a comparator for the sort. reversed sort
*/

public String largestNumber(int[] num) {
        if(num.length == 0) return "";
        
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i< num.length; i++){
            list.add(num[i]);
        }
        
        Comparator<Integer> cmp = new Comparator<Integer>(){
            public int compare(Integer in1, Integer in2){
                String s1 = ""+in1 + in2;
                String s2 = "" + in2 + in1;
                return s2.compareTo(s1);
            }    
        };
        Collections.sort(list, cmp);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<list.size(); i++){
            sb.append(list.get(i));
        }
        if(sb.charAt(0) == '0') return "0";
        return sb.toString();
        
    }
