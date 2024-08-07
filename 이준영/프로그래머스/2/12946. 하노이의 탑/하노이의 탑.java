import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] solution(int n) {
        ArrayList<ArrayList<Integer>> sol = hanoi(n,1,3);
        int[][] answer = new int[pow(2,n)-1][2];
        for (int i=0;i<pow(2,n)-1;i++) {
        	for (int j=0;j<2;j++) {
        		answer[i][j]=sol.get(i).get(j);
        	}
        }
        return answer;
    }
    public ArrayList<ArrayList<Integer>> hanoi(int n,int start,int end){
    	ArrayList<ArrayList<Integer>> a = new ArrayList<>();
    	if (n==1) {
    		ArrayList<Integer> row1 = new ArrayList<>();
    		row1.add(start);
    		row1.add(end);
    		a.add(row1);
    		return a;
    	}
    	a.addAll(hanoi(n-1,start,6-start-end));
    	ArrayList<Integer> row1 = new ArrayList<>();
    	row1.add(start);
    	row1.add(end);
    	a.add(row1);
    	a.addAll(hanoi(n-1,6-start-end,end));
    	return a;
    }
    public int pow(int a,int b) {
    	if(b==0)
    		return 1;
    	return a*pow(a,b-1);
    }
}