import java.util.Scanner;

public class Main {
	
	static int[] tree = new int[10001];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
        int idx = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.isEmpty()) break;
            tree[idx++] = Integer.parseInt(line);
        }

        postorder(0, idx - 1);
	}
	
    static void postorder(int n, int end) {
        if (n > end) return;

        int mid = n + 1;
        while (mid <= end && tree[mid] < tree[n])
            mid++;

        postorder(n + 1, mid - 1);
        postorder(mid, end);
        System.out.println(tree[n]);
    }
}