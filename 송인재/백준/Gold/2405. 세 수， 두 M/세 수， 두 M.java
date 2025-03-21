import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);

        int max = 0;

        for (int i = 1; i < n - 1; i++) {
            int front = Math.abs((nums[0] + nums[i] + nums[i + 1]) - 3 * nums[i]);
            int back = Math.abs((nums[i - 1] + nums[i] + nums[n - 1]) - 3 * nums[i]);
            max = Math.max(max, Math.max(front, back));
        }

        System.out.println(max);
    }

}
