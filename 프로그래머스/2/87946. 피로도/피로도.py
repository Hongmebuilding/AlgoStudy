def solution(k, dungeons):
    answer = -1
    # 순서존재 -> backtracking -> dfs
    # visited
    # 상태관리: result, k, visited
    N = len(dungeons)
    visited = [False] * N
    def dfs(result, k):
        nonlocal answer
        answer = max(result, answer)
        
        for i in range(N):
            if visited[i]:
                continue
            need, cost = dungeons[i]
            if k < need:
                continue
            visited[i] = True
            score = k - cost
            dfs(result+1, score)
            visited[i] = False
        
    dfs(0,k)
    return answer