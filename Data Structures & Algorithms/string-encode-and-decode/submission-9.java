class Solution {

    public String encode(List<String> strs) {
        String encoded_str = "";
        for (int i = 0; i < strs.size(); i++){
            encoded_str += strs.get(i).length() + "#" + strs.get(i);
        }
        return encoded_str;
    }

    public List<String> decode(String str) {
        List<String> decoded_str = new ArrayList<>();
        String temp = "";
        int i = 0;
        String c = "";
        while (i < str.length()){
            if (str.charAt(i) == '#'){
                int x = Integer.parseInt(c);
                for (int t = i + 1; t <= i + x; t++){
                    char b = str.charAt(t);
                    temp += b;
                }
                decoded_str.add(temp);
                temp = "";
                i += x + 1;
                c = "";
                continue;
            }
            c += str.charAt(i);
            i += 1;
        }
        
        return decoded_str;
    }
}
