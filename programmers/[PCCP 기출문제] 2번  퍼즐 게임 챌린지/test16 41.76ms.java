class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        return binarySearch(diffs, times, limit);
    }
    public int binarySearch(int [] diffs, int [] times, long limit) {
        int min = 1; 
        int max = 100000;
        while( min < max  ){
            int level = (max + min) / 2;
            long solvedTime = getTime(diffs,times,level);
            if(limit >= solvedTime){
                max = level;
            }
            else {
                min = level + 1;
            }
        }
        return min;
    }

    public long getTime(int [] diffs, int [] times, int level) {
        long ans = 0;
        for(int i = 0; i < diffs.length; i++){
            if(diffs[i] <= level) ans += times[i];
            else ans += (long)(times[i] + times[i-1])* (long)(diffs[i] - level) + times[i];
        }
        return ans;
    }
}