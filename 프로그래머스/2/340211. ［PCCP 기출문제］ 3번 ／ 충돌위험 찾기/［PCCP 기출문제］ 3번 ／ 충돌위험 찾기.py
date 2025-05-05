from collections import defaultdict

def solution(points, routes):
    answer = 0
    visited = defaultdict(int)
    
    for route in routes:
        sr, sc = points[route[0] - 1]
        t = 0
        visited[(sr, sc, t)] += 1
        
        for i in range(len(route) - 1):
            start = points[route[i] - 1]
            end = points[route[i + 1] - 1]
            
            sr, sc = start
            er, ec = end
            
            dr =  1 if sr < er else -1 if sr > er else 0
            dc =  1 if sc < ec else -1 if sc > ec else 0
            
            while (sr, sc) != (er, ec):
                if sr != er:
                    sr += dr
                else:
                    sc += dc
                t += 1
                visited[(sr, sc, t)] += 1
                
                
    for (r,c,t), count in visited.items():
        if count >= 2:
            answer += 1
    return answer