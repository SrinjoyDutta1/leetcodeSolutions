// 408. Valid Word Abbreviation
// Solved
// Easy
// Topics
// Companies
// A string can be abbreviated by replacing any number of non-adjacent, non-empty substrings with their lengths. The lengths should not have leading zeros.

// For example, a string such as "substitution" could be abbreviated as (but not limited to):

// "s10n" ("s ubstitutio n")
// "sub4u4" ("sub stit u tion")
// "12" ("substitution")
// "su3i1u2on" ("su bst i t u ti on")
// "substitution" (no substrings replaced)
// The following are not valid abbreviations:

// "s55n" ("s ubsti tutio n", the replaced substrings are adjacent)
// "s010n" (has leading zeros)
// "s0ubstitution" (replaces an empty substring)
// Given a string word and an abbreviation abbr, return whether the string matches the given abbreviation.

// A substring is a contiguous non-empty sequence of characters within a string.
class Solution408 {
    public boolean validWordAbbreviation(String word, String abbr) {
        int totalWordCount = 0;
        int currentNum = 0;
        for (int i = 0; i < abbr.length(); i++) {
            char c = abbr.charAt(i);
            if (Character.isDigit(c)) {
                if (currentNum == 0 && c == '0') return false;
                currentNum = currentNum*10+(c-'0'); //1
                if (i != abbr.length()-1 && !Character.isDigit(abbr.charAt(i+1))) {
                    totalWordCount+=currentNum;
                    currentNum = 0;
                } 
            } else if (totalWordCount < word.length() && c == word.charAt(totalWordCount)){ 
                totalWordCount++;
            } else {
                return false;
            }
        }
        if (currentNum > 0) {
            totalWordCount+= currentNum;
        }
        if (totalWordCount != word.length()) return false;
        return true;
    }
}
