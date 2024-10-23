/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        HashMap <Node, Integer>seenNodes = new HashMap<>();
        while (p != null) {
            seenNodes.put(p,1);
            p = p.parent;
        }
        while (q != null) {
            if (seenNodes.containsKey(q)) {
                return q;
            }
            
            q = q.parent;
        }
        return null;
        
    }

}
