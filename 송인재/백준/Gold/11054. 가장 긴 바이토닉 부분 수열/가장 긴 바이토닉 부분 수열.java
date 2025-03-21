import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] up = new int[n];
        int[] down = new int[n];
        up[0] = 1;
        down[n - 1] = 0;

        for (int i = 1; i < n; i++) {
            int maxUp = 1;
            int maxDown = 0;

            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxUp = Math.max(maxUp, up[j] + 1);
                }

                if (nums[n - 1 - i] > nums[n - 1 - j]) {
                    maxDown = Math.max(maxDown, down[n - 1 - j] + 1);
                }
            }

            up[i] = maxUp;
            down[n - 1 - i] = maxDown;
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, up[i] + down[i]);
        }

        System.out.println(max);
    }

}
