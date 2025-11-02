# [Gold IV] 이진 검색 트리 - 5639 

[문제 링크](https://www.acmicpc.net/problem/5639) 

### 성능 요약

메모리: 300168 KB, 시간: 2292 ms

### 분류

그래프 이론, 그래프 탐색, 트리, 재귀

### 제출 일자

2025년 11월 3일 08:53:49

### 문제 설명

<p>A binary search tree is a binary tree that satisfies the following properties: </p>

<ul>
	<li>The left subtree of a node contains only nodes with keys less than the node's key. </li>
	<li>The right subtree of a node contains only nodes with keys greater than the node's key. </li>
	<li>Both the left and right subtrees must also be binary search trees. </li>
</ul>

<p><img alt="" src="https://www.acmicpc.net/upload/images/bsearchtree.png" style="height:242px; width:426px"></p>

<p>Pre-order traversal (Root-Left-Right) prints out the node’s key by visiting the root node then traversing the left subtree and then traversing the right subtree. Post-order traversal (Left–Right-Root) prints out the left subtree first and then right subtree and finally the root node. For example, the results of pre-order traversal and post-order traversal of the binary tree shown in Figure 1 are as follows: </p>

<ul>
	<li>Pre-order: 50 30 24 5 28 45 98 52 60 </li>
	<li>Post-order: 5 28 24 45 30 60 52 98 50 </li>
</ul>

<p>Given the pre-order traversal of a binary search tree, you task is to find the post-order traversal of this tree.</p>

### 입력 

 <p>The keys of all nodes of the input binary search tree are given according to pre-order traversal. Each node has a key value which is a positive integer less than 10<sup>6</sup>. All values are given in separate lines (one integer per line). You can assume that a binary search tree does not contain more than 10,000 nodes and there are no duplicate nodes. </p>

### 출력 

 <p>The output contains the result of post-order traversal of the input binary tree. Print out one key per line. </p>

