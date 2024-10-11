# [Silver III] 패션왕 신해빈 - 9375 

[문제 링크](https://www.acmicpc.net/problem/9375) 

### 성능 요약

메모리: 14324 KB, 시간: 104 ms

### 분류

조합론, 자료 구조, 해시를 사용한 집합과 맵, 수학

### 제출 일자

2024년 10월 11일 21:48:29

### 문제 설명

<p>Spies use attributes to disguise themselves to make sure that they are not recognized. For example, when putting on sunglasses, a spy suddenly looks completely different and cannot be recognized anymore. Every combination of attributes gives a different appearance, but not all combinations are possible. For example, a hat and a turban are both headgear and cannot be used at the same time. Given the list of available attributes, compute how many distinct disguises can be made.</p>

### 입력 

 <p>On the ﬁrst line one positive number: the number of test cases, at most 100. After that per test case:</p>

<ul>
	<li>one line with an integer n (0 ≤ n ≤ 30): the number of available attributes.</li>
	<li>n lines with two space-separated strings: the name and the category of the attribute.</li>
</ul>

<p>All strings consist of at least 1 and at most 20 lowercase letters. Within a test case all names are distinct.</p>

### 출력 

 <p>Per test case:</p>

<ul>
	<li>one line with an integer: the number of possible distinct disguises that can be made with the given attributes, such that at most one attribute from each category is used.</li>
</ul>

