import java.util.*;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        long sum = 0;
        long maxSum = 0;

        // NEW: HashMap for frequency
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            // Add new element
            sum += nums[i];

            // NEW: Store frequency
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            // Remove outgoing element
            if (i >= k) {
                sum -= nums[i - k];

                // NEW: Decrease frequency
                map.put(nums[i - k], map.get(nums[i - k]) - 1);

                // NEW: Remove if frequency becomes zero
                if (map.get(nums[i - k]) == 0) {
                    map.remove(nums[i - k]);
                }
            }

            // Check window size and distinct elements
            if (i >= k - 1 && map.size() == k) {
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}