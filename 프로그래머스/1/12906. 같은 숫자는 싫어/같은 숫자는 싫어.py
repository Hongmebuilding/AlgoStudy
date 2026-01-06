from collections import deque
def solution(arr):
    answer = []
    # window
    N=len(arr)
    s, e = 0, 0
    while 1:
        if s>=N or e>=N:
            break
        if arr[s] == arr[e]:
            answer.append(arr[s])
            while s<N and e<N and arr[s] == arr[e]:
                e+=1
        else: s=e
    return answer