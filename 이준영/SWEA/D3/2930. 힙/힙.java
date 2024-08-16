import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] arr = new int[N+1];
			int size=0;
			sb.append("#").append(tc);
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				if(a==1) {
					int x = Integer.parseInt(st.nextToken());
					arr[++size]=x;
					int p=size/2;
					int ch=size;
					while(ch>1 && arr[p]<arr[ch] ) {
						int tmp = arr[p];
						arr[p] = arr[ch];
						arr[ch] = tmp;
						ch=ch/2;
						p=ch/2;
					}
				} else {
					if (size==0) {
						sb.append(" ").append(-1);
					} else {
						sb.append(" ").append(arr[1]);
						int tmp = arr[size--];
						arr[1] = tmp;
						if(size==1||size==0) {
							continue;
						} else if(size==2) {
							if(arr[1]<arr[2]) {
								int tmp2 = arr[1];
								arr[1]=arr[2];
								arr[2]=tmp2;
							}
						} else {
							int p=1;
							while(p*2+1<=size && (arr[p]<arr[p*2] || arr[p]<arr[p*2+1])) {
								if(arr[2*p]<arr[2*p+1]) {
									int tmp2 = arr[p];
									arr[p] = arr[2*p+1];
									arr[2*p+1]=tmp2;
									p=2*p+1;
								} else {
									int tmp2 = arr[p];
									arr[p] = arr[2*p];
									arr[2*p]=tmp2;
									p=2*p;
								}
								
							}
						}
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
