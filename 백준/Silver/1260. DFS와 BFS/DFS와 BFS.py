import sys
from collections import defaultdict
from collections import deque

N, M, V = map(int, input().split())
nodes = defaultdict(list)

for i in range(M):
    n1, n2 = map(int, input().split())
    nodes[n1] += [n2]
    nodes[n2] += [n1]

def dfs():
    stack = [V]
    visited = []

    while stack:
        node = stack.pop()

        if node not in visited:
            visited.append(node)
            stack.extend(sorted(nodes[node], reverse=True))
    
    print(*visited)

def bfs():
    q = deque([V])
    visited = []

    while q:
        node = q.popleft()

        if node not in visited:
            visited.append(node)
            q.extend(sorted(nodes[node], reverse=False))
        
    print(*visited)

dfs()
bfs()
