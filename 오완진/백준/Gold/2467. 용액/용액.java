import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception, IOException {
        // 백준 2467 용액
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        int leftIdx = 0;
        int rightIdx = 0;
        int left = 0;
        int right = N - 1;
        int answer1 = 0;
        int answer2 = 0;
        for (int i = 0; i < N - 1; i++) {
            int tmp = arr[left] + arr[right];
            if (Math.abs(tmp) < Math.abs(min)) {
                min = tmp;
                leftIdx = arr[left];
                rightIdx = arr[right];
                answer1 = leftIdx;
                answer2 = rightIdx;
            }
            if (tmp < 0) {
                left++;
            } else {
                right--;
            }
            if (min == 0)
                break;
        }
        sb.append(answer1).append(" ").append(answer2);
        System.out.println(sb);
    }
}