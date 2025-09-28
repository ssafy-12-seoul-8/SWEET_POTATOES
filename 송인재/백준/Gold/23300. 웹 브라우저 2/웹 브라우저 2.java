import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static Deque<Integer> back = new ArrayDeque<>();
    static Deque<Integer> front = new ArrayDeque<>();
    static int current = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch(command) {
                case "B":
                    moveBack();
                    break;
                case "F":
                    moveFront();
                    break;
                case "A":
                    int page = Integer.parseInt(st.nextToken());

                    access(page);
                    break;
                case "C":
                    compress();
            }
        }

        StringBuilder sb = new StringBuilder()
            .append(current)
            .append("\n");

        if (back.isEmpty()) {
            sb.append(-1);
        }

        while (!back.isEmpty()) {
            sb.append(back.pop())
                .append(" ");
        }

        sb.append("\n");

        if (front.isEmpty()) {
            sb.append(-1);
        }

        while (!front.isEmpty()) {
            sb.append(front.pop())
                .append(" ");
        }

        System.out.println(sb);
    }

    static void moveBack() {
        if (back.isEmpty()) {
            return;
        }

        front.push(current);

        current = back.pop();
    }

    static void moveFront() {
        if (front.isEmpty()) {
            return;
        }

        back.push(current);

        current = front.pop();
    }

    static void access(int page) {
        front.clear();

        if (current != 0) {
            back.push(current);
        }

        current = page;
    }

    static void compress() {
        Deque<Integer> temp = new ArrayDeque<>();

        while (!back.isEmpty()) {
            int recentBack = back.pop();

            while (!back.isEmpty() && recentBack == back.peek()) {
                recentBack = back.pop();
            }

            temp.push(recentBack);
        }

        while (!temp.isEmpty()) {
            back.push(temp.pop());
        }
    }

}
