import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int initATK = Integer.parseInt(st.nextToken());
        
        // 방의 정보
        int[][] dungeon = new int[N][3];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            dungeon[i][0] = Integer.parseInt(st.nextToken());
            dungeon[i][1] = Integer.parseInt(st.nextToken());
            dungeon[i][2] = Integer.parseInt(st.nextToken());
        }
        
        long left = 1, right = Long.MAX_VALUE, result = Long.MAX_VALUE;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            
            if (isPossible(mid, initATK, dungeon)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        System.out.println(result);
    }
    
    // 주어진 HMaxHP로 던전을 클리어 할 수 있는지 체크
    private static boolean isPossible(long maxHP, int initATK, int[][] dungeon) {
        long currHP = maxHP;
        long currATK = initATK;
        
        for (int[] room : dungeon) {
            int type = room[0];
            int attackOrGain = room[1];
            int healthOrRecover = room[2];
            
            if (type == 1) { // 몬스터 방
                long monsterHP = healthOrRecover;
                long monsterATK = attackOrGain;
                
                long monsterTurns = (monsterHP + currATK - 1) / currATK; // 몬스터가 죽기까지 걸리는 용사의 공격 횟수
                long heroTurns = (currHP + monsterATK - 1) / monsterATK; // 용사가 죽기까지 걸리는 몬스터의 공격 횟수
                
                if (monsterTurns > heroTurns) { // 몬스터를 죽이기 전에 용사가 죽음
                    return false;
                }
                
                // 용사는 마지막 한 번 맞기 전까지만 체력 소비
                currHP -= (monsterTurns - 1) * monsterATK;
                
            } else if (type == 2) { // 포션 방
                currATK += attackOrGain;
                currHP = Math.min(currHP + healthOrRecover, maxHP); // 회복 후 최대 체력 초과 방지
            }
        }
        
        return true;
    }
}
