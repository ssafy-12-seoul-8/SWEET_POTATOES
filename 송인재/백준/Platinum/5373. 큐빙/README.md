# [Platinum V] 큐빙 - 5373 

[문제 링크](https://www.acmicpc.net/problem/5373) 

### 성능 요약

메모리: 22584 KB, 시간: 216 ms

### 분류

구현, 시뮬레이션

### 제출 일자

2024년 9월 8일 10:50:56

### 문제 설명

<p>A Rubik’s Cube is a three-dimensional puzzle. In its original version, it is made up of 3×3×3 smaller cubes. Each of the visible faces of these smaller cubes has one of six colors (white, yellow, red, orange, green or blue). A Rubik’s Cube is said to be solved if on each face, the nine cubes all show the same color.</p>

<p>The Cube is mechanically constructed such that it is possible to rotate any face (that is, any set of 3×3 smaller cubes making up one of the six faces of the entire cube) by 90 degrees in both directions. When a rotation is completed, it is again possible to rotate any face in any direction. Thus by combining rotations performed on different faces, it is possible to mix up the colors. The puzzle is then to take a Cube whose colors are mixed up, and return it to its solved state.</p>

<p>We start from a solved Rubik’s Cube, which is completely white on the top (up) face, yellow on the bottom (down), red on the front, orange on the back, green on the left and blue on the right. You are given a sequence of rotations. Determine what the top face looks like after applying all rotations.</p>

<p><img alt="" src="https://www.acmicpc.net/upload/images/cube.png" style="height:120px; width:319px"></p>

<p>A solved Rubik’s Cube. In the left image the top (white), front (red) and left (green) face are shown. In the right image the same cube is viewed from the opposite side, with the bottom (yellow), back (orange) and right (blue) face visible. Shown is the way in which a face can be rotated (in this case, the left face is partially rotated clockwise).</p>

### 입력 

 <p>On the ﬁrst line one positive number: the number of test cases, at most 100. After that per test case:</p>

<ul>
	<li>one line with an integer n (1 ≤ n ≤ 1 000): the number of rotations.</li>
	<li>one line with n space-separated pairs of characters: the rotations. For each rotation, the ﬁrst character identiﬁes the face that is rotated: ‘U’ for the top (up) face, ‘D’ for the bottom (down), ‘F’ for the front, ‘B’ for the back, ‘L’ for the left and ‘R’ for the right. The second character indicates the direction of the rotation: ‘+’ for a clockwise rotation (when looking directly at the face that is rotated), ‘-’ for a counterclockwise rotation.</li>
</ul>

### 출력 

 <p>Per test case:</p>

<ul>
	<li>three lines, each with three characters: the colors of the squares on the top face of the cube, after applying the rotations. The ﬁrst line corresponds to the squares adjacent to the back side of the cube. The colors are indicated by the ﬁrst letter (lower case): ‘w’ for white, ‘y’ for yellow, ‘r’ for red, ‘o’ for orange, ‘g’ for green and ‘b’ for blue.</li>
</ul>

