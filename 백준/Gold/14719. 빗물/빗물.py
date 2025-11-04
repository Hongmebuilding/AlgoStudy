H, W = map(int, input().split())
grid = [[0 for _ in range(W)] for _ in range(H)]
arr = list(map(int, input().split()))

for i in range(W):
    if arr[i] != 0:
        for j in range(arr[i]):
            grid[H-arr[i]+j][i] = 1

bucket = 0
for i in range(H):
    start = 0
    while start < W:
        if grid[i][start] == 1:
            move = start + 1
            while move < W:
                if grid[i][move] == 1:
                    if move - start > 1:
                        bucket += move - start - 1
                    start = move
                move += 1
        start += 1

print(bucket)
        
    
    


