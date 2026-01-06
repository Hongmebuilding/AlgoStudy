def solution(array, commands):
    answer = []
    for idx in range(len(commands)):
        i,j,k = commands[idx]
        copy = sorted(array[i-1:j])
        answer.append(copy[k-1])
    return answer