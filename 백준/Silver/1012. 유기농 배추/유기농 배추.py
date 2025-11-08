T = int(input())

def solution():
    M, N, K = map(int, input().split())
    arr = [[0 for _ in range(M)] for _ in range(N)]
    for _ in range(K):
        X, Y = map(int, input().split())
        arr[Y][X] = 1

    visited = []
    cnt = 0

    for i in range(N):
        for j in range(M):
            if (i,j) not in visited and arr[i][j] == 1:
                cnt += 1
                stack = [(i,j)]
                visited.append((i, j))
                while stack:
                    y, x = stack.pop()
                    for dy, dx in [(1,0),(-1,0),(0,1),(0,-1)]:
                        ny, nx = y+dy, x+dx
                        if 0 <= ny < N and 0 <= nx < M and arr[ny][nx] == 1 and (ny,nx) not in visited:
                            stack.append((ny, nx))
                            visited.append((ny, nx))

    print(cnt)

for _ in range(T):
    solution()