import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

class ArrayWrapper{
	int[] array;
	
	ArrayWrapper(int[] array){
		this.array = array;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(o==null || getClass()!= o.getClass())
			return false;
		ArrayWrapper that = (ArrayWrapper) o;
		return Arrays.equals(array, that.array);
	}
	
	@Override
	public int hashCode() {
		return Arrays.hashCode(array);
	}
}

public class Main{
	
	static Set<ArrayWrapper> set = new HashSet<>();
	
    public static void main(String[] args) throws Exception{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringBuilder sb = new StringBuilder();
    	
    	String s = br.readLine();
    	StringTokenizer st = new StringTokenizer(s);
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	String str = br.readLine();
    	StringTokenizer st2 = new StringTokenizer(str);
    	
    	int[] arr = new int[N];
    	
    	for(int i=0 ; i<N ; i++) {
    		arr[i] = Integer.parseInt(st2.nextToken());
    	}
    	
    	Arrays.sort(arr);
    	
    	List<int[]> list = new ArrayList<>();
    	int[] data = new int[M];    	
    	NM(N, M, arr, 0, data, list);
    	
    	// 출력
    	for(int[] d : list) {
    		for(int i : d) {
    			sb.append(i).append(" ");
    		}
    		sb.append("\n");
    	}
    	
    	String ans = sb.toString();
    	bw.write(ans);
    	bw.flush();
    	bw.close();
    	
    }
    
    static void NM(int N, int M , int[]arr, int depth, int[] data, List<int[]> list) {
    	
    	if(depth == M) {
    		int[] tmp = data.clone();
    		if(!set.contains(new ArrayWrapper(tmp))) {
    			set.add(new ArrayWrapper(tmp));
    			list.add(tmp);
    		}
    		return;
    	}
    	
    	for(int i=0 ; i<N ; i++) {
    		data[depth] = arr[i];
    		NM(N, M, arr, depth+1, data, list);
    		
    	}
    	
    	
    }
  
}