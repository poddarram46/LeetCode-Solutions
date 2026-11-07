
import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        int n = nums.length;

        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Fix first element
        for (int i = 0; i < n - 3; i++) {

            // Skip duplicate i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Step 3: Fix second element
            for (int j = i + 1; j < n - 2; j++) {

                // Skip duplicate j
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // Step 4: Initialize two pointers
                int left = j + 1;
                int right = n - 1;

                // Step 5: Apply Two Pointer
                while (left < right) {

                    // Calculate sum using long to avoid overflow
                    long sum = (long) nums[i] + nums[j]
                               + nums[left] + nums[right];

                    // If sum equals target
                    if (sum == target) {

                        ans.add(Arrays.asList(
                            nums[i], nums[j],
                            nums[left], nums[right]
                        ));

                        left++;
                        right--;

                        // Skip duplicate left
                        while (left < right &&
                               nums[left] == nums[left - 1]) {
                            left++;
                        }

                        // Skip duplicate right
                        while (left < right &&
                               nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }

                    // If sum is smaller than target
                    else if (sum < target) {
                        left++;
                    }

                    // If sum is greater than target
                    else {
                        right--;
                    }
                }
            }
        }

        return ans;
    }
}
