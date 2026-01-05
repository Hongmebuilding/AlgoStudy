def solution(n, lost, reserve):
    answer = 0
    lost = set(lost)
    reserve = set(reserve)
    
    both = lost & reserve
    lost = lost - both
    reserve = reserve - both
    
    for student in sorted(lost):
        if student - 1 in reserve:
            reserve.remove(student - 1)
        elif student + 1 in reserve:
            reserve.remove(student + 1)
        else:
            n -= 1
        
    return n