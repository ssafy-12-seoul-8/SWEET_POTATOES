import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
	
	static class home {
		int x;
		int y;
		int chicken = Integer.MAX_VALUE;
		
		home(int x, int y){
			this.x = x;
			this.y = y;
			homes.add(this);
		}
		
		void setChicken(int chicken){
			this.chicken = Math.min(this.chicken, chicken);
		}
		
	}
	
	static class shop {
		int x;
		int y;
		
		shop(int x, int y){
			this.x = x;
			this.y = y;
			shops.add(this);
		}
	}
	
	static List<home> homes = new ArrayList<>();
	static List<shop> shops = new ArrayList<>();
	static int answer;
	
    public static void main(String[] args) throws Exception{
    
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String s = br.readLine();
    	StringTokenizer st = new StringTokenizer(s);
    	
    	// 도시 크기 : N*N
    	int N = Integer.parseInt(st.nextToken());
    	
    	// 살아남은 치킨집 : M
    	int M = Integer.parseInt(st.nextToken());
    	
    	// 도시
    	int[][] map = new int[N][N];
    	
    	for(int i=0 ; i<N ; i++) {
    		String s2 = br.readLine();
    		StringTokenizer st2 = new StringTokenizer(s2);
    		for(int j=0 ; j<N ; j++) {
    			map[i][j] = Integer.parseInt(st2.nextToken());
    			
    			// 집 정보 저장
    			if(map[i][j]==1) {
    				home newHome = new home(i,j);
    			}
    			
    			// 치킨집 정보 저장
    			if(map[i][j]==2) {
    				shop newShop = new shop(i,j);
    			}
    			
    		}
    	}
    	
    	answer = Integer.MAX_VALUE;
    	
    	shop[] tmp = new shop[M];
    	
    	choose(0, 0, M, tmp);
    	
    	System.out.println(answer);
    	
    	
    }
    
    static int distance(home h, shop s) {
    	return Math.abs(h.x-s.x)+Math.abs(h.y-s.y);
    }
    
    // shops에서 shop M개 고름
    // tmp : 고른 shop 저장, sidx : tmp 인덱스, idx : shops 인덱스
    static void choose(int idx, int sidx, int M, shop[] tmp) {
    	if(sidx==M) {
    		
    		for(home h : homes) {
    			h.chicken = Integer.MAX_VALUE;
    		}
    		
    		// M개의 치킨가게 고르기
    		// 각 집의 치킨 거리 구하기
    		for(home h : homes) {
    			for(shop s : tmp) {
    				h.setChicken(distance(h,s));
    			}
    		}
    		
    		// 치킨거리 구히기
    		int sum = 0;
    		for(home h : homes) {
    			sum += h.chicken;
    		}
    		
    		
    		answer = Math.min(answer, sum);
    		return;
    	}
    	
    	if(idx == shops.size()) {
    		return;
    	}
    	
    	// 안고른 경우
    	choose(idx+1, sidx, M, tmp);
    	
    	// 고른 경우
    	tmp[sidx] = shops.get(idx); 
    	choose(idx+1, sidx+1, M, tmp);
    	
    }
    
    
    
}