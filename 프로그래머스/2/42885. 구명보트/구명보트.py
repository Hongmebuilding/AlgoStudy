from collections import deque
def solution(people, limit):
    answer = 0
    q = deque(sorted(people))
    
    while q:
        if len(q) >= 2 and q[0] + q[-1] <= limit:
            q.popleft()
            q.pop()
        else:
            q.pop()
        answer += 1
    return answer