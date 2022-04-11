class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left + 1)];
        int idx = 0;
        
        for(long i = left; i < right + 1; i++) {
            long a = i / n;
            long b = i % n;
            
            if(a < b)
                answer[idx++] = (int) b + 1;
            else
                answer[idx++] = (int) a + 1;
        }
        
        return answer;
    }
}
//+11, over 30mins, 외부 풀이(velog.io/@hannahf97/프로그래머스-n2-배열-자르기) 참고.