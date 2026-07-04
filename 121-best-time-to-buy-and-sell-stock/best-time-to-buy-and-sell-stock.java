class Solution {
    public int maxProfit(int[] arr) {
        int minCp=arr[0],n=arr.length;
        int maxpro=0;
        for(int i=0;i<n;i++){
            if(arr[i]<minCp){
                minCp=arr[i];
            }
            else{
                int pro=arr[i]-minCp;
                if(pro>maxpro){
                    maxpro=pro;
                }
            }
        }
        return maxpro;
    }
}