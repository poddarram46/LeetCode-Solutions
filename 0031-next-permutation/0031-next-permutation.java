class Solution {
    public void nextPermutation(int[] nums) {

        int n = nums.length;

        // Step 1: Breakpoint find karo
        int i = n - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: Greater element find karo
        if (i >= 0) {
            int j = n - 1;

            while (nums[j] <= nums[i]) {
                j--;
            }

            // Step 3: Swap
            swap(nums, i, j);
        }

        // Step 4: Suffix reverse using two pointers
        int left = i + 1;
        int right = n - 1;

        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    // Swap function
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}