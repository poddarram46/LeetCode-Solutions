
class Solution {
    public void sortColors(int[] nums) {

        // Three pointers
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        // Traverse array
        while (mid <= high) {

            // Case 1: Current element is 0
            if (nums[mid] == 0) {

                // Swap low and mid
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;

                low++;
                mid++;
            }

            // Case 2: Current element is 1
            else if (nums[mid] == 1) {

                mid++;
            }

            // Case 3: Current element is 2
            else {

                // Swap mid and high
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;

                high--;
            }
        }
    }
}
