import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String initCondition = br.readLine();
        StringTokenizer st = new StringTokenizer(initCondition);
        int q = Integer.parseInt(st.nextToken());
        int mod = Integer.parseInt(st.nextToken());

        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Deque<Integer>> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int lastIndex = 0;
        int minIndex = 200001;

        for (int i = 0; i < q; i++) {
            String opAndNum = br.readLine();
            st = new StringTokenizer(opAndNum);
            String operation = st.nextToken();
            int num = 0;
            int value = 0;

            if (st.hasMoreTokens()) {
                num = Integer.parseInt(st.nextToken());
                value = num % mod;
            }

            switch (operation) {
                case "1":
                    stack.push(value);
                    map.putIfAbsent(value, new ArrayDeque<>());
                    map.get(value)
                        .push(lastIndex);
                    lastIndex++;
                    break;
                case "2":
                    if (stack.isEmpty()) break;

                    int last = stack.pop();
                    map.get(last)
                        .pop();
                    lastIndex--;
                    break;
                case "3":
                    for (int j = 0; j < mod; j++) {
                        Deque<Integer> nums = map.get(j);

                        if (nums == null || nums.isEmpty()) {
                            sb.append("-1\n");
                            minIndex = 200001;
                            break;
                        }

                        int index = nums.peek();
                        minIndex = Math.min(minIndex, index);
                    }

                    if (minIndex != 200001)
                        sb.append(lastIndex - minIndex)
                            .append("\n");
                    minIndex = 200001;
            }
        }

        System.out.println(sb);
    }
}