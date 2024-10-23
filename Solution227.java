class Solution {
    public int calculate(String s) {    
        if (s.length() == 0 || s == null) return 0;
        char op = '+';
        int currentNum = 0;
        Stack<Integer>stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                currentNum = currentNum * 10 + (c-'0');
            }
            if ("+-/*".indexOf(c) != -1  || i == s.length()-1) {
                if (op == '+') {
                    stack.push(currentNum);
                } else if (op == '-') {
                    stack.push(-currentNum);
                } else if (op == '*') {
                    stack.push(stack.pop()*currentNum);
                } else if (op == '/') {
                    stack.push(stack.pop()/currentNum);
                }
                op = c;
                currentNum = 0;
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum+= stack.pop();
        }
        return sum;
    }
    
    
}

