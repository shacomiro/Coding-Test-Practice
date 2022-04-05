class Solution {
    public long solution(int w, int h) {
        long cut = 0;
        
        for(int x = 0; x < w; x++)
            cut += Math.ceil((double)(x + 1) * h / w) - Math.floor((double)x * h / w);
        
        return (long) w * h - cut;
    }
}
//+6