class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;

        int k1 = (total - 1) / 2;
        int k2 = total / 2;

        int value1 = findKth(nums1, nums2, k1);
        int value2 = findKth(nums1, nums2, k2);

        return (value1 + value2) / 2.0;
    }

    private int findKth(int[] nums1, int[] nums2, int k) {
        int left = Math.min(nums1[0], nums2[0]);
        int right = Math.max(
            nums1[nums1.length - 1],
            nums2[nums2.length - 1]
        );

        while (left <= right) {
            int candidate = left + (right - left) / 2;

            int count = countLess(nums1, candidate)
                    + countLess(nums2, candidate);
            if (count == k) {
                return candidate;
            }
            if (count < k) {
                left = candidate + 1;
            } else {
                right = candidate - 1;
            }
        }

        return left;
    }

    private int countLess(int[] nums, int value) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}