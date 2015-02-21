  /*
  Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
Solution: HashMap to store corresponding number. special case: CM: 900: 1000-100
  */
    
    
    public int romanToInt(String s) {
        int num=0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        
        for(int i=0; i<s.length(); i++){
            if (i < s.length()-1 && map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                num -=map.get(s.charAt(i));
            }else{
                num +=map.get(s.charAt(i));
            }
        }
 
        return num;
    }
