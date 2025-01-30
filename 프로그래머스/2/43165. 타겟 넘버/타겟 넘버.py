def solution(numbers, target):
  answer = 0
  length = len(numbers)
  
  def rec(layer, current_result=""):
    nonlocal answer
    if layer == length:
      sum = 0
      for i in range(length):
        if current_result[i] == '0':
          sum += numbers[i]
        else:
          sum -= numbers[i]
      if sum == target:
        answer += 1
      return
    for i in range(2):
      rec(layer+1, current_result + str(i))

  rec(0)
  return answer