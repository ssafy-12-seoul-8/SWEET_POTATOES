import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int pisano = 1_500_000;
        long n = Long.parseLong(br.readLine());
        long size = n % pisano;
        int[] fibo = new int[pisano + 1];
        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i <= pisano; i++) {
            fibo[i] = (fibo[i - 2] + fibo[i - 1]) % 1_000_000;
        }

        System.out.println(fibo[(int) size]);
    }

}
