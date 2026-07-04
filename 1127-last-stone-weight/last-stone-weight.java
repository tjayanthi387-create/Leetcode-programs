class Solution {
    public int lastStoneWeight(int[] stones) {
        ArrayList<Integer> al = new ArrayList<>();
        for(int val : stones){
            al.add(val);
        }
        while(al.size() > 1){
            Collections.sort(al);
            int top1 = al.remove(al.size() - 1);
            int top2 = al.remove(al.size() - 1);
            if(top1 != top2){
                al.add(top1 - top2);
            }
        }
        return al.size() == 1 ? al.get(0) : 0;
    }
}