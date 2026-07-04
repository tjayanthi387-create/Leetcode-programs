public class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        boolean[] basketUsed = new boolean[n];
        int unplacedCount = 0;
        for (int fruitQuantity : fruits) {
            boolean placed = false;
            for (int j = 0; j < n; j++) {
                if (!basketUsed[j] && baskets[j] >= fruitQuantity) {
                    basketUsed[j] = true; 
                    placed = true;
                    break; 
                }
            }
            if (!placed) {
                unplacedCount++;
            }
        }
        return unplacedCount;
    }
}
