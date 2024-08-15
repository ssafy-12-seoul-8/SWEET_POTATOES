import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			Set<Integer> set = new HashSet<>();
			int sum=0;
			boolean check = false;
			int k=1;
			int num=0;
			while(true) {
				String str = String.valueOf(k*N);
				for(int i=0;i<str.length();i++) {
					num = Character.getNumericValue(str.charAt(i));
					if (!set.contains(num)) {
						set.add(num);
						sum=sum+num;
						if (num==0){
							check=true;
						}
					}
				}
				if (sum==45 && check)
					break;
				k+=1;
			}
			sb.append("#").append(tc).append(" ").append(k*N).append("\n");
		}
		System.out.println(sb);
	}
}
