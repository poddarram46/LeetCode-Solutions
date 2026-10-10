import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            // Jab tak duplicate character mile, left ko aage badhao
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            // Current character ko set mein add karo
            set.add(s.charAt(right));

            // Maximum substring length update karo
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}