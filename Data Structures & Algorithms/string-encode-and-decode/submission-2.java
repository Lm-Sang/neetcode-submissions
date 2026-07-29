class Solution {

    public String encode(List<String> strs) {
        String encoded_str = "";
        for (int i = 0; i < strs.size(); i++){
            encoded_str += strs.get(i) + " ";
        }
        return encoded_str;
    }

    public List<String> decode(String str) {
        List<String> decoded_str = new ArrayList<>();
        String temp = "";
        char c = 'a';
        for (int i = 0; i < str.length(); i++){
            c = str.charAt(i);
            if (c == ' '){
                decoded_str.add(temp);
                temp = "";
                continue;
            }
            temp += c;
        }
        return decoded_str;
    }
}
