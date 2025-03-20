import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        long single = Integer.MAX_VALUE;
        long pair = Integer.MAX_VALUE;
        long triple = 0;
        int max = 0;
        long sum = 0;

        for (int i = 0; i < 6; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            single = Math.min(single, nums[i]);
            max = Math.max(max, nums[i]);
            sum += nums[i];
        }

        if (n == 1) {
            System.out.println(sum - max);

            return;
        }

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i == j || i + j == 5) {
                    continue;
                }

                pair = Math.min(nums[i] + nums[j], pair);
            }
        }

        for (int i = 0; i < 3; i++) {
            triple += Math.min(nums[i], nums[5 - i]);
        }

        long singleSum = (4L * (n - 2) * (n - 1) + (long) (n - 2) * (n - 2)) * single;
        long pairSum = (4L * (n - 1) + 4L * (n - 2)) * pair;
        long tripleSum = 4 * triple;
        sum = singleSum + pairSum + tripleSum;

        System.out.println(sum);
    }

}
