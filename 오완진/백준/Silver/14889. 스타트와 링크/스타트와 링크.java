import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int N, minScore;
	static int[][] score;
	static boolean[] visited;
	static List<Integer> arr;
	
    public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in);
    	
    	N = sc.nextInt();
    	score = new int[N][N];
    	for (int i = 0; i < N; i++)
    		for (int j = 0; j < N; j++)
    			score[i][j] = sc.nextInt();
    	
    	visited = new boolean[N];
    	arr = new ArrayList<>();
    	
    	minScore = Integer.MAX_VALUE;
    	btk(0);
    	
    	System.out.println(minScore);
    }
    
    static void btk(int idx) {
    	
    	if (arr.size() == N/2) {
    		calTeamScore();
//    		// 출력한번해볼껄
//    		for (int num : arr)
//    			System.out.print(num + " ");
//    		System.out.println();
    		return;
    	}
    	
    	for (int i = idx; i < N; i++) {
    		if (!visited[i]) {
    			visited[i] = true;
    			arr.add(i);
    			btk(i + 1);
    			arr.remove(arr.size() - 1);
    			visited[i] = false;
    		}
    	}
    }
    
    static void calTeamScore() {
    	
    	int scoreA = 0;
    	int scoreB = 0;
    	
    	for (int i = 0; i < N; i++) {
    		for (int j = i+1; j < N; j++) {
    			if (visited[i] && visited[j])
    				scoreA += score[i][j] + score[j][i];
    			else if (!visited[i] && !visited[j])
    				scoreB += score[i][j] + score[j][i];
    		}
    	}
    	
    	minScore = Math.min(minScore, Math.abs(scoreA - scoreB));
    }
}