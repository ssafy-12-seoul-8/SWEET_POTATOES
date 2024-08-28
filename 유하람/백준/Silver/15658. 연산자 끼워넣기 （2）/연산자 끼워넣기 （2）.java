import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        int N = Integer.parseInt(s);    // N 입력
        
        String s2 = br.readLine();
        StringTokenizer st = new StringTokenizer(s2);
        
        int[] nums = new int[N];        // nums 입력
        for(int i=0 ; i<N ; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        
        int[] oper = new int[4];        // 연산자 개수 {+,-,*,/}
        
        String s3 = br.readLine();
        StringTokenizer st2 = new StringTokenizer(s3);
        
        for(int i=0 ; i<4 ; i++) {
            oper[i] = Integer.parseInt(st2.nextToken());
        }
        
        cal(N, nums, oper, 1, nums[0]);
        
        System.out.println(max);
        System.out.println(min);
        
        
    }
    
    static void cal(int N, int[] nums, int[] oper, int idx, int result) {
        
        
        if(idx==N) {
            min = Math.min(min, result);
            max = Math.max(max, result);
            
            return;
        }
        
        // + 선택하는 경우
        if(oper[0] != 0) {
            oper[0]--;
            int tmp = result;
            result = result + nums[idx];
            cal(N,nums,oper, idx+1, result);
            oper[0]++;
            result = tmp;
            
        }
        
        // - 선택하는 경우
        if(oper[1] != 0) {
            oper[1]--;
            int tmp = result;
            result = result - nums[idx];
            cal(N,nums,oper,idx+1, result);
            oper[1]++;
            result = tmp;
            
        }
        
        // * 선택하는 경우
        if(oper[2] != 0) {
            oper[2]--;
            int tmp = result;
            result = result * nums[idx];
            cal(N,nums,oper,idx+1,result);
            oper[2]++;
            result = tmp;
        }
        
        // / 선택하는 경우
        if(oper[3] != 0) {
            oper[3]--;
            int tmp = result;
            result = result / nums[idx];
            cal(N,nums,oper,idx+1,result);
            oper[3]++;
            result = tmp;
        }
        
        
        
    }
    

}