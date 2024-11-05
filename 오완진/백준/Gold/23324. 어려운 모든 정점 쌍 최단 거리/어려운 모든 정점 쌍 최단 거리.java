import java.io.*;
import java.util.*;

public class Main {
    
    static int N, M, K, N1, N2;
    static int[] p;
    static int[][] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()) - 1;
        
        edges = new int[M][3];
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	N1 = Integer.parseInt(st.nextToken()) - 1;
        	N2 = Integer.parseInt(st.nextToken()) - 1;
        	
        	edges[i][0] = N1;
        	edges[i][1] = N2;
        	edges[i][2] = (i == K) ? 1 : 0;
        }
        
        p = new int[N];
        
        for (int i = 0; i < N; i++)
        	makeSet(i);
        
        int x = 0;
        int y = 0;
        for (int[] edge : edges) {
        	int a = edge[0];
        	int b = edge[1];
        	int w = edge[2];
        	
        	if (w == 1) {
        		x = a;
        		y = b;
        		continue;
        	}
        	
        	if (findSet(a) != findSet(b))
        		union(a, b);
        }
        
        if (findSet(x) == findSet(y)) {
            System.out.println(0);
            return;
        }
        
        long cntX = 0;
        long cntY = 0;
        for (int i = 0; i < N; i++) {
            if (findSet(i) == findSet(x))		cntX++;
            else if (findSet(i) == findSet(y))	cntY++;
        }

        long ans = cntX * cntY;
        System.out.println(ans);
    }
    
    static void makeSet(int x) {
    	p[x] = x;
    }
    
    static int findSet(int x) {
    	if (x != p[x])
    		p[x] = findSet(p[x]);
    	
    	return p[x];
    }
    
    static void union(int x, int y) {
        int rootX = findSet(x);
        int rootY = findSet(y);
        
        if (rootX != rootY)
            p[rootY] = rootX;
    }
}
