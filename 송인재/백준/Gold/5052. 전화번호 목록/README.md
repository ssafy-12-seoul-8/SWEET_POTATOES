# [Gold IV] 전화번호 목록 - 5052 

[문제 링크](https://www.acmicpc.net/problem/5052) 

### 성능 요약

메모리: 35852 KB, 시간: 628 ms

### 분류

자료 구조, 정렬, 문자열, 트리, 트라이

### 제출 일자

2024년 10월 6일 14:58:35

### 문제 설명

<p>Given a list of phone numbers, determine if it is consistent in the sense that no number is the preﬁx of another. Let’s say the phone catalogue listed these numbers:</p>

<ul>
	<li>Emergency 911</li>
	<li>Alice 97 625 999</li>
	<li>Bob 91 12 54 26</li>
</ul>

<p>In this case, it’s not possible to call Bob, because the central would direct your call to the emergency line as soon as you had dialled the ﬁrst three digits of Bob’s phone number. So this list would not be consistent.</p>

### 입력 

 <p>The ﬁrst line of input gives a single integer, 1 ≤ t ≤ 40, the number of test cases. Each test case starts with n, the number of phone numbers, on a separate line, 1 ≤ n ≤ 10000. Then follows n lines with one unique phone number on each line. A phone number is a sequence of at most ten digits.</p>

### 출력 

 <p>For each test case, output “YES” if the list is consistent, or “NO” otherwise.</p>

