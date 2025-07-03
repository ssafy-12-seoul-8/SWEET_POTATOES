import sys

sys.setrecursionlimit(10 ** 5)
input = sys.stdin.readline


class Node:
    def __init__(self, name=""):
        self.name = name
        self.child = {}  # key: 문자열, value: Node
        self.depth = 0  # 루트 바로 아래 자식이 depth=1


class Trie:
    def __init__(self):
        self.root = Node()

    def insert(self, parts):
        node = self.root
        for d in range(len(parts)):
            part = parts[d]
            if part not in node.child:
                new_node = Node(part)
                new_node.depth = d + 1
                node.child[part] = new_node
            node = node.child[part]
            node.depth = d + 1

    def dfs_print(self, node):
        # 자식 키를 사전 순으로 정렬하여 출력
        for key in sorted(node.child):
            child = node.child[key]
            indent = "--" * (child.depth - 1)
            print(f"{indent}{child.name}")
            self.dfs_print(child)

    def print(self):
        self.dfs_print(self.root)


N = int(input().split()[0])
trie = Trie()
for _ in range(N):
    data = input().split()
    k = int(data[0])
    path = data[1:]
    trie.insert(path)
trie.print()
