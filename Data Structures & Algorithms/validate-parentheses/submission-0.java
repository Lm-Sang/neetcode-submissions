class Solution {
    public boolean isValid(String s) {
        // 40-41, 91-93, 123-125 
        int st, e, i = 0, j = s.length() - 1;
        if (s.length() % 2 != 0) return false;
        while (i < j){
            st = (int)s.charAt(i);
            e = (int)s.charAt(j);
            if (st != e - 1 && st != e - 2) return false;
            i++;
            j--;
        }
        return true;
    }
}
