/*
Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, 
such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.

Solution: BFS. Set<String> visited:  used or not
               pre: visited word
               change every char in a word to see if there's a match in dict. yes-> offer in next List
*/

public int ladderLength(String start, String end, Set<String> dict) {
    if (start.length() == 0) return 0;
    
    Set<String> used = new HashSet<String>();
    
    LinkedList<String> queue = new LinkedList<String>();
    
    queue.offer(start);
    used.add(start);
    int level = 1;
    
    while (queue.size() > 0){
        LinkedList<String> next = new LinkedList<String>();
        
        while (queue.size() > 0){
            String cur = queue.poll();
            char[] wordChar = cur.toCharArray();
            
            for (int i = 0; i<wordChar.length; i++){
                char c = wordChar[i];
                for (char t = 'a'; t <= 'z'; t++){
                    wordChar[i] = t;
                    if ( c == t) continue;
                    String temp = new String(wordChar);
                    if(temp.equals(end)){
                        level++;
                        used.add(cur);
                        return level;
                    }
                    if (!dict.contains(temp)) continue;
                    if (used.contains(temp)) continue;
                    used.add(temp);
                    next.offer(temp);
                }
                wordChar[i] = c;
                
            }
        }
        
        level++;
        queue = next;
    }
    
    return 0;
    
}

