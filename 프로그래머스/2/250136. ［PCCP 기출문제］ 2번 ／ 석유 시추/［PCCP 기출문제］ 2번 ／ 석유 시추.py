def solution(land):
    answer = 0
    n, m = len(land), len(land[0])
    visited = [[False for _ in range(m)] for _ in range(n)]  # * 대신 _ 사용
    cnt_arr = [0] * m
    
    def bfs(j, i):
        queue = [[j, i]]
        visited[j][i] = True
        area = 1  # 영역 크기 초기화 (시작 지점 포함)
        columns = set([i])  # 시작 열 추가
        
        while queue:
            r, c = queue.pop(0)
            dr = [-1,0,1,0]
            dc = [0,1,0,-1]
            
            for k in range(4):
                nr = r + dr[k]
                nc = c + dc[k]
                
                if (
                    0 <= nr < n and 0 <= nc < m and
                    land[nr][nc] == 1 and not visited[nr][nc]
                ):
                    queue.append([nr,nc])
                    visited[nr][nc] = True
                    area += 1
                    columns.add(nc)
        
        # 영역이 포함된 모든 열에 영역 크기 추가
        for column in columns:
            cnt_arr[column] += area
                    
    for j in range(n):
        for i in range(m):
            if land[j][i] == 1 and not visited[j][i]:
                bfs(j, i)
    
    # 최대값 찾기
    answer = max(cnt_arr)  # 배열 전체에서 최대값 찾기
    
    return answer