import java.util.Arrays;

class Solution {
    public String solution(String s) {
        return Arrays.stream(s.toLowerCase()
                              .split(""))
            .reduce("", (a, b) -> a.isBlank() || a.charAt(a.length() - 1) == ' ' ? a + b.toUpperCase() : a + b);
    }
}