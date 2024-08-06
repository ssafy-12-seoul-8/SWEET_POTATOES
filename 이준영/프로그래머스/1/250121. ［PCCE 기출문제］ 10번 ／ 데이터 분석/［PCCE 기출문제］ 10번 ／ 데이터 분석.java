
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<ArrayList<Integer>> answer1 = new ArrayList<>();
        int ans_len=data.length;
        int check=0;
        switch (ext) {
        	case "code":
        		check=0;
        		break;
        	case "date":
        		check=1;
        		break;
        	case "maximum":
        		check=2;
        		break;
        	case "remain":
        		check=3;
        		break;
        		
        }
        for (int i=0;i<ans_len;i++) {
			if (data[i][check]<val_ext) {
				Integer[] arr = {data[i][0],data[i][1],data[i][2],data[i][3]};
				ArrayList<Integer> new_arr = new ArrayList<>(Arrays.asList(arr));
				answer1.add(new_arr);
			}
		}
        int len = answer1.size();
        int[][] answer = new int[len][4]; 
        for (int i=0;i<len;i++) {
        	for (int j=0;j<4;j++) {
        		answer[i][j]=answer1.get(i).get(j);
        	}
        }
        switch (sort_by) {
    		case "code":
    			check=0;
    			break;
    		case "date":
	    		check=1;
	    		break;
	    	case "maximum":
	    		check=2;
	    		break;
	    	case "remain":
	    		check=3;
	    		break;
    		
        }
        for (int i=0;i<len-1;i++) {
        	for(int j=0;j<len-1-i;j++) {
        		if (answer[j][check]>answer[j+1][check]) {
        			int[] temp=answer[j];
        			answer[j] =answer[j+1];
        			answer[j+1]=temp;
        		}
        	}
        }
        return answer;
    }
}