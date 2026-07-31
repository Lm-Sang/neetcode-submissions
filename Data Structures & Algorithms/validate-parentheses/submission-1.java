class Solution {
    public boolean isValid(String s) {
        // 40-41, 91-93, 123-125 
        Stack<Character> stack = new Stack<>();
        char c,a;
        for (int i = 0; i < s.length(); i++){
            a = s.charAt(i);
            if (a == ')'){
                c = stack.pop();
                if ((int) c + 1 != (int) a) return false;
                continue;
            }
            if (a == '}'){
                c = stack.pop();
                if ((int) c + 2 != (int) a) return false;
                continue;
            }
            if (a == ']'){
                c = stack.pop();
                if ((int) c + 2 != (int) a) return false;
                continue;
            }
            stack.add(a);
        }
        return true;
    }
}
