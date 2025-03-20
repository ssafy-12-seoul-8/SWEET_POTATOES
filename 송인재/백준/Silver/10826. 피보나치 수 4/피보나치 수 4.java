import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n <= 1) {
            System.out.println(n);

            return;
        }

        BigInteger[] fibo = new BigInteger[n + 1];
        fibo[0] = BigInteger.ZERO;
        fibo[1] = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            fibo[i] = fibo[i - 2].add(fibo[i - 1]);
        }

        System.out.println(fibo[n]);
    }

}
