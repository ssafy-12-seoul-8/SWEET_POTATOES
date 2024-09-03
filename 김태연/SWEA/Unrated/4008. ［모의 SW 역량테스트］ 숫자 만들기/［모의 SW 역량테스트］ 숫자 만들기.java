import java.util.Scanner;

public class Solution {

    static int[] nums;
    static int N;
    static int min;
    static int max;
    static int result;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            N = sc.nextInt();

            int[] op = new int[4];
            nums = new int[N];

            // 연산가 갯수 받기
            for (int i = 0; i < 4; i++) {
                op[i] = sc.nextInt();
            }

            // 수식에 사용되는 숫자 받기
            for (int i = 0; i < N; i++) {
                nums[i] = sc.nextInt();
            }

            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            
            compute(1, op, nums[0]);
            result = max - min;
            
            System.out.println("#" + test_case + " " + result);
        }
    }

    static void compute(int index, int[] op, int result) {

        // 기저조건 : 숫자 다 쓰면 끝
        if (index == N) {
            min = Math.min(min, result);
            max = Math.max(max, result);
            return;
        }


        // +가 1개 이상일 때
        if (op[0] > 0) {
            // + 를 하나 사용하고
            op[0]--;
            // 결과값을 더하고
            result += nums[index];
            // btk한다
            compute(index+1,op, result);
            // 초기화
            result -= nums[index];
            op[0]++;
        }
        
        
        
        // +가 1개 이상일 때
        if (op[0] > 0) {
            // + 를 하나 사용하고
            op[0]--;
            // 결과값을 더하고
            result += nums[index];
            // btk한다
            compute(index+1,op, result);
            // 초기화
            result -= nums[index];
            op[0]++;
        }
        
        
        
        // -가 1개 이상일 때
        if (op[1] > 0) {
            // - 를 하나 사용하고
            op[1]--;
            // 결과값을 더하고
            result -= nums[index];
            // btk한다
            compute(index+1,op, result);
            // 초기화
            result += nums[index];
            op[1]++;
        }
        
        
        
        // *가 1개 이상일 때
        if (op[2] > 0) {
            // + 를 하나 사용하고
            op[2]--;
            // 결과값을 더하고
            result *= nums[index];
            // btk한다
            compute(index+1,op, result);
            // 초기화
            result /= nums[index];
            op[2]++;
        }
        
        
        
        // /가 1개 이상일 때
        if (op[3] > 0) {
            // + 를 하나 사용하고
            op[3]--;
            // 결과값을 더하고
            result /= nums[index];
            // btk한다
            compute(index+1,op, result);
            // 초기화
            result *= nums[index];
            op[3]++;
        }
  
    }
}
