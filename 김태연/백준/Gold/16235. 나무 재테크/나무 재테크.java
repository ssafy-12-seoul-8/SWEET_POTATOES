import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Tree {
	int x;
	int y;
	int age;
	
	public Tree(int x, int y, int age) {
		this.x = x;
		this.y = y;
		this.age = age;
	}
}

public class Main {

	static int N,M,K;
	static int[][] A;
	static int[][] ground;
    static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0}; // 8방향
    static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
	static List<Tree>[][] treeList;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		A = new int[N+1][N+1];
		ground = new int[N+1][N+1];
		treeList = new ArrayList[N+1][N+1];

		// A 배열의 값 입력
		for (int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=1; j<=N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());	// 겨울에 추가하는 양분
				ground[i][j] = 5;	// 초기 양분 5
				treeList[i][j] = new ArrayList<>();
			}
		}
		
		// M 개의 줄에 상도가 심은 나무의 정보를 나타내는 세 정수 좌표(x,y) 나이(z) -> age
		
//		treeList = new ArrayList<>();
//		treeList = new PriorityQueue[N+1][N+1];
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());	// 범위 문제가 발생함?
			int y = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
		
			// 나무를 만들어서 추가하자
			treeList[x][y].add(new Tree(x, y, age));
		}
		
		
		for (int i=0; i<K; i++) {
			// 봄 여름 가을 겨울
			springSummer();
			fall();
			winter();
		}
		
		int result = count();
		System.out.println(result);
	}
	
private static void springSummer() {
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
            if (treeList[i][j].isEmpty()) continue;

            List<Tree> thisTreeList = treeList[i][j];
            List<Tree> newTreeList = new ArrayList<>();
            List<Tree> deadTreeList = new ArrayList<>();
            

            // 나이 순으로 정렬하여 어린 나무부터 처리
            Collections.sort(thisTreeList, (o1, o2) -> Integer.compare(o1.age, o2.age));

            for (int k=0; k < thisTreeList.size(); k++) {
            	Tree tree = thisTreeList.get(k);
            	// 나무가 양분을 먹고 자랄 수 있는 경우
            	if (ground[tree.x][tree.y] >= tree.age) {
            		ground[tree.x][tree.y] -= tree.age; // 나무가 양분을 먹음
            		tree.age++; // 나이 증가
            		newTreeList.add(tree); // 살아남은 나무
            	} else {
            		// 죽은 나무는 양분으로 변환
            		// 여기가 문제구나!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            		deadTreeList.add(tree);
//                    ground[tree.x][tree.y] += tree.age / 2;
            	}
            }
            
            for (int k=0; k<deadTreeList.size(); k++) {
            	Tree tree = deadTreeList.get(k);
                ground[tree.x][tree.y] += tree.age / 2;
            }
            treeList[i][j] = newTreeList; // 살아남은 나무로 리스트 갱신
        }
    }
}

private static void fall() {
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
            if (treeList[i][j].isEmpty()) continue;

            List<Tree> thisTreeList = treeList[i][j];

            for (int k=0; k < thisTreeList.size(); k++) {
            	Tree tree = thisTreeList.get(k);
            	if (tree.age % 5 == 0) {
            		번식(tree);
            	}
            }
        }
    }
}

private static void 번식(Tree tree) {
    for (int dir = 0; dir < 8; dir++) {
        int nx = tree.x + dr[dir];
        int ny = tree.y + dc[dir];

        if (isBoundary(nx, ny)) {
            treeList[nx][ny].add(new Tree(nx, ny, 1)); 
        }
    }
}

private static void winter() {
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
            ground[i][j] += A[i][j];
        }
    }
}

private static boolean isBoundary(int r, int c) {
    return r >= 1 && r <= N && c >= 1 && c <= N;
}

static int count() {
    int count = 0;
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
            count += treeList[i][j].size();
        }
    }
    return count;
}
}