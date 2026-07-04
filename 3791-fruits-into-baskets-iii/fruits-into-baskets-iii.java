class Solution {
    private int[] tree;
    private int n;
    private void build(int node, int start, int end, int[] baskets) {
        if (start == end) {
            tree[node] = baskets[start];
            return;
        }
        int mid = start + (end - start) / 2;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;

        build(leftChild, start, mid, baskets);
        build(rightChild, mid + 1, end, baskets);
        
        tree[node] = Math.max(tree[leftChild], tree[rightChild]);
    }
    private int findAndUpdateLeftmost(int node, int start, int end, int target) {
        if (tree[node] < target) {
            return -1;
        }
        if (start == end) {
            int originalIndex = start;
            tree[node] = 0; 
            return originalIndex;
        }
        int mid = start + (end - start) / 2;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;
        int index = -1;
        if (tree[leftChild] >= target) {
            index = findAndUpdateLeftmost(leftChild, start, mid, target);
        } else {
            index = findAndUpdateLeftmost(rightChild, mid + 1, end, target);
        }
        tree[node] = Math.max(tree[leftChild], tree[rightChild]);
        return index;
    }
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        this.n = fruits.length;
        this.tree = new int[4 * n];
        build(0, 0, n - 1, baskets);
        int unplacedCount = 0;
        for (int fruitQuantity : fruits) {
            int basketIndex = findAndUpdateLeftmost(0, 0, n - 1, fruitQuantity);
            if (basketIndex == -1) {
                unplacedCount++;
            }
        }
        return unplacedCount;
    }
}
