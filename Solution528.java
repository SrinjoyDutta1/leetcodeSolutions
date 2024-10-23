class Solution {
    int[]prefixSum;
    Random random;
    public Solution(int[] w) {
        prefixSum = new int[w.length];
        prefixSum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            prefixSum[i]=prefixSum[i-1]+w[i];
        }
        random = new Random();
    }
    
    public int pickIndex() {
        int found = random.nextInt(prefixSum[prefixSum.length-1])+1;
        int left = 0;
        int right = prefixSum.length-1;


        while (left < right) {
            int middle = left+(right-left)/2;
            if (prefixSum[middle] < found){
                left=middle+1;
            } else right=middle;            
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
