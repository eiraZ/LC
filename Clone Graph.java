/*
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
         
Solution: BFS: level by level. visited node!!!!!!!
          DFS: 
*/

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
 
  public UndirectedGraphNode cloneGraph_BFS(UndirectedGraphNode node) {
        if (node == null) return null;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

        LinkedList<UndirectedGraphNode> curLevel = new LinkedList<UndirectedGraphNode>();
        curLevel.offer(node);
        
        while (curLevel.size() > 0){
            LinkedList<UndirectedGraphNode> nextLevel = new LinkedList<UndirectedGraphNode>();
            
            while (curLevel.size() > 0){
                UndirectedGraphNode orig = curLevel.poll();
                UndirectedGraphNode copy = null;
                if(!map.containsKey(orig)){
                    map.put(orig, new UndirectedGraphNode(orig.label));
                }
                copy = map.get(orig);
                for (UndirectedGraphNode neighbor: orig.neighbors){
                    if (!map.containsKey(neighbor)){
                        map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                        nextLevel.offer(neighbor);
                    }
                    copy.neighbors.add(map.get(neighbor));
                }
            }
            
            curLevel = nextLevel;
        }
        return map.get(node);
        
  }
  
  public UndirectedGraphNode cloneGraph_DFS(UndirectedGraphNode node) {
        if (node == null) return null;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        
        clone(node, map);
        return map.get(node);
    }
    
  private UndirectedGraphNode clone(UndirectedGraphNode node,HashMap<UndirectedGraphNode, UndirectedGraphNode> map){
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);
        map.put(node, new UndirectedGraphNode(node.label));
    
        for (UndirectedGraphNode neighbor: node.neighbors){
            UndirectedGraphNode copyNeighbor = clone(neighbor, map);
            map.get(node).neighbors.add(copyNeighbor);
        }
        return map.get(node);
        
    }
