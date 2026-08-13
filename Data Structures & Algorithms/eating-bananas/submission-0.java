class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int temp = h / piles.length;
        int k, res = 0;
        int max = piles[0];
        for (int i = 1; i < piles.length; i++) {
            if (piles[i] > max) {
                max = piles[i];
            }
        }
        for (int i = temp; i <= max; i += temp){
            k = max / i;
            for (int j = 0; j < piles.length; j++){
                if (piles[j] % k != 0){
                    res += piles[j] / k + 1;
                }
                else {
                    res += piles[j] / k;
                }
            }
            if (res <= h){
                return k;
            }
            else res = 0;
        }
        return 0;
    }
}
