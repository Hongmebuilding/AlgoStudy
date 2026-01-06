from collections import deque
def solution(maps):
    answer = -1
    # 최단거리 -> bfs, 중복 없음
    # 상태관리: x,y,visited,step
    N = len(maps)
    M = len(maps[0])
    visited = [[False]*M for _ in range(N)]
    
    q = deque()
    q.append((0,0,1))
    visited[0][0] = True
    while q:
        y,x,step = q.popleft()
            
        if y==N-1 and x==M-1:
            answer = step
            return answer

        for dy, dx in [(-1,0),(1,0),(0,-1),(0,1)]:
            ny, nx = y + dy, x + dx
            if 0 > ny or ny >= N or 0 > nx or nx >= M:
                continue
            if maps[ny][nx] == 1 and not visited[ny][nx]:
                q.append((ny,nx,step+1))
                visited[ny][nx] = True
        
    return answer
        
    