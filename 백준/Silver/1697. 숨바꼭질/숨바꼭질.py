import sys
from collections import deque

N, K = map(int, input().split())
maxValue = 100000

flag = False
s = [0] * (maxValue + 1)
q = deque()
q.append(N)
while q:
    X = q.popleft()
    if X == K:
        print(0)
        break
    
    for i in (1,2,3):
        if i == 1:
            nX = X + 1
        if i == 2:
            nX = X - 1
        if i == 3:
            nX = X * 2

        if 0 <= nX <= maxValue and s[nX] == 0:
            q.append(nX)
            s[nX] = s[X] + 1
            if nX == K:
                flag = True
                break
    
    if flag:
        print(s[nX])
        break