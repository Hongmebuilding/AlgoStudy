def solution(land):
    m = len(land[0])
    n = len(land)
    queue = []
    visited = [[False for _ in range(m)] for _ in range(n)]
    startX, startY = 0, 0
    oilSizeByColumn = [0] * m
    
    for i in range(n):
        for j in range(m):
            if land[i][j] == 1 and not visited[i][j]:
                startX, startY = j, i
                queue.append([startX, startY])
                oil_size, columns = findFraction(land, visited, queue)
                
                for col in columns:
                    oilSizeByColumn[col] += oil_size
    
    return max(oilSizeByColumn)

def findFraction(land, visited, queue):
    m = len(land[0])
    n = len(land)
    dx = [0,0,-1,1]
    dy = [1,-1,0,0]
    columns = set()
    oil_size = 0
    
    while queue:
        x, y = queue.pop(0)
    
        if visited[y][x]:
            continue
            
        visited[y][x] = True
        oil_size += 1
        columns.add(x)
        
        # 4방면 탐색
        for i in range(4):
            newX, newY = x + dx[i], y + dy[i]
            if 0 <= newX < m and 0 <= newY < n and land[newY][newX] == 1 and not visited[newY][newX]:
                    queue.append([newX, newY])
            
    return oil_size, columns