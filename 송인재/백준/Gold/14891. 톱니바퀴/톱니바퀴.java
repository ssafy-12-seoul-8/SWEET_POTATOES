import java.io.*;
import java.util.*;

public class Main {

	static final int[][] magnetics = new int[4][8];
	static final int[][] pitches = new int[4][2];
	static final short CLOCKWISE = 1;
	static final short ANTICLOCKWISE = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 4; i++) {
			String line = br.readLine();

			for (int j = 0; j < 8; j++) {
				magnetics[i][j] = line.charAt(j) - '0';
			}
		}

		pitches[0] = new int[] { -1, 2 };
		pitches[1] = new int[] { 6, 2 };
		pitches[2] = new int[] { 6, 2 };
		pitches[3] = new int[] { 6, -1 };

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int gear = Integer.parseInt(st.nextToken()) - 1;
			int direction = Integer.parseInt(st.nextToken());
			int nextWait = direction == CLOCKWISE ? turnPitchClockwise(gear, 1) : turnPitchAntiClockwise(gear, 1);
			int prevWait = direction == CLOCKWISE ? turnPitchClockwise(gear, 0) : turnPitchAntiClockwise(gear, 0);

			turn(gear, direction * -1, -1);
			turn(gear, direction * -1, 1);

			pitches[gear][0] = prevWait;
			pitches[gear][1] = nextWait;
		}

		System.out.println(getSum());
	}

	static int getSum() {
		int sum = 0;

		for (int i = 0; i < pitches.length; i++) {
			int score = pitches[i][0] == -1 ? pitches[i][1] - 2 : pitches[i][0] + 2;

			if (score < 0) {
				score += 8;
			}

			if (score > 7) {
				score -= 8;
			}

			sum += magnetics[i][score] << i;
		}

		return sum;
	}

	static void turn(int gear, int direction, int next) {
		int nextGear = gear + next;

		if (nextGear < 0 || nextGear > 3) {
			return;
		}

		int thisPitch = next == -1 ? pitches[gear][0] : pitches[gear][1];
		int nextPitch = next == -1 ? pitches[nextGear][1] : pitches[nextGear][0];

		if (magnetics[gear][thisPitch] != magnetics[nextGear][nextPitch]) {
			int nextWait = direction == CLOCKWISE ? turnPitchClockwise(nextGear, 1) : turnPitchAntiClockwise(nextGear, 1);
			int prevWait = direction == CLOCKWISE ? turnPitchClockwise(nextGear, 0) : turnPitchAntiClockwise(nextGear, 0);

			turn(nextGear, direction * -1, next);

			pitches[nextGear][0] = prevWait;
			pitches[nextGear][1] = nextWait;
		}
	}

	static int turnPitchClockwise(int gear, int pitch) {
		if (pitches[gear][pitch] == -1) {
			return -1;
		}

		if (pitches[gear][pitch] == 0) {
			return 7;
		}

		return pitches[gear][pitch] - 1;
	}

	static int turnPitchAntiClockwise(int gear, int pitch) {
		if (pitches[gear][pitch] == -1) {
			return -1;
		}

		if (pitches[gear][pitch] == 7) {
			return 0;
		}
		
		return pitches[gear][pitch] + 1;
	}

}