import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static char[][] cube;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		char[] color = new char[] { 'o', 'w', 'r', 'y', 'g', 'b' };

		for (int tc = 1; tc <= T; tc++) {
//			sb.append(tc).append("번 케이스\n");
			cube = new char[6][9];
			for (int i = 0; i < 6; i++) {
				for(int j=0 ; j<9 ; j++) {
					cube[i][j] = color[i];
				}
			}

			int t = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < t; i++) {
				String cmd = st.nextToken();
				char face = cmd.charAt(0);
				char dir = cmd.charAt(1);
				if (dir == '+') {
					Change(face);
				} else {
					for (int j = 0; j < 3; j++) {
						Change(face);
					}
				}
			}

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					sb.append(cube[1][i * 3 + j]);
				}
				sb.append("\n");
			}

		}

		System.out.println(sb);

	} // main

	private static void Change(char face) {
		char[] tmp = new char[3];

		switch (face) {
		case 'U':
			rotateFace(1);
			// 위
			tmp[0] = cube[0][6];
			tmp[1] = cube[0][7];
			tmp[2] = cube[0][8];

			cube[0][6] = cube[4][8];
			cube[0][7] = cube[4][5];
			cube[0][8] = cube[4][2];

			cube[4][8] = cube[2][2];
			cube[4][5] = cube[2][1];
			cube[4][2] = cube[2][0];

			cube[2][2] = cube[5][0];
			cube[2][1] = cube[5][3];
			cube[2][0] = cube[5][6];

			cube[5][0] = tmp[0];
			cube[5][3] = tmp[1];
			cube[5][6] = tmp[2];

			break;
		case 'D':
			// 아래
			rotateFace(3);
			tmp[0] = cube[2][6];
			tmp[1] = cube[2][7];
			tmp[2] = cube[2][8];

			cube[2][6] = cube[4][0];
			cube[2][7] = cube[4][3];
			cube[2][8] = cube[4][6];

			cube[4][0] = cube[0][2];
			cube[4][3] = cube[0][1];
			cube[4][6] = cube[0][0];

			cube[0][2] = cube[5][8];
			cube[0][1] = cube[5][5];
			cube[0][0] = cube[5][2];

			cube[5][8] = tmp[0];
			cube[5][5] = tmp[1];
			cube[5][2] = tmp[2];

			break;
		case 'F':
			// 앞
			rotateFace(2);
			tmp[0] = cube[1][6];
			tmp[1] = cube[1][7];
			tmp[2] = cube[1][8];

			cube[1][6] = cube[4][6];
			cube[1][7] = cube[4][7];
			cube[1][8] = cube[4][8];

			cube[4][6] = cube[3][2];
			cube[4][7] = cube[3][1];
			cube[4][8] = cube[3][0];

			cube[3][2] = cube[5][6];
			cube[3][1] = cube[5][7];
			cube[3][0] = cube[5][8];

			cube[5][6] = tmp[0];
			cube[5][7] = tmp[1];
			cube[5][8] = tmp[2];

			break;
		case 'B':
			// 뒤
			rotateFace(0);
			tmp[0] = cube[3][6];
			tmp[1] = cube[3][7];
			tmp[2] = cube[3][8];

			cube[3][6] = cube[4][2];
			cube[3][7] = cube[4][1];
			cube[3][8] = cube[4][0];

			cube[4][2] = cube[1][2];
			cube[4][1] = cube[1][1];
			cube[4][0] = cube[1][0];

			cube[1][2] = cube[5][2];
			cube[1][1] = cube[5][1];
			cube[1][0] = cube[5][0];

			cube[5][2] = tmp[0];
			cube[5][1] = tmp[1];
			cube[5][0] = tmp[2];

			break;
		case 'L':
			// 왼쪽
			rotateFace(4);
			tmp[0] = cube[0][0];
			tmp[1] = cube[0][3];
			tmp[2] = cube[0][6];

			cube[0][0] = cube[3][0];
			cube[0][3] = cube[3][3];
			cube[0][6] = cube[3][6];

			cube[3][0] = cube[2][0];
			cube[3][3] = cube[2][3];
			cube[3][6] = cube[2][6];

			cube[2][0] = cube[1][0];
			cube[2][3] = cube[1][3];
			cube[2][6] = cube[1][6];

			cube[1][0] = tmp[0];
			cube[1][3] = tmp[1];
			cube[1][6] = tmp[2];

			break;
		case 'R':
			// 오른쪽
			rotateFace(5);
			tmp[0] = cube[0][8];
			tmp[1] = cube[0][5];
			tmp[2] = cube[0][2];

			cube[0][8] = cube[1][8];
			cube[0][5] = cube[1][5];
			cube[0][2] = cube[1][2];

			cube[1][8] = cube[2][8];
			cube[1][5] = cube[2][5];
			cube[1][2] = cube[2][2];

			cube[2][8] = cube[3][8];
			cube[2][5] = cube[3][5];
			cube[2][2] = cube[3][2];

			cube[3][8] = tmp[0];
			cube[3][5] = tmp[1];
			cube[3][2] = tmp[2];

			break;
		}

	}
	
	private static void rotateFace(int faceIdx) {
	    char[] tmp = new char[9];
	    for (int i = 0; i < 9; i++) {
	        tmp[i] = cube[faceIdx][i];
	    }
	    cube[faceIdx][0] = tmp[6];
	    cube[faceIdx][1] = tmp[3];
	    cube[faceIdx][2] = tmp[0];
	    cube[faceIdx][3] = tmp[7];
	    cube[faceIdx][4] = tmp[4];
	    cube[faceIdx][5] = tmp[1];
	    cube[faceIdx][6] = tmp[8];
	    cube[faceIdx][7] = tmp[5];
	    cube[faceIdx][8] = tmp[2];
	}


} // Main class
