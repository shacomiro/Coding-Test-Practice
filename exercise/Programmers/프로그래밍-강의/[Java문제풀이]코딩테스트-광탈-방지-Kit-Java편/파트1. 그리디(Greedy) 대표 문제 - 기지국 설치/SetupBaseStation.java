class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int idx = 0;
        int currStation = 0;
        
        while(idx < n) {
            if(currStation < stations.length && idx >= stations[currStation] - 1 - w) {
                idx = stations[currStation++] + w;
            } else {
                answer++;
                idx += w * 2 + 1;
            }
        }

        return answer;
    }
}