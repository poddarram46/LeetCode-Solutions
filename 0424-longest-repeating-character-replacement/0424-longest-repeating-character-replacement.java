
class Solution {
    public int characterReplacement(String s, int k) {

        int[] freq = new int[26];

        int left = 0;
        int maxFreq = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {

            // Count character frequency
            freq[s.charAt(right) - 'A']++;

            // Maximum frequency in current window
            maxFreq = Math.max(maxFreq,
                    freq[s.charAt(right) - 'A']);

            // Check how many replacements are needed
            while ((right - left + 1) - maxFreq > k) {

                freq[s.charAt(left) - 'A']--;
                left++;
            }

            // Update maximum length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
