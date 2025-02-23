def solution(n, computers):
    answer = 0
    visited = []
    queue = []
    for i in range(n):
        if i not in visited:
            answer += 1
            queue = [i]
            while queue:
                node = queue.pop(0)
                array = computers[node]
                visited.append(node)
                for i, number in enumerate(array):
                    if i not in visited and number == 1:
                        queue.append(i)
            
    return answer