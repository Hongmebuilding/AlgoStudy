from itertools import combinations
from collections import Counter

def solution(orders, course):
    answer = []
    # orders 에서 나올 수 있는 조합을 다 품
    # counter 로 셈(update)
    # 가장 많이 나온 것들 answer 에 넣기
    for c in course:
        comb_counter = Counter()
        
        for order in orders:
            order = sorted(order)
            comb = combinations(order, c)
            comb_counter.update(comb)
    
        if not comb_counter:
            continue
        
        max_cnt = max(comb_counter.values())
        
        if max_cnt <2:
            continue
        
        for comb,cnt in comb_counter.items():
            if cnt == max_cnt:
                answer.append(''.join(comb))
    
    return sorted(answer)