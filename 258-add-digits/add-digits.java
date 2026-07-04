public class Solution {
    public int addDigits(int num) {
        if (num == 0) {
            return 0;
        }
        if (num % 9 == 0) {
            return 9;
        }
        return num % 9;
    }
    public static void main(String[] args) {
        Solution solver = new Solution();
        int num1 = 38;
        System.out.println("Input: " + num1 + " -> Output: " + solver.addDigits(num1));
        int num2 = 0;
        System.out.println("Input: " + num2 + " -> Output: " + solver.addDigits(num2));
        int num3 = 999;
        System.out.println("Input: " + num3 + " -> Output: " + solver.addDigits(num3));
    }
}
