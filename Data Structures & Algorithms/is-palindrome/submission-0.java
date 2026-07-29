class Solution {
    public boolean isPalindrome(String s) {
        Character[] chars = new Character[s.length()];
        Character[] chare = new Character[s.length()];
        int idx1 = 0;
        int idx2 = 0;   
        for (int i = s.length() - 1, j = 0; i >= 0; i--, j++) {

            if (Character.isLetterOrDigit(s.charAt(i))) {
                chars[idx1++] = Character.toLowerCase(s.charAt(i));;
            }
            if (Character.isLetterOrDigit(s.charAt(j))) {
                chare[idx2++] = Character.toLowerCase(s.charAt(j));;
            }
        }

        return Arrays.equals(chars, chare);
    }
}
