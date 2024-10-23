class Solution {
    public static boolean checkIfValidPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length()-1-i)) {
                return false;
            }
        }
        return true;
    }
    public static boolean validPalindrome(String s) {
        
        
        for (int i = 0; i < s.length(); i++) {
            int left = i; 
            int right = s.length()-1-i;
            if (s.charAt(left) != s.charAt(right)) {
                return checkIfValidPalindrome(s.substring(left, right)) || checkIfValidPalindrome(s.substring(left+1, right+1));
            }
        }
        return true;
    }
}
