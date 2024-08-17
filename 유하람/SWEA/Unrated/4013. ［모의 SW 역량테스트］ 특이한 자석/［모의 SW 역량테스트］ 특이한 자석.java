
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{	
    
    static class Magnet {
        int idx;
        int point = 0;
        int[] data = new int[8];

        Magnet(int idx) {
            this.idx = idx;
            magnets[idx] = this;
        }

        void rotate(int direction) {
            if (direction == 1) {
                int temp = data[7];
                for (int i = 7; i > 0; i--) {
                    data[i] = data[i - 1];
                }
                data[0] = temp;
            } else if (direction == -1) {
                int temp = data[0];
                for (int i = 0; i < 7; i++) {
                    data[i] = data[i + 1];
                }
                data[7] = temp;
            }
        }
    }
    
    static Magnet[] magnets = new Magnet[4];
    
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int t = 1; t <= T; t++)
		{
            // 회전 횟수
            int k = sc.nextInt();

            // 자성 값 입력
            for (int i = 0; i < 4; i++) {
                Magnet m = new Magnet(i);
                for (int j = 0; j < 8; j++) {
                    m.data[j] = sc.nextInt();
                }
            }

            // 회전 시작
            for (int i = 0; i < k; i++) {
                // 회전할 자석
                int idx = sc.nextInt() - 1;  // 자석 번호를 0 기반으로 조정
                
                // 회전 방향
                int spin = sc.nextInt();

                // 회전 처리
                boolean[] visited = new boolean[4];
                spin(idx, spin, visited);
            }
            
            int[] scores = new int[4];
            int score = 0;
            
            for(int i=0 ; i<4 ; i++) {
            	scores[i] = magnets[i].data[0];
            	if(scores[i]==1) {
            		score += Math.pow(2, i);
            	}
            	
            }

            System.out.print("#" + t + " ");
            System.out.println(score);
		}
	}
    
    static void spin(int idx, int spin, boolean[] visited) {
        if (idx < 0 || idx >= 4 || visited[idx]) {
            return;
        }

        visited[idx] = true;
        

        int leftIdx = idx - 1;
        int rightIdx = idx + 1;

        if (leftIdx >= 0 && !visited[leftIdx] &&
                magnets[leftIdx].data[2] != magnets[idx].data[6]) {
            spin(leftIdx, -spin, visited);
        }

        if (rightIdx < 4 && !visited[rightIdx] &&
                magnets[rightIdx].data[6] != magnets[idx].data[2]) {
            spin(rightIdx, -spin, visited);
        }
        
        magnets[idx].rotate(spin);
        
        visited[idx] = false;
    }
}