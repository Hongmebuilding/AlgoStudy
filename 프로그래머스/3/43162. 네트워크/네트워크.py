def solution(n, computers):
    answer = 0
    visited = set()
    queue = []
    for i in range(n):
        if i not in visited:
            answer += 1
            queue = [i]
            while queue:
                node = queue.pop(0)
                array = computers[node]
                visited.add(node)
                for i, number in enumerate(array):
                    if i not in visited and number == 1:
                        queue.append(i)
            
    return answer