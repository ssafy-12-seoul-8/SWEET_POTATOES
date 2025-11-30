# [Gold I] 열쇠 - 9328 

[문제 링크](https://www.acmicpc.net/problem/9328) 

### 성능 요약

메모리: 20636 KB, 시간: 180 ms

### 분류

구현, 그래프 이론, 그래프 탐색, 너비 우선 탐색, 격자 그래프

### 제출 일자

2025년 11월 30일 09:53:37

### 문제 설명

<p>John is on a mission to steal some documents of importance from a one-story building. He has managed to get hold of a detailed ﬂoor plan of the building, indicating the locations of all the documents. There are doors in the building that require a key to be opened. John has some keys in his possession, and there are some keys in the building itself. Can you help him ﬁgure out how many documents he can steal?</p>

### 입력 

 <p>On the ﬁrst line one positive number: the number of test cases, at most 100. After that per test case:</p>

<ul>
	<li>one line with two space-separated integers h and w (2 ≤ h, w ≤ 100): the height and width of the map.</li>
	<li>h lines with w characters describing the building:
	<ul>
		<li>’.’ is an empty space.</li>
		<li>’*’ is an impenetrable wall.</li>
		<li>’\$’ is a document that John would like to steal.</li>
		<li>an uppercase letter is a door.</li>
		<li>a lowercase letter is a key that opens all doors corresponding to its uppercase equivalent.</li>
	</ul>
	</li>
	<li>one line with a string consisting of distinct lowercase letters: the keys that John has in his possession. If he has no keys, the line contains “0” instead.</li>
</ul>

<p>John can freely move around the outside of the building. For any given door, the number of available keys that open it can be zero, one, or more than one. For any given key, the number of doors that it opens can be zero, one or more than one. Keys can be reused.</p>

### 출력 

 <p>Per test case:</p>

<ul>
	<li>one line with an integer: the total number of documents that John can steal.</li>
</ul>

