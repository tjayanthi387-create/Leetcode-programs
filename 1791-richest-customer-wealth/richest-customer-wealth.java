public class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for (int[] customer : accounts) {
            int currentWealth = 0;
            for (int bank : customer) {
                currentWealth += bank;
            }
            if (currentWealth > maxWealth) {
                maxWealth = currentWealth;
            }
        }
        return maxWealth;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] accounts = {{1, 5}, {7, 3}, {3, 5}};
        System.out.println("Richest customer wealth: " + sol.maximumWealth(accounts)); 
    }
}
