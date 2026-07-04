class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        int[] tFreq = new int[128];
        for (char c : t.toCharArray()) {
            tFreq[c]++;
        }
        int[] windowFreq = new int[128];
        int left = 0;
        int right = 0;
        int requiredCount = t.length(); 
        int formedCount = 0; 
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            windowFreq[rightChar]++;
            if (tFreq[rightChar] > 0 && windowFreq[rightChar] <= tFreq[rightChar]) {
                formedCount++;
            }
            while (formedCount == requiredCount) {
                int currentWindowLen = right - left + 1;
                if (currentWindowLen < minLen) {
                    minLen = currentWindowLen;
                    startIndex = left;
                }
                char leftChar = s.charAt(left);
                windowFreq[leftChar]--;
                if (tFreq[leftChar] > 0 && windowFreq[leftChar] < tFreq[leftChar]) {
                    formedCount--;
                }
                left++; 
            }
            right++; 
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    }
}
