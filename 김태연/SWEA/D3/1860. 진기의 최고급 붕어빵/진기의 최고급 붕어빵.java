import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        StringTokenizer st;
        int T;
        T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
 
            sb = new StringBuilder();
            st = new StringTokenizer(br.readLine()); // 2, 2, 2 입력받음
            int N = Integer.parseInt(st.nextToken()); // 2 사람수
            int M = Integer.parseInt(st.nextToken()); // 2 붕어빵만드는데 걸리는 시간
            int K = Integer.parseInt(st.nextToken()); // 2
 
            st = new StringTokenizer(br.readLine());
 
            PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
            for (int i = 0; i < N; i++) { // 3 , 4 손님오는시간
                queue.add(Integer.parseInt(st.nextToken()));
            }
 
            // 0초부터 붕어빵 만드기 시작
            // N : 각 사람이 언제 도착하는지, 즉 사람 수
            // M : 붕어빵 만드는데 걸리는 시간초
            // K : 한번에 만들어지는 붕어빵 개수
            // boong : 만들어진 붕어빵 개수
            int boong = 0;
            int time = 0;
            int coolTime = 0;
            int person = queue.poll();
            String result = "Possible";
            boonguBBANG : while (true) {
                if (M == coolTime) {
                    boong += K; // M 초가 지나면 붕어빵 K개 생성됨
                    coolTime = 0; // 쿨타임 초기화
                }
                while (person == time) {    
                    if (boong != 0) { // 재고 있으면
                        boong -= 1;     // 붕어빵 하나 먹어라!
                        if (!queue.isEmpty()) person = queue.poll(); // 붕어빵을 줬는데, 다음 손님이 있다면, 손님을 갱신하자.
                                                                    // 붕어빵을 줬는데 다음 손님이 없다면
                        else break boonguBBANG;                     // 전체 로직 종료
                    } else {
                        result = "Impossible"; // 재고없으면
                        break boonguBBANG;
                    }
                }
                time++;
                coolTime++;
            }
            sb.append("#" + test_case + " " + result);
            System.out.println(sb);
        }
    }
}