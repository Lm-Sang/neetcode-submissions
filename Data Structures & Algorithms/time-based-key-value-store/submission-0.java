class TimeMap {

    HashMap<String, HashMap<Integer, String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)){
            map.put(key, new HashMap<>());
        }
        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        HashMap<Integer, String> temp = map.get(key);
        if (temp.containsKey(timestamp)){
            return temp.get(timestamp);
        }
        
    }
}
