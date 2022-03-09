class Solution {
    public String solution(int num) {
        return (num % 2 == 1 || num % 2 == -1 && num != 0) ? "Odd" : "Even";
    }
}