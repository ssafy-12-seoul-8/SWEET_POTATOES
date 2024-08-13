import java.util.LinkedList;
import java.util.Queue;

class project{
	int time; // 배포 가능 날짜
	int no; // times 인덱스 위해서
	int progress;
	int speed;
	
	project(){};
	
	public project(int no, int progress, int speed) {
		this.no = no;
		this.progress = progress;
		this.speed = speed;
	}
}

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
       int len = progresses.length;
		
		Queue<project> projects = new LinkedList<>();
		int[] times = new int[len];
		
		// 값 담기
		for(int i=0 ; i<len ; i++) {
			project p = new project(i,progresses[i],speeds[i]);
			
			projects.add(p);
		}
		
		// 빼서 speed만큼 올리고 넣기
		while(!projects.isEmpty()) {
			
			// 빼기
			project tmp = projects.poll();
			
			
			// 100%에 도달했다면
			if(tmp.progress >= 100) {
				times[tmp.no] = tmp.time;
				continue;
			}else {
				tmp.progress += tmp.speed;
				tmp.time++;
				projects.add(tmp);
			}

		}
		
		int cnt = 1;
		int max = times[0];
		for(int i=0 ; i<len-1 ; i++) {
			if(max<times[i+1]) {
				cnt++;
				max = times[i+1];
			}
		}
		int idx = 0;
		int[] answer = new int[cnt];
		int count = 1; // 배포될 프로젝트 수
        max = times[0];
		
		for(int i=0 ; i<len-1 ; i++) {
			if(max<times[i+1]) {
				answer[idx++] = count;
				count = 1; // 초기화
				max = times[i+1];
			}else {
				count++;
			}
		}
		
		answer[idx] = count;
        return answer;
    }
}