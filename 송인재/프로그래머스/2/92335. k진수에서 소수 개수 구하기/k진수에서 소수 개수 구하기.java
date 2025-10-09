import java.util.*;

class Solution {
    public int solution(int n, int k) {
        StringBuilder sb = new StringBuilder();
        
        while (n > 0) {
            sb.append(n % k);
            
            n /= k;
        }
        
        String converted = sb.reverse().toString();
        String[] splited = converted.split("0");
        List<String> numbers = new ArrayList<>();
        
        for (String num : splited) {
            if (!num.equals("")) {
                numbers.add(num);
            }
        }
        
        int primes = 0;
        
        for (String value : numbers) {
            long number = Long.parseLong(value);
            
            if (number == 1) {
                continue;
            }
            
            int root = ((int) Math.sqrt(number)) + 1;
            boolean[] rootPrime = new boolean[root + 1];
            boolean isPrime = true;
            
            for (int i = 2; i <= root; i++) {
                rootPrime[i] = true;
            }
            
            for (int i = 2; i <= root; i++) {
                if (!rootPrime[i]) {
                    continue;
                }
                
                int index = i + i;
                
                while (index <= root) {
                    rootPrime[index] = false;
                    index += i;
                }
                
                if (number != i && number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            
            if (isPrime) {
                primes++;
            }
        }
        
        return primes;
    }
}