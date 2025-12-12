# [Gold V] 암호코드 - 2011 

[문제 링크](https://www.acmicpc.net/problem/2011) 

### 성능 요약

메모리: 14204 KB, 시간: 112 ms

### 분류

다이나믹 프로그래밍

### 제출 일자

2025년 12월 12일 20:11:30

### 문제 설명

<p>Alice and Bob need to send secret messages to each other and are discussing ways to encode their messages:</p>

<ul>
	<li>Alice: “Let’s just use a very simple code: We’ll assign ‘A’ the code word 1, ‘B’ will be 2, and so on down to ‘Z’ being assigned 26.”</li>
	<li>Bob: “That’s a stupid code, Alice. Suppose I send you the word ‘BEAN’ encoded as 25114. You could decode that in many different ways!”</li>
	<li>Alice: “Sure you could, but what words would you get? Other than ‘BEAN’, you’d get ‘BEAAD’, ‘YAAD’, ‘YAN’, ‘YKD’ and ‘BEKD’. I think you would be able to figure out the correct decoding. And why would you send me the word ‘BEAN’ anyway?”</li>
	<li>Bob: “OK, maybe that’s a bad example, but I bet you that if you got a string of length 500 there would be tons of different decodings and with that many you would find at least two different ones that would make sense.”</li>
	<li>Alice: “How many different decodings?”</li>
	<li>Bob: “Jillions!”</li>
</ul>

<p>For some reason, Alice is still unconvinced by Bob’s argument, so she requires a program that will determine how many decodings there can be for a given string using her code.</p>

### 입력 

 <p>Input will consist of multiple input sets. Each set will consist of a single line of digits representing a valid encryption (for example, no line will begin with a 0). There will be no spaces between the digits. An input line of ‘0’ will terminate the input and should not be processed</p>

### 출력 

 <p>For each input set, output the number of possible decodings for the input string. All answers will be within the range of a long variable.</p>

