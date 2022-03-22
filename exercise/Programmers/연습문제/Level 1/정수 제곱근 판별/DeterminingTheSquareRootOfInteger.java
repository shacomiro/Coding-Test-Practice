class Solution {
    public long solution(long n) {
        double squareRoot = Math.sqrt(n);
        return squareRoot - (long)squareRoot > 0 ? -1 : (long)((squareRoot + 1) * (squareRoot + 1));
    }
}