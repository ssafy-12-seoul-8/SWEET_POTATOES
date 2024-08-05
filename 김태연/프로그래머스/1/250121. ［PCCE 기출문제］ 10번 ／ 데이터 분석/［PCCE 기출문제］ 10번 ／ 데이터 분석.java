import java.util.ArrayList;
import java.util.List;

class Solution {
	public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

		int[][] answer = {};
		List<int[]> list = new ArrayList<int[]>();

		// ext 값이 remain 이냐 code 냐에 따라 분류가 달라질텐데

		int idx = 0;

		if (ext.equals("date")) {
			for (int r = 0; r < data.length; r++) { // data의 길이만큼 하는것도 맞음.
				if (data[r][1] < val_ext) { // date는 [r][1] 에 있는게 맞음.
					list.add(idx++, data[r]); // 0값에 data[1], 1값에 data[4] 이런식으로..넣을수있음
				}
			}
		} else if (ext.equals("code")) { // ext 가 code 일 때
			for (int r = 0; r < data.length; r++) {
				if (data[r][0] < val_ext) { // code 는 [r][0]에 있는게 맞음.
					list.add(idx++, data[r]);
				}
			}
		} else if (ext.equals("maximum")) { // ext 가 code 일 때
			for (int r = 0; r < data.length; r++) {
				if (data[r][2] < val_ext) { // code 는 [r][0]에 있는게 맞음.
					list.add(idx++, data[r]);
				}
			}
		} else if (ext.equals("remain")) { // ext 가 code 일 때
			for (int r = 0; r < data.length; r++) {
				if (data[r][3] < val_ext) { // code 는 [r][0]에 있는게 맞음.
					list.add(idx++, data[r]);
				}
			}
		}

//        answer = list.toArray(answer);		// 이 부분이 가장 확실하지 않음. 바꿔보자
		answer = new int[idx][3];
		for (int i = 0; i < idx; i++) {
			answer[i] = list.get(i);
		}

		// 바꿨는데도 큰 차이 없음. 아래 확인해보자

		// 버블 정렬하기
		boolean isSwap; // 이 방식을 쓰지말아볼까
		if (sort_by.equals("remain")) {
			for (int i = 0; i < answer.length - 1; i++) {
				isSwap = false; // isSwap 변수 초기화하고 (false 로 유지되면 바로 종료해버림)
				for (int j = 0; j < answer.length - 1 - i; j++) {
					if (answer[j][3] > answer[j + 1][3]) { // j 는 0부터 끝날때까지(answer.length -1 하고 i번만큼 정렬했으니까 i까지 빼는거
															// 합리적임. 그래도 i 붙여서 테스트해보자 -> 똑같음(시간만 늘어날듯)
						int[] temp = answer[j + 1];
						answer[j + 1] = answer[j];
						answer[j] = temp;
						isSwap = true;
					}
				}
				if (!isSwap)
					break; // isSwap = false 이면 종료 (바뀌지 않았으니까 정렬이 끝난것으로 간주) -> i for문을 부수는게 맞음.
			}
		} else if (sort_by.equals("maximum")) {
			for (int i = 0; i < answer.length - 1; i++) {
				isSwap = false;
				for (int j = 0; j < answer.length - 1 - i; j++) {
					if (answer[j][2] > answer[j + 1][2]) {
						int[] temp = answer[j + 1];
						answer[j + 1] = answer[j];
						answer[j] = temp;
						isSwap = true;
					}
				}
				if (!isSwap)
					break;
			}
		} else if (sort_by.equals("date")) {
			for (int i = 0; i < answer.length - 1; i++) {
				isSwap = false;
				for (int j = 0; j < answer.length - 1 - i; j++) {
					if (answer[j][1] > answer[j + 1][1]) {
						int[] temp = answer[j + 1];
						answer[j + 1] = answer[j];
						answer[j] = temp;
						isSwap = true;
					}
				}
				if (!isSwap)
					break;
			}
		} else if (sort_by.equals("code")) {
			for (int i = 0; i < answer.length - 1; i++) {
				isSwap = false;
				for (int j = 0; j < answer.length - 1 - i; j++) {
					if (answer[j][0] > answer[j + 1][0]) {
						int[] temp = answer[j + 1];
						answer[j + 1] = answer[j];
						answer[j] = temp;
						isSwap = true;
					}
				}
				if (!isSwap)
					break;
			}
		}
		return answer;
	}
}
