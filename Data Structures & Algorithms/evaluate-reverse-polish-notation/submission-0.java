class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> temp = new ArrayDeque<>();

        for (int i = 0; i < tokens.length; i++){
            if (isNumber(tokens[i])){
                temp.offerLast(Integer.parseInt(tokens[i]));
            }
            else{
                int a, b;
                a = temp.pollLast();
                b = temp.pollLast();
                if (tokens[i].equals("+")){
                    temp.offerLast(b+a);
                }
                else if (tokens[i].equals("-")){
                    temp.offerLast(b-a);
                }
                else if (tokens[i].equals("*")){
                    temp.offerLast(b*a);
                }
                else if (tokens[i].equals("/")){
                    temp.offerLast(b/a);
                }
            }
        }
        return temp.peek();
        
    }
    public boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
