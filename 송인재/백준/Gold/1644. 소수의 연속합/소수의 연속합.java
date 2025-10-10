import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] isPrime = new boolean[n + 1];
        Set<Long> accumSet = new HashSet<>();
        int primes = 0;
        int count = 0;

        if (n == 1) {
            System.out.println(0);

            return;
        }

        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= Math.sqrt(n) + 1; i++) {
            if (!isPrime[i]) {
                continue;
            }

            int index = i + i;

            while (index <= n) {
                isPrime[index] = false;
                index += i;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes++;
            }
        }

        long[] accum = new long[primes + 1];
        int accumIndex = 1;

        accumSet.add(0L);

        for (int i = 2; i <= n; i++) {
            if (!isPrime[i]) {
                continue;
            }

            accum[accumIndex] = accum[accumIndex - 1] + i;

            accumSet.add(accum[accumIndex++]);
        }

        for (int i = 0; i < accum.length; i++) {
            long diff = accum[i] - n;

            if (diff < 0) {
                continue;
            }

            if (accumSet.contains(diff)) {
                count++;
            }
        }

        System.out.println(count);
    }

}
