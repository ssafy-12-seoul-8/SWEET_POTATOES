import sys

class Node:
    def __init__(self):
        self.child = {}        # 자식 노드 맵
        self.end = False       # 단어 종료 표시
        self.child_count = 0   # 이 노드를 거친 단어 수

class Trie:
    def __init__(self):
        self.root = Node()
        self.count = 0

    def insert(self, s: str):
        node = self.root
        for c in s:
            node.child_count += 1
            node.child.setdefault(c, Node())
            node = node.child[c]
        node.child_count += 1
        node.end = True

    def find_sum(self):
        def dfs(node: Node):
            if not node.child:
                return
            if node is self.root or node.end or len(node.child) >= 2:
                for nxt in node.child.values():
                    self.count += nxt.child_count
                    dfs(nxt)
            else:
                for nxt in node.child.values():
                    dfs(nxt)
        dfs(self.root)

def main():
    rd = sys.stdin.readline
    out_lines = []

    while True:
        try:
            line = rd()
            # Java의 br.readLine()에서 null 반환시 catch로 빠지지만,
            # Python은 빈 문자열 반환 → EOF 처리
            if not line:
                break

            N = int(line.strip())
            trie = Trie()

            for _ in range(N):
                word = rd().strip()
                trie.insert(word)

            trie.find_sum()
            avg = trie.count / N
            out_lines.append(f"{avg:.2f}")

        except Exception:
            # 입력 포맷 오류나 EOF 발생 시 루프 종료
            break

    sys.stdout.write("\n".join(out_lines))

if __name__ == "__main__":
    main()
