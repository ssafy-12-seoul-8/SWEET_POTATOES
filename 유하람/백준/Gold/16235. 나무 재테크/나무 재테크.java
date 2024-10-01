import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static int N;
	static int[][] land;
	static PriorityQueue<Tree>[][] trees;
	static List<Tree>[][] deadTrees;
	static int M;
	static int K;
	static int[][] A;
	
	static int[] dr = {-1,-1,-1,0,0,1,1,1};
	static int[] dc = {-1,0,1,-1,1,-1,0,1};
	
	static class Tree implements Comparable<Tree>{
		
		int r;
		int c;
		int age;
		
		Tree(){}
		
		public Tree(int r, int c, int age) {
			this.r = r;
			this.c = c;
			this.age = age;
		}

		@Override
		public int compareTo(Main.Tree o) {
			return this.age - o.age;
		}

		
	}

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		// 땅의 크기
		N = sc.nextInt();

		// 땅
		land = new int[N][N];

		// 초기 양분 5
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				land[i][j] = 5;
			}
		}
		
		// 나무 저장 배열 초기화
		trees = new PriorityQueue[N][N];
		deadTrees = new LinkedList[N][N];
		for(int r=0 ; r<N ; r++) {
			for(int c=0 ; c<N ; c++) {
				trees[r][c] = new PriorityQueue();
				deadTrees[r][c] = new LinkedList();
			}
		}

		// 초기 나무의 수
		M = sc.nextInt();

		// 보낼 시간
		K = sc.nextInt();

		// 겨울에 로봇이 돌아다니면서 땅에 줄 양분
		A = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				A[r][c] = sc.nextInt();
			}
		}

		// 초기 나무 정보
		for(int i=0 ; i<M ; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int age = sc.nextInt();
			Tree tree = new Tree(r,c,age);
			trees[r-1][c-1].add(tree);
		}
		
		// K년 보내기
		for(int y=0 ; y<K ; y++) {
			Spring();
			Summer();
			Fall();
			Winter();
		}
		
		// 남은 나무의 수 구히기
		int answer = 0;
		
		for(int r=0 ; r<N ; r++) {
			for(int c=0 ; c<N ; c++) {
				if(!trees[r][c].isEmpty()) {
					answer += trees[r][c].size();
				}
			}
		}
		
		System.out.println(answer);

	} // main

	private static void Spring() {
		/*	
		 * 나무가 자신의 나이만큼 양분을 먹고 나이가 1 증가
		 * 	어린 나무부터 양분을 먹고
		 * 	만약, 땅의 양분이 부족하다면 나무가 죽는다
		 */
		List<Tree> tmp = new LinkedList<>();
		for(int r=0 ; r<N ; r++) {
			for(int c=0 ; c<N ; c++) {
				while(!trees[r][c].isEmpty()) {
					Tree curr = trees[r][c].poll();
					if(land[r][c]-curr.age>=0) {
						land[r][c] -= curr.age;
						curr.age++;
						tmp.add(curr);
					}else {
						deadTrees[r][c].add(curr);
					}
				}
				while(!tmp.isEmpty()) {
					trees[r][c].add(tmp.remove(0));
				}
			}
		}
		
	}

	private static void Summer() {
		/*
		 * 봄에 죽은 아무가 양분으로 변한다
		 * 죽은 나무의 나이를 2로 나눈 값 만큼 나무가 있던 곳에 추가된다
		 */
		for(int r=0 ; r<N ; r++) {
			for(int c=0 ; c<N ; c++) {
				while(!deadTrees[r][c].isEmpty()) {
					Tree dead = deadTrees[r][c].remove(0);
					land[r][c] += dead.age/2;
				}
			}
		}
		
		
	}

	private static void Fall() {
		/*	
		 * 나무의 나이가 5의 배수일 때,
		 * 	인접 8칸에 나이가 1인 나무 추가
		 */
		
		List<Tree> newTrees = new ArrayList();
		for(int r=0 ; r<N ; r++) {
			for(int c=0 ; c<N ; c++) {
				Iterator<Tree> iterator = trees[r][c].iterator();
				while(iterator.hasNext()) {
					Tree curr = iterator.next();
					if(curr.age%5==0) {
						for(int d=0 ; d<8 ; d++) {
							int nr = r + dr[d];
							int nc = c + dc[d];
							
							if(nr>=0 && nr<N && nc>=0 && nc<N) {
								newTrees.add(new Tree(nr,nc,1));
							}
						}
					}
				}
			}
		}
		for(Tree tree : newTrees) {
			trees[tree.r][tree.c].add(tree);
		}
		
	}

	private static void Winter() {
		/*
		 * 로봇이 땅을 돌아다니며 양분 추가
		 */
		for(int r=0 ; r<N ; r++) {
			for(int c=0 ; c<N ; c++) {
				land[r][c] += A[r][c];
			}
		}
		
	}

}