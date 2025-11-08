from collections import deque
N, M = map(int, input().split())
arr = []
for i in range(N):
    arr += [list(map(int, input().strip()))]


que = deque()
que.append((0,0))
dist = [[1 for _ in range(M)] for _ in range(N)]
while que:
    y, x = que.popleft()

    for dx, dy in [(-1,0),(1,0),(0,-1),(0,1)]:
            nx = x + dx
            ny = y + dy
            if 0 <= nx < M and 0 <= ny < N and arr[ny][nx] != 0 and dist[ny][nx] == 1:
                dist[ny][nx] = dist[y][x] + 1
                que.append((ny, nx))
        
print(dist[-1][-1])