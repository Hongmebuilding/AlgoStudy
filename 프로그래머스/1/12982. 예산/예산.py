def solution(d, budget):
    answer = 0
    d = sorted(d)
    sum = 0
    for i in range(len(d)):
        sum+=d[i]
        if sum <= budget:
            answer += 1
        
    return answer