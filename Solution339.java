// 339. Nested List Weight Sum
// Solved
// Medium
// Topics
// Companies
// You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists.

// The depth of an integer is the number of lists that it is inside of. For example, the nested list [1,[2,2],[[3],2],1] has each integer's value set to its depth.

// Return the sum of each integer in nestedList multiplied by its depth.


/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null) return 0;
        int sum = traverseList(nestedList, 1);
        return sum;
    }
    public int traverseList(List<NestedInteger>list, int level) {
        int sum = 0;
        for (NestedInteger n : list) {
            if (n.isInteger()) {
                sum+= level*n.getInteger();
            } else { 
                sum += traverseList(n.getList(),level+1);
            }
        }
        
        return sum;
    }
}
