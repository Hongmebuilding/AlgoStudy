def solution(users, emoticons):
    answer = [0, 0]
    L = len(emoticons)
    discount = [10, 20, 30, 40]

    def dfs(idx, result):
        if idx == L:
            plus = 0
            total_sum = 0
            for user in users:
                ratio, price_limit = user
                user_total = 0
                for eidx, disc in enumerate(result):
                    if disc >= ratio:
                        user_total += emoticons[eidx] * (1 - disc / 100)
                if user_total >= price_limit:
                    plus += 1
                else:
                    total_sum += user_total
            
            if plus > answer[0]:
                answer[0] = plus
                answer[1] = total_sum
            elif plus == answer[0] and total_sum > answer[1]:
                answer[1] = total_sum
            return

        for d in discount:
            dfs(idx + 1, result + [d])

    dfs(0, [])
    return answer
