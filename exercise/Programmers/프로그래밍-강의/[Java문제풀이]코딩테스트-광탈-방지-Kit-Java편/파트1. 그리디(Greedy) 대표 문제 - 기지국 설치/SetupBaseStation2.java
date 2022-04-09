class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int beginCheck = 0;
        
        for(int si = 0; si < stations.length; si++) {
            int sStart, sEnd;
            
            if((stations[si] - 1) - w >= 0) sStart = (stations[si] - 1) - w;
            else sStart = 0;
            if((stations[si] - 1) + w < n) sEnd = (stations[si] - 1) + w;
            else sEnd = n - 1;
            
            answer += (sStart - beginCheck) / (w * 2 + 1);
            if((sStart - beginCheck) % (w * 2 + 1) > 0)
                answer++;

            beginCheck = sEnd + 1;
            
            if(sEnd != n - 1 && si == stations.length - 1) {
                answer += (n - beginCheck) / (w * 2 + 1);
                if((n - beginCheck) % (w * 2 + 1) > 0)
                    answer++;
            }
        }

        return answer;
    }
}