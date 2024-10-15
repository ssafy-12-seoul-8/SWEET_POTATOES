import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static char[][] cube;
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	
    	int TC = Integer.parseInt(st.nextToken());
    	for (int tc = 1; tc <= TC; tc++) {
    		
    		st = new StringTokenizer(br.readLine());
    		int Q = Integer.parseInt(st.nextToken());
    		
    		String[] query = new String[Q];
    		st = new StringTokenizer(br.readLine(), " ");
    		int idx = 0;
    		while (st.hasMoreTokens()) {
    			query[idx++] = st.nextToken();
    		}
    		
    		cube = new char[][]
					{{' ', ' ', ' ', 'o', 'o', 'o', ' ', ' ', ' '},
					 {' ', ' ', ' ', 'o', 'o', 'o', ' ', ' ', ' '},
					 {' ', ' ', ' ', 'o', 'o', 'o', ' ', ' ', ' '},
					 {'g', 'g', 'g', 'w', 'w', 'w', 'b', 'b', 'b'},
					 {'g', 'g', 'g', 'w', 'w', 'w', 'b', 'b', 'b'},
					 {'g', 'g', 'g', 'w', 'w', 'w', 'b', 'b', 'b'},
					 {' ', ' ', ' ', 'r', 'r', 'r', ' ', ' ', ' '},
					 {' ', ' ', ' ', 'r', 'r', 'r', ' ', ' ', ' '},
					 {' ', ' ', ' ', 'r', 'r', 'r', ' ', ' ', ' '},
					 {' ', ' ', ' ', 'y', 'y', 'y', ' ', ' ', ' '},
					 {' ', ' ', ' ', 'y', 'y', 'y', ' ', ' ', ' '},
					 {' ', ' ', ' ', 'y', 'y', 'y', ' ', ' ', ' '}};
    		
    		for (int q = 0; q < Q; q++) {
    			
    			String cmd = query[q];
    			switch(cmd){
				case ("L+"):
					Lplus();
					clock(3, 0);
					break;
				case ("L-"):
					Lmnus();
					unclock(3, 0);
					break;
				case ("R+"):
					Rplus();
					clock(3, 6);
					break;
				case ("R-"):
					Rmnus();
					unclock(3, 6);
					break;
				case ("B+"):
					Bplus();
					clock(0, 3);
					break;
				case ("B-"):
					Bmnus();
					unclock(0, 3);
					break;
				case ("U+"):
					Uplus();
					clock(3, 3);
					break;
				case ("U-"):
					Umnus();
					unclock(3, 3);
					break;
				case ("F+"):
					Fplus();
					clock(6, 3);
					break;
				case ("F-"):
					Fmnus();
					unclock(6, 3);
					break;
				case ("D+"):
					Dplus();
					clock(9, 3);
					break;
				case ("D-"):
					Dmnus();
					unclock(9, 3);
					break;
    			}
    		}//q
    		
    		for (int r = 3; r < 6; r++) {
    			for (int c = 3; c < 6; c++) {
    				sb.append(cube[r][c]);
    			}
    			sb.append("\n");
    		}
//    		for (int r = 0; r < 12; r++) {
//    			for (int c = 0; c < 9; c++) {
//    				sb.append(cube[r][c]);
//    			}
//    			sb.append("\n");
//    		}
    	}//tc
    	
    	System.out.println(sb);
    }
    
    static void clock(int r, int c) {
    	char tmp = cube[r][c];
    	cube[r][c] = cube[r+2][c];
    	cube[r+2][c] = cube[r+2][c+2];
    	cube[r+2][c+2] = cube[r][c+2];
    	cube[r][c+2] = tmp;
    	
    	tmp = cube[r][c+1];
    	cube[r][c+1] = cube[r+1][c];
    	cube[r+1][c] = cube[r+2][c+1];
    	cube[r+2][c+1] = cube[r+1][c+2];
    	cube[r+1][c+2] = tmp;
    }
    
    static void unclock(int r, int c) {
    	char tmp = cube[r][c];
    	cube[r][c] = cube[r][c+2];
    	cube[r][c+2] = cube[r+2][c+2];
    	cube[r+2][c+2] = cube[r+2][c];
    	cube[r+2][c] = tmp;
    	
    	tmp = cube[r][c+1];
    	cube[r][c+1] = cube[r+1][c+2];
    	cube[r+1][c+2] = cube[r+2][c+1];
    	cube[r+2][c+1] = cube[r+1][c];
    	cube[r+1][c] = tmp;
    }
    
    static void Lplus() {
    	for (int i = 0; i < 3; i++) {
    		char tmp = cube[11][3];
    		for (int r = 11; r >= 1; r--)
    			cube[r][3] = cube[r-1][3];
    		cube[0][3] = tmp;
    	}
    }
    
    static void Lmnus() {
    	for (int i = 0; i < 3; i++) {
    		char tmp = cube[0][3];
    		for (int r = 0; r <= 10; r++)
    			cube[r][3] = cube[r+1][3];
    		cube[11][3] = tmp;
    	}
    }
    
    static void Rplus() {
    	for (int i = 0; i < 3; i++) {
    		char tmp = cube[0][5];
    		for (int r = 0; r <= 10; r++)
    			cube[r][5] = cube[r+1][5];
    		cube[11][5] = tmp;
    	}
    }
    
    static void Rmnus() {
    	for (int i = 0; i < 3; i++) {
    		char tmp = cube[11][5];
    		for (int r = 11; r >= 1; r--)
    			cube[r][5] = cube[r-1][5];
    		cube[0][5] = tmp;
    	}
    }
    
    static void Bplus() {
    	for (int i = 0; i < 3; i++) {
    		char tmp1 = cube[3][0];
    		for (int c = 0; c <= 7; c++)
    			cube[3][c] = cube[3][c+1];
    		char tmp2 = cube[11][5];
    		for (int c = 5; c >= 4; c--)
    			cube[11][c] = cube[11][c-1];
    		cube[11][3] = tmp1;
    		cube[3][8] = tmp2;
    	}
    }
    
    static void Bmnus() {
    	for (int i = 0; i < 3; i++) {
    		char tmp1 = cube[3][8];
    		for (int c = 8; c >= 1; c--)
    			cube[3][c] = cube[3][c-1];
    		char tmp2 = cube[11][3];
    		for (int c = 3; c <= 4; c++)
    			cube[11][c] = cube[11][c+1];
    		cube[11][5] = tmp1;
    		cube[3][0] = tmp2;
    	}
    }
    
    static void Uplus() {
    	for (int i = 0; i < 3; i++) {
    		char tmp = cube[2][5];
    		cube[2][5] = cube[2][4];
    		cube[2][4] = cube[2][3];
    		cube[2][3] = cube[3][2];
    		cube[3][2] = cube[4][2];
    		cube[4][2] = cube[5][2];
    		cube[5][2] = cube[6][3];
    		cube[6][3] = cube[6][4];
    		cube[6][4] = cube[6][5];
    		cube[6][5] = cube[5][6];
    		cube[5][6] = cube[4][6];
    		cube[4][6] = cube[3][6];
    		cube[3][6] = tmp;
    	}
    }
    
    static void Umnus() {
    	for (int i = 0; i < 3; i++) {
    		char tmp = cube[2][3];
    		cube[2][3] = cube[2][4];
    		cube[2][4] = cube[2][5];
    		cube[2][5] = cube[3][6];
    		cube[3][6] = cube[4][6];
    		cube[4][6] = cube[5][6];
    		cube[5][6] = cube[6][5];
    		cube[6][5] = cube[6][4];
    		cube[6][4] = cube[6][3];
    		cube[6][3] = cube[5][2];
    		cube[5][2] = cube[4][2];
    		cube[4][2] = cube[3][2];
    		cube[3][2] = tmp;
    	}
    }
    
    static void Fplus() {
    	for (int i = 0; i < 3; i++) {
    		char tmp1 = cube[5][8];
    		for (int c = 8; c >= 1; c--)
    			cube[5][c] = cube[5][c-1];
    		char tmp2 = cube[9][3];
    		for (int c = 3; c <= 4; c++)
    			cube[9][c] = cube[9][c+1];
    		cube[9][5] = tmp1;
    		cube[5][0] = tmp2;
    	}
    }
    
    static void Fmnus() {
    	for (int i = 0; i < 3; i++) {
    		char tmp1 = cube[5][0];
    		for (int c = 0; c <= 7; c++)
    			cube[5][c] = cube[5][c+1];
    		char tmp2 = cube[9][5];
    		for (int c = 5; c >= 4; c--)
    			cube[9][c] = cube[9][c-1];
    		cube[9][3] = tmp1;
    		cube[5][8] = tmp2;
    	}
    }
    
    static void Dplus() {
    	for (int i = 0; i < 3; i++) {
    		char tmp = cube[8][5];
    		cube[8][5] = cube[8][4];
    		cube[8][4] = cube[8][3];
    		cube[8][3] = cube[5][0];
    		cube[5][0] = cube[4][0];
    		cube[4][0] = cube[3][0];
    		cube[3][0] = cube[0][3];
    		cube[0][3] = cube[0][4];
    		cube[0][4] = cube[0][5];
    		cube[0][5] = cube[3][8];
    		cube[3][8] = cube[4][8];
    		cube[4][8] = cube[5][8];
    		cube[5][8] = tmp;
    	}
    }
    
    static void Dmnus() {
    	for (int i = 0; i < 3; i++) {
    		char tmp = cube[8][3];
    		cube[8][3] = cube[8][4];
    		cube[8][4] = cube[8][5];
    		cube[8][5] = cube[5][8];
    		cube[5][8] = cube[4][8];
    		cube[4][8] = cube[3][8];
    		cube[3][8] = cube[0][5];
    		cube[0][5] = cube[0][4];
    		cube[0][4] = cube[0][3];
    		cube[0][3] = cube[3][0];
    		cube[3][0] = cube[4][0];
    		cube[4][0] = cube[5][0];
    		cube[5][0] = tmp;
    	}
    }
    
}