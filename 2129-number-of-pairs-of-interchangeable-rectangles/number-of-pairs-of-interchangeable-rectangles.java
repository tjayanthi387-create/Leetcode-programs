import java.util.HashMap;
import java.util.Map;
public class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        Map<String, Long> ratioCounts = new HashMap<>();
        for (int[] rect : rectangles) {
            int width = rect[0];
            int height = rect[1];
            int gcdVal = gcd(width, height);
            String ratioKey = (width / gcdVal) + "/" + (height / gcdVal);
            ratioCounts.put(ratioKey, ratioCounts.getOrDefault(ratioKey, 0L) + 1);
        }
        long totalPairs = 0;
        for (long count : ratioCounts.values()) {
            if (count > 1) {
                totalPairs += (count * (count - 1)) / 2;
            }
        }
        return totalPairs;
    }
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
