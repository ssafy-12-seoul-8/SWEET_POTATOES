import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UserSolution {
	
	static int[][] origin;						// 원본 배열을 저장할 배열
	static int[][] location;					// 별자리 탐색을 할 때 자신이 속한 별자리의 대표값을 저장할 배열 (별자리에 속하지 않으면 0, 중심이 (i,j)인 별자리에 속하면 10000*i+j+2의 값을 가짐)
	static int[][] row_star;					// 행의 별 누적합 row_star[i][j] 는 i행 0열부터 i행 j-1열까지 별의 합 (row_star[i][0] = 0)
	static int[][] col_star;					// 열이 별 누적합 col_star[i][j] 는 i열 0행부터 i열 j-1행까지 별의 합 (col_star[i][0] = 0)
	static Map<Integer, int[]> map;				// 키값은 각 별자리의 대표값(location에 저장되는 값들), value는 {별자리의 수, 별자리가 처음 나온 위치location, 처음 별자리의 시작 y값, 처음 별자리의 시작 x값} 
									
	static void init(int N, int[][] mPlane) {
		
		origin = new int[N][N];
		location = new int[N][N];
		row_star = new int[N][N+1];
		col_star = new int[N][N+1];
		map = new HashMap<>();
		
		for(int i = 0; i < N ; i++) {
			for(int j = 0 ; j < N ;j++) {
				if(mPlane[i][j]==1) {
					
					origin[i][j] = mPlane[i][j];				// 원본 배열 복사
					location[i][j] = mPlane[i][j];				// 원본 배열 복사
					row_star[i][j+1] = row_star[i][j]+1;		// 가로 누적합 채우기
					col_star[j][i+1] = col_star[j][i]+1;		// 세로 누적합 채우기
					
				} else {
					
					row_star[i][j+1] = row_star[i][j];			// 가로 누적합 채우기
					col_star[j][i+1] = col_star[j][i]; 			// 세로 누적합 채우기
					
				}
			}
		}
		
		for(int i = 0 ; i < N ; i++) {							// 위에서부터 탐색, 같은 행에서는 왼쪽부터 탐색하여 나온 별의 별자리를 찾는 과정을 할 거임
			for(int j = 0; j < N; j++) {	
				
				if(location[i][j]!=1) {							// location = 0이라는 건 별이 아니라는 거고, location>=2라는 것은 이미 특정 별자리에 속해 있다는 것
					continue;
				}
				
				int tmp_x = 0;									// 이 별이 속한 별자리의 가장 왼쪽위의 좌표가 궁금한데, 이 좌표의 y값은 i로 고정이고 x값만 미지수 - Math.max(j-4,0)~j 범위에 존재 이름 저장하기 위한 변수 tmp_x 
				
				for(int l = Math.max(j-4, 0) ; l <= j ; l++) {  // (i,l)이 별자리의 가장 왼쪽 위의 좌표의 자격을 가지는지를 확인
					
					// 아래의 연산은 각각, 윗변에 별이 있는가?, 아랫변에 별이 있는가?, 왼쪽변에 별이 있는가? 오른쪽 변에 별이 있는가? 를 판별하는 것
					if((row_star[i][l+5]-row_star[i][l])==0 || (row_star[i+4][l+5]-row_star[i+4][l])==0 || (col_star[l][i+5]-col_star[l][i])==0 || (col_star[l][i+5]-col_star[l][i])==0) {
						continue;
					}
					
					int count = 0; // 내가 정한 5*5배열에 있는 별의 개수
					
					for(int m = i; m<i+5;m++) {
						count += (row_star[m][l+5] - row_star[m][l]);	// m행에 있는 별의 수를 더한다.
					}
					
					if(count == 7) {		// count가 7이면 (i,l)~(i+4,l+4)가 별자리의 조건을 만족하므로 tmp_x에 l을 저장하고 break
						tmp_x = l;
						break;
					}
				}
				int loc = 10000*(i+2) + tmp_x + 2;				// 나중에 마지막 함수에서 10000*(i+2) + tmp_x + 2의 값을 출력하라고 하므로 각 좌표에 미리 저장해 놓는다. 
				int sum = 0;									// 이 별자리를 map의 key값으로서 넣고 싶은데 배열을 넣는 것은 좋지 않음 (변동가능한 값이므로) 
																// 따라서 배열의 각 요소에 0~24의 번호를 할당하고 j번에 1이 있으면 sum+=2^j를 하면 배열의 고유값이 된다. 
																// 2진법을 생각했을 때 서로 다른 배열에 대해 항상 서로 다른 값이 나오게 된다.
				for(int l = i ; l<i+5 ;l++) {					// 별자리의 가장 왼쪽위의 좌표가 (y,tmp_x)임을 이용
					for(int m = tmp_x ; m<tmp_x+4 ; m++) {
						
						if(location[l][m]==1) {					// 1일 때만 sum에 더해준다.
							sum = sum + (1<<(5*(l-i)+(m-tmp_x)));
						}
						
						location[l][m] = loc;					// 각 배열의 원소에 loc를 채워넣는다.
					}
				}
				
				if(map.containsKey(loc)) {						// 만약 이 값이 키값으로 존재한다면
							
					int[] tmp = map.get(loc);					// 단순히 count만 더해주면 된다.
					tmp[0]+=1;
					map.put(loc, tmp);
		
				} else {										// 이 값이 키값으로 존재하지 않는다면
					map.put(loc, new int[] {1,loc,i,tmp_x});	// {1,loc,시작 y값, 시작 x값} 을 저장하면 된다. 이 때 별을 위에서부터 탐색, 같은 행에서는 왼쪽부터 탐색하였으므로 loc의 값이 이 별자리중 가장 왼쪽위 별자리의 정보를 담는다.
				}
			}
		}
		
	}
	static int count_stars(int[][] stars) {
		
		int sum1 = 0;
		int sum2 = 0;
		int sum3 = 0;
		int sum4 = 0;
		int count = 0;								// 이 종류의 별자리가 얼마나 있는지 저장할 변수
		
		Set<Integer> set = new HashSet<>();
		
		for(int i = 0 ; i < 5 ; i++) {
			for(int j=0 ; j < 5 ; j++) {
				
				if(stars[i][j]==1) {				// 주어진 별자리의 고유값을 계산하고 싶은데 별자리를 회전시켜도 같은 별자리로 취급하므로 4개의 고유값을 계산해야 함
													// (i,j)를 시계방향으로 90도 회전하면 (j,4-i)가 됨을 이용하면 더해야 하는 값들을 계산할 수 있다.
					sum1 += (1<<(5*i+j));
					sum2 += (1<<(5*j+(4-i)));
					sum3 += (1<<(5*(4-i)+(4-j)));
					sum4 += (1<<(5*(4-j)+i));
				}		
			}
		}
		
		set.add(sum1);								// set에 넣어주는 이유는 180도 회전을 하였을 때 같아지는 별자리가 있기 때문이다.
		set.add(sum2);								// count에 있어 중복을 피하기 위해 sum1~sum4중 겹치지 않는 원소만 뽑아서 count에 더할 것이다.
		set.add(sum3);
		set.add(sum4);
		
		for(int i:set) {
			
			if(map.containsKey(i)) {				// 만약 map에 키값으로서 존재한다면 적어도 하나의 별자리가 존재
				count += map.get(i)[0];				// count에 모두 더해준다.
			}
			
		}
		
		return count;
		
	}
	static int find_location(int y, int x) {
		
		int[] tmp = map.get(location[y][x]);		// 이 좌표의 별자리중 가장 왼쪽 위의 좌표를 저장해놓았다.
		int sum1 = 0;
		int sum2 = 0;
		int sum3 = 0;
		int sum4 = 0;
		int mini = Integer.MAX_VALUE;
			
		int start_y = tmp[2];
		int start_x = tmp[3];
		
		for(int i = 0 ; i < 5 ; i++) {
			for(int j=0 ; j < 5 ; j++) {
				
				if(origin[i+start_y][j+start_x]==1) {// 이 역시 회전을 고려하면 4개의 고유값이 나올 수 있다.
					
					sum1 += (1<<(5*i+j));
					sum2 += (1<<(5*j+(4-i)));
					sum3 += (1<<(5*(4-i)+(4-j)));
					sum4 += (1<<(5*(4-j)+i));
				}		
			}
		}
		
		// 이 경우 sum1 ~ sum4의 위치 중 최소를 찾는 것이므로 중복이 생겨도 결과가 같다. 따라서 굳이 set을 써주지 않는다.
		
		if(map.containsKey(sum1)) {
			mini = Math.min(mini, map.get(sum1)[1]);
		}
		
		if(map.containsKey(sum2)) {
			mini = Math.min(mini, map.get(sum2)[1]);
		}
		
		if(map.containsKey(sum3)) {
			mini = Math.min(mini, map.get(sum3)[1]);
		}
		
		if(map.containsKey(sum4)) {
			mini = Math.min(mini, map.get(sum4)[1]);
		}
		
		return mini;
	}
}
