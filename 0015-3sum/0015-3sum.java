
import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Fix first element
        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate first elements
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Step 3: Initialize two pointers
            int left = i + 1;
            int right = nums.length - 1;

            // Step 4: Apply Two Pointer
            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                // If sum is zero, triplet found
                if (sum == 0) {

                    ans.add(Arrays.asList(
                        nums[i], nums[left], nums[right]
                    ));

                    left++;
                    right--;

                    // Skip duplicate left elements
                    while (left < right &&
                           nums[left] == nums[left - 1]) {
                        left++;
                    }

                    // Skip duplicate right elements
                    while (left < right &&
                           nums[right] == nums[right + 1]) {
                        right--;
                    }
                }

                // If sum is negative, increase left
                else if (sum < 0) {
                    left++;
                }

                // If sum is positive, decrease right
                else {
                    right--;
                }
            }
        }

        return ans;
    }
}
