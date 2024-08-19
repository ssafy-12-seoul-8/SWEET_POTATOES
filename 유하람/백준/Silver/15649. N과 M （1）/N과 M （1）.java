import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
	
	static int N;
	static int M;
	static int[] arr;
	static boolean[] visit;
	static List<int[]> list = new ArrayList<>();
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        
        arr = new int[N];
        for(int i=0 ; i<N ; i++){
            arr[i] = i+1;
        }
        
        visit = new boolean[N];
        int[] datas = new int[M];
        
        NM(0,datas);
        
        for(int[] data : list) {
        	for(int i : data) {
        		System.out.print(i+" ");
        	}
        	System.out.println();
        }
        
        
    }
    
    static void NM(int idx, int[] datas) {
    	if(idx==M) {
    		list.add(datas.clone());
    		return;
    	}
    	for(int i=0 ; i<N ; i++) {
    		if(!visit[i]) {
	    		visit[i] = true;
	    		datas[idx] = arr[i];
	    		NM(idx+1, datas);
	    		visit[i] = false;
    		}
    	}
    	
    }
    
    
}