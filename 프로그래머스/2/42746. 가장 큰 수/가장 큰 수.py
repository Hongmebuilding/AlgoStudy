
def key_func(x):
    return x * 3

def solution(numbers):
    answer = ''
    numbers = list(map(str, numbers))
    numbers.sort(reverse=True, key=key_func)

    answer = ''.join(numbers)
    
    return '0' if answer[0] == '0' else answer