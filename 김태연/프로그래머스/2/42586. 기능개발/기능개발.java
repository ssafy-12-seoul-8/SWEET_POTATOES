import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> list = new ArrayList<Integer>();
        int L = progresses.length;
        // 예시에서 길이는 3
        // 작업 진도 : progresses   , progresses.length <= 100
        // 작업 속도 : speeds       , speeds.length <= 100
    
        
        int[] work = new int[L];
        
        for (int i=0; i<L; i++) {
        int result = progresses[i];	// 만약 i = 1 이라면 result 값은 30 (초기값) 
        
        int time = 0;
        
        while (result < 100) {	// 30 < 100 , 60<100, 90<100 120!<100
        	result += speeds[i];		// result 값(30) 에 30를 더함(스피드를 더함	)	30->60, 60->90, 90->120 3일 작업. count[3] ++
        	time++;						// 그리고 걸린 시간초를 더함. i=1 케이스에 대해서 time의 최종값은 3임
        }
        work[i] = time;
        }
        
        System.out.println("work : " + Arrays.toString(work));

        // work 값 저장 완료
        int max = work[0];
        int count = 0;
        for (int i=0; i<L-1; i++) {
        	count++;
        	
        	if (work[i+1] > max) {
//        		System.out.println("i값 : " + i);
        		list.add(count);
        		count = 0;
        	}
        	max = Math.max(max, work[i+1]);
        }
        count++;
        list.add(count);
        
        int[] arr = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
        	arr[i] = list.get(i);
        }
        answer = arr;
        return answer;
    }
}