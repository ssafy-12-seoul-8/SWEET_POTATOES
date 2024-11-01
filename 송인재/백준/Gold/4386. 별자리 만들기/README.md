# [Gold III] 별자리 만들기 - 4386 

[문제 링크](https://www.acmicpc.net/problem/4386) 

### 성능 요약

메모리: 14916 KB, 시간: 128 ms

### 분류

그래프 이론, 최소 스패닝 트리

### 제출 일자

2024년 11월 1일 16:43:26

### 문제 설명

<p>In an episode of the Dick Van Dyke show, little Richie connects the freckles on his Dad's back to form a picture of the Liberty Bell. Alas, one of the freckles turns out to be a scar, so his Ripley's engagement falls through.</p>

<p>Consider Dick's back to be a plane with freckles at various (x,y) locations. Your job is to tell Richie how to connect the dots so as to minimize the amount of ink used. Richie connects the dots by drawing straight lines between pairs, possibly lifting the pen between lines. When Richie is done there must be a sequence of connected lines from any freckle to any other freckle.</p>

### 입력 

 <p>The first line contains 0 < n <= 100, the number of freckles on Dick's back. For each freckle, a line follows; each following line contains two real numbers indicating the (x,y) coordinates of the freckle.</p>

### 출력 

 <p>Your program prints a single real number to two decimal places: the minimum total length of ink lines that can connect all the freckles.</p>

