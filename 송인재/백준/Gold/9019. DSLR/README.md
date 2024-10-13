# [Gold IV] DSLR - 9019 

[문제 링크](https://www.acmicpc.net/problem/9019) 

### 성능 요약

메모리: 301608 KB, 시간: 7028 ms

### 분류

너비 우선 탐색, 그래프 이론, 그래프 탐색

### 제출 일자

2024년 10월 14일 00:07:07

### 문제 설명

<p>Here is a simple calculator providing only four commands, D, S, L, and R. This calculator has only one register for storing a non-negative integer of four decimal digits. Each command modifies the integer n stored in the register as follows. Let us assume the four decimal digits of n from left to right are d<sub>1</sub>, d<sub>2</sub>, d<sub>3</sub>, d<sub>4</sub> and (i.e. n = ((d<sub>1</sub> × 10 + d<sub>2</sub>) × 10 + d<sub>3</sub>) × 10 + d<sub>4</sub>)</p>

<p>D: D doubles up n. If the result is greater than 9999, modulo 10000 is taken. As a result, the new value (2n mod 10000) is stored to the register.<br>
S: S subtracts one from n and stores the result n-1 to the register. If n is zero, 9999 is stored to the register instead.<br>
L: L rotates each of four digits of n to the left and stores the result to the register. After this operation, the four digits of the value of the register from left to right are d<sub>2</sub>, d<sub>3</sub>, d<sub>4</sub>, and d<sub>1</sub>.<br>
R: R rotates each of four digits of n to the right and stores the result to the register. After this operation, the four digits of the value of the register from left to right are d<sub>4</sub>, d<sub>1</sub>, d<sub>2</sub>, and d<sub>3</sub>.</p>

<p>As noted above, L and R commands assume the decimal representation. For example, if n = 1234, applying L results in 2341 and applying R results in 4123 to be stored in the register.</p>

<p>Given two different integers A and B (A ≠ B), you are to write a program to generate a minimal sequence of commands changing the register contents from A to B. For instance, if A = 1234 and B = 3412, applying the following two sequences of commands is changing the register content from A to B.</p>

<p>1234 →<sub>L</sub> 2341 →<sub>L</sub> 3412<br>
1234 →<sub>R</sub> 4123 →<sub>R</sub> 3412</p>

<p>Therefore, your program should print LL or RR as an output for the above input.</p>

<p>Beware the cases where n contains 0 as a decimal digit. For instance, applying L to 1000 produces 1 since rotating 1000 to the left results in 0001. But, applying R to 1000 produces 100 since rotating 1000 to the right results in 0100. </p>

### 입력 

 <p>Your program is to read the input from standard input. The input consists of T test cases. The number of test cases T is given in the first line of the input. Each test case consists of two integers, A and B (A ≠ B),separated by a space, where the former denotes the initial content of the register and the latter denotes the wanted final content of it. Both A and B are greater than or equal to 0 and less than 10,000.</p>

### 출력 

 <p>Your program is to write to standard output. Print a minimal sequence of commands required to change the content of the register from A to B.</p>

