N = int(input())
arr = []
for _ in range(N):
    arr += [list(map(int, input().strip()))]

visited = []
stack = []
cntList = []
cnt = 0

for i in range(N):
    for j in range(N):
        if (i,j) not in visited and arr[i][j] == 1:
            stack.append((i,j))
            visited.append((i,j))
            cnt+=1
            
            while stack:
                y, x = stack.pop()
                for dy, dx in [(1,0), (-1,0), (0,1), (0,-1)]:
                    ny, nx = y+dy, x+dx
                    if 0 <= ny < N and 0 <= nx < N and (ny, nx) not in visited and arr[ny][nx] == 1:
                        stack.append((ny, nx))
                        visited.append((ny, nx))
            visited.append((-1,-1))

start = 0
while start < N:
    for i in range(start, len(visited)):
        if visited[i] == (-1,-1):
            cntList.append(i-start)
            start = i+1

cntList.sort()

print(cnt)
for i in range(len(cntList)):
    print(cntList[i])
