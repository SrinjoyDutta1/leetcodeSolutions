// 1249. Minimum Remove to Make Valid Parentheses
// Medium
// Topics
// Companies
// Hint
// Given a string s of '(' , ')' and lowercase English characters.

// Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

// Formally, a parentheses string is valid if and only if:

// It is the empty string, contains only lowercase characters, or
// It can be written as AB (A concatenated with B), where A and B are valid strings, or
// It can be written as (A), where A is a valid string.

class Solution1249 {
    public String minRemoveToMakeValid(String s) {
        StringBuilder left = new StringBuilder("");
        int leftParen = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftParen++;
                left.append(c);
            } else if (c == ')') {
                if (leftParen > 0) {
                    leftParen--;
                    left.append(c);                    
                }
            } else {
                left.append(c);
            }
        }
        StringBuilder right = new StringBuilder("");
        int rParen = 0;
        for (int i = left.length()-1; i >= 0; i--) {
            char c = left.charAt(i);
            if (c == '(') {
                if (rParen > 0) {
                    rParen--;
                    right.insert(0, c);
                }
            } else if (c == ')') {
                rParen++;
                right.insert(0, c);
            } else {
                right.insert(0, c);
            }
        }
        return right.toString();
    }
}
