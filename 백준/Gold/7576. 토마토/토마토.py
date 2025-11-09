from collections import deque

# 미방문 : -1/ 벽 : -2/ 시작점: 0

M, N = map(int, input().split())
arr = []
for i in range(N):
    arr += [list(map(int, input().split()))]

dist = [[-1 for _ in range(M)] for _ in range(N)]

q = deque()
for i in range(N):
    for j in range(M):
        if arr[i][j] == 1:
            dist[i][j] = 0
            q.append((i,j))
        elif arr[i][j] == -1:
            dist[i][j] = -2

while q:
    y, x = q.popleft()

    for dy, dx in [(1,0), (-1,0), (0,1), (0,-1)]:
        ny, nx = y+dy, x+dx
        
        if 0 <= ny < N and 0 <= nx < M and dist[ny][nx] == -1 and arr[ny][nx] == 0:
            dist[ny][nx] = dist[y][x] + 1
            q.append((ny, nx))
            

none = False
maxValue = -1
for i in range(N):
    for j in range(M):
        if dist[i][j] == -1 and arr[i][j] == 0:
            none = True
        elif dist[i][j] >= 0:
            maxValue = max(maxValue, dist[i][j])

if none:
    print(-1)
else:
    print(maxValue)
