class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];

        for (int i = 1; i < piles.length; i++) {
            if (piles[i] > max) {
                max = piles[i];
            }
        }

        int left = 1;
        int right = max;

        while (left <= right) {
            int k = left + (right - left) / 2;

            int res = sum(piles, k);

            if (res <= h) {
                right = k - 1;
            } else {
                left = k + 1;
            }
        }

        return left;
    }

    public int sum(int[] piles, int k) {
        int res = 0;

        for (int i = 0; i < piles.length; i++) {
            if (piles[i] % k != 0) {
                res += piles[i] / k + 1;
            } else {
                res += piles[i] / k;
            }
        }

        return res;
    }
}