class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];

        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int left = 1;
        int right = max;

        while (left <= right) {
            int k = left + (right - left) / 2;

            int hours = sum(piles, k);

            if (hours <= h) {
                right = k - 1;
            } else {
                left = k + 1;
            }
        }

        return left;
    }

    public int sum(int[] piles, int k) {
        int hours = 0;

        for (int pile : piles) {
            hours += (pile + k - 1) / k;
        }

        return hours;
    }
}