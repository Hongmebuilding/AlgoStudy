def solution(bandage, health, attacks):
    answer = 0
    # bandage는 [시전 시간, 초당 회복량, 추가 회복량]
    # attacks[i]는 [공격 시간, 피해량]
    current_health = health
    prev_time = 0
    for attack_time, damage in attacks:
        # 이전 체력
        success_time = attack_time - prev_time - 1
        success_health = success_time * bandage[1]
        bonus = success_time // bandage[0]
        new_health = current_health + bonus * bandage[2] + success_health
        if new_health >= health:
            current_health = health
        else:
            current_health = new_health
        prev_time = attack_time
        # 공격 계산
        new_health = current_health - damage 
        if new_health <= 0:
            return -1
        else:
            current_health = new_health
    
    answer = current_health
    return answer
