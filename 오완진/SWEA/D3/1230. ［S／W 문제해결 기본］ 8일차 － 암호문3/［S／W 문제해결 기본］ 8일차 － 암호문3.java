import java.util.Scanner;

class Node {
    String data;
    Node link;
}

class LinkedList {
    Node head;
    int size;

    LinkedList() {
        head = new Node();
    }

    void insertData(int x, int y, Scanner scanner) {
        if (x < 0 || x > size) {
            return;
        }

        Node curr = head;
        for (int k = 0; k < x; k++) {
            curr = curr.link;
        }

        for (int i = 0; i < y; i++) {
            size++;

            Node newNode = new Node();
            newNode.data = scanner.next();

            newNode.link = curr.link;
            curr.link = newNode;

            curr = newNode;
        }
    }

    void deleteData(int x, int y) {
        if (x < 0 || x + y > size) {
            return;
        }

        Node curr = head;
        for (int k = 0; k < x; k++) {
            curr = curr.link;
        }

        for (int k = 0; k < y; k++) {
            size--;
            curr.link = curr.link.link;
        }
    }

    void addData(int y, Scanner scanner) {
        Node curr = head;
        for (int k = 0; k < size; k++) {
            curr = curr.link;
        }

        for (int k = 0; k < y; k++) {
            size++;

            Node newNode = new Node();
            newNode.data = scanner.next();

            newNode.link = curr.link;
            curr.link = newNode;

            curr = newNode;
        }
    }

    void printData() {
        Node curr = head.link;

        for (int i = 0; i < 10; i++) {
            if (curr == null) break;
            System.out.print(curr.data + " ");
            curr = curr.link;
        }
        System.out.println();
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            int n = scanner.nextInt();
            LinkedList amho = new LinkedList();

            for (int i = 0; i < n; i++) {
                amho.addData(1, scanner);
            }

            int m = scanner.nextInt();

            for (int i = 0; i < m; i++) {
                String command = scanner.next();

                if (command.equals("I")) {
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();
                    amho.insertData(x, y, scanner);

                } else if (command.equals("D")) {
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();
                    amho.deleteData(x, y);

                } else if (command.equals("A")) {
                    int y = scanner.nextInt();
                    amho.addData(y, scanner);
                }
            }

            System.out.print("#" + tc + " ");
            amho.printData();
        }

    }
}
