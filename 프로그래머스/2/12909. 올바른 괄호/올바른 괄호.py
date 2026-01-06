from collections import deque
def solution(s):
    answer = True
    
    # stack 닫는 표시 나올때까지 쌓다가 나오면 소거
    q = deque(s)
    stack = []
    while q:
        ch = q.popleft()
        if ch == '(':
            stack.append(ch)
        if ch == ')':
            if len(stack) > 0:
                stack.pop()
            else:
                return False

    if len(stack) == 0 and len(q) == 0:
        return True
    return False