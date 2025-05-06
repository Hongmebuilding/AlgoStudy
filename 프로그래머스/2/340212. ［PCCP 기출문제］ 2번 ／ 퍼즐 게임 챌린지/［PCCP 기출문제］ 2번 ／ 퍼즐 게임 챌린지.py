import math

def solution(diffs, times, limit):
    minValue = min(diffs) 
    start = minValue
    maxValue = max(diffs)
    end = maxValue
    answer = maxValue
    
    while start <= end:
        level = (start + end) // 2
        total_time = 0
        
        for idx, diff in enumerate(diffs):
            if level >= diff:
                total_time += times[idx]
            else:
                prev_time = times[idx-1] if idx > 0 else 0
                total_time += (times[idx] + prev_time) * (diff - level) + times[idx] 
            
        if total_time <= limit:
            answer = min(level, answer)
            end = level - 1
        else:
            start = level + 1
            
    return answer