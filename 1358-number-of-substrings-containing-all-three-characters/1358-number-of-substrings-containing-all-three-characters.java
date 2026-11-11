
class Solution {
    public int numberOfSubstrings(String s) {

        int[] freq = new int[3];

        int left = 0;
        int count = 0;

        for (int right = 0; right < s.length(); right++) {

            // Add current character
            freq[s.charAt(right) - 'a']++;

            // Check whether all three characters exist
            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {

                // All substrings ending at right
                // and starting from left to right are valid
                count += s.length() - right;

                // Remove left character
                freq[s.charAt(left) - 'a']--;

                left++;
            }
        }

        return count;
    }
}
