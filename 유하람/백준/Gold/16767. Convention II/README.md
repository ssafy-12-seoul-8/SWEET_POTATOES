# [Gold II] Convention II - 16767 

[문제 링크](https://www.acmicpc.net/problem/16767) 

### 성능 요약

메모리: 44704 KB, 시간: 508 ms

### 분류

자료 구조, 우선순위 큐

### 제출 일자

2024년 10월 21일 21:08:52

### 문제 설명

<p>Despite long delays in airport pickups, Farmer John's convention for cows interested in eating grass has been going well so far. It has attracted cows from all over the world.</p>

<p>The main event of the conference, however, is looking like it might cause Farmer John some further scheduling woes. A very small pasture on his farm features a rare form of grass that is supposed to be the tastiest in the world, according to discerning cows. As a result, all of the $N$ cows at the conference ($1 \leq N \leq 10^5$) want to sample this grass. This will likely cause long lines to form, since the pasture is so small it can only accommodate one cow at a time.</p>

<p>Farmer John knows the time $a_i$ that each cow $i$ plans to arrive at the special pasture, as well as the amount of time $t_i$ she plans to spend sampling the special grass, once it becomes her turn. Once cow $i$ starts eating the grass, she spends her full time of $t_i$ before leaving, during which other arriving cows need to wait. If multiple cows are waiting when the pasture becomes available again, the cow with the highest seniority is the next to be allowed to sample the grass. For this purpose, a cow who arrives right as another cow is finishing is considered "waiting". Similarly, if a number of cows all arrive at exactly the same time while no cow is currently eating, then the one with highest seniority is the next to eat.</p>

<p>Please help FJ compute the maximum amount of time any cow might possibly have to wait in line (between time $a_i$ and the time the cow begins eating).</p>

### 입력 

 <p>The first line of input contains $N$. Each of the next $N$ lines specify the details of the $N$ cows in order of seniority (the most senior cow being first). Each line contains $a_i$ and $t_i$ for one cow. The $t_i$'s are positive integers each at most $10^4$, and the $a_i$'s are positive integers at most $10^9$.</p>

### 출력 

 <p>Please print the longest potential waiting time over all the cows.</p>

