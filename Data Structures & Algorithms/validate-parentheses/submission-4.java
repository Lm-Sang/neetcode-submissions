class Solution {
    public boolean isValid(String s) {
        // 40-41, 91-93, 123-125 
        Stack<Character> stack = new Stack<>();
        char c,a;
        stack.add(s.charAt(0));
        if (s.length() % 2 !=0 ) return false;
        for (int i = 1; i < s.length(); i++){
            a = s.charAt(i);
            if (a == ')'){
                if (stack.isEmpty())return false;
                c = stack.pop();
                if ((int) c + 1 != (int) a) return false;
                continue;
            }
            if (a == '}'){
                if (stack.isEmpty())return false;
                c = stack.pop();
                if ((int) c + 2 != (int) a) return false;
                continue;
            }
            if (a == ']'){
                if (stack.isEmpty())return false;
                c = stack.pop();
                if ((int) c + 2 != (int) a) return false;
                continue;
            }
            stack.add(a);
        }
        return true;
    }
}
