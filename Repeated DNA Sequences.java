/*
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, 
for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].

Solution: 
          brute force: substring 10 characters at a time, and put this current substring in our memo such as hashset;
                       and compare. let n = s.length() >10, we'll cut and compare for (n-10 +1) times, O(10*(n-10+1)).
                       
          Improvement: we can find that we just 'delete' the character in the head and add another to the tail. Can we
                       use rolling hash? String -> Integer. if hash code is the same, we'll compare it one by one.
                       Can we do it better? use exact number to represent this sequence. That is bit-sequence.  
                       Since the sequence matters, and we just have 4 different chars. 2-bit for each char, sequence's length
                       is 10. We just need 20 bits to deal with a substring.
                       
          bit manipulation: use bit-sequence to represent a string
          00: 'A'; 01: 'C'; 10: 'G'; 11: 'T'
          10-letter long: we can use 20 bit to represent this sequence 
          map: visitedMap
          
        /* bit manipulation + rolling hash
        A,C, T, G: 4 character, we can use 2-bit to represent different char
        for every 10 characters, we convert this sequence into 1, 0 sequence
        save it in a map.
        scan from 11th characters, convert (x<<2)|s.charAt(i), and compare with map
        */
        
        
*/

public List<String> findRepeatedDnaSequences(String s) {
    List<String> res = new ArrayList<String>();
    if (s.length() <=10 ) return res;
    
    HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
    HashMap<Character, Integer> mole = new HashMap<Character, Integer>();
    
    mole.put('A', 0);
    mole.put('C', 1);
    mole.put('G', 2);
    mole.put('T', 3);
    
    int mask = (1<<20) - 1;
    int seq = 0;
    int i = 0;
    for (; i < 10; i++){
        seq = (seq<<2)|(mole.get(s.charAt(i)));
    }
    countMap.put(seq, 1);
    for (; i < s.length(); i++){
        seq = (seq<<2)|(mole.get(s.charAt(i)));
        seq = seq & mask; //flush bit >= 20
        if (countMap.containsKey(seq)){
            if (countMap.get(seq) == 1){    //unvisited
                String sub = convert(seq);
                res.add(sub);
                countMap.put(seq, -1);
            }
        }else{
            countMap.put(seq, 1);
        }
    }
    return res;
}

private String convert(int seq){
    StringBuilder sb = new StringBuilder();
   
    for (int i = 0; i < 10; i++){
        int temp = seq & 3;
        if(temp == 0){
            sb.insert(0, "A");
        }else if(temp == 1){
            sb.insert(0, "C");
        }else if(temp == 2){
            sb.insert(0, "G");
        }else{
            sb.insert(0, "T");
        }
        seq = (seq>>2);
    }
    return sb.toString();
}
