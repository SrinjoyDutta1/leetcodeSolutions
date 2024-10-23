/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */ 
class Solution {
    //level, value
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        TreeMap<Integer, List<Integer>> mapTracker = new TreeMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> columnTracker = new LinkedList<>();
        int level = 0;
        queue.add(root);
        columnTracker.add(0);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            Integer currentCol = columnTracker.poll();
            if (current != null) {
                //mapTracker.put(currentCol, current.val); change implemention to list
                if (mapTracker.get(currentCol) == null) {
                    List<Integer> arr = new ArrayList<>();
                    arr.add(current.val);
                    mapTracker.put(currentCol,arr);
                } else {
                    List<Integer> arr = mapTracker.get(currentCol);
                    arr.add(current.val);
                    mapTracker.put(currentCol,arr);
                }
                if (current.left != null) {
                    queue.add(current.left);
                    columnTracker.add(currentCol-1); 
                }
                if (current.right != null) {
                    queue.add(current.right);
                    columnTracker.add(currentCol+1);
                }
            }   
        }
        for (Integer key : mapTracker.keySet()) {
            result.add(mapTracker.get(key));
        }
        return result;
    }
   
}
