class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int val : nums){
            pq.offer(val);
        }
        for(int i=0;i<k - 1;i++){
            pq.poll();
        }
        return pq.poll();
    }
}