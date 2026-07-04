public class Solution {
    public int totalFruit(int[] fruits) {
        int maxFruits = 0;
        int left = 0;
        int basket1 = -1, basket2 = -1;
        int count1 = 0, count2 = 0;
        for (int right = 0; right < fruits.length; right++) {
            int currentFruit = fruits[right];
            if (currentFruit == basket1 || basket1 == -1) {
                basket1 = currentFruit;
                count1++;
            } 
            else if (currentFruit == basket2 || basket2 == -1) {
                basket2 = currentFruit;
                count2++;
            } 
            else {
                while (count1 > 0 && count2 > 0) {
                    int leftFruit = fruits[left];
                    if (leftFruit == basket1) {
                        count1--;
                    } else if (leftFruit == basket2) {
                        count2--;
                    }
                    left++;
                }
                if (count1 == 0) {
                    basket1 = currentFruit;
                    count1 = 1;
                } else {
                    basket2 = currentFruit;
                    count2 = 1;
                }
            }
            maxFruits = Math.max(maxFruits, right - left + 1);
        }
        return maxFruits;
    }
}
