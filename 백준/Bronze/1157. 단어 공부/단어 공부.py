str = input()
arr = [0 for _ in range(26)]

for i in range(len(str)):
    c = ord(str[i])
    if 65 <= c and c <= 90:
        arr[c-65] += 1
    if 97 <= c and c <= 122:
        arr[c-97] += 1

maxValue = -1
index = -1
tie = False
for i in range(26):
    if maxValue == arr[i] and arr[i] != 0:
        tie=True
    if maxValue < arr[i]:
        maxValue = arr[i]
        index = i
        tie=False


if tie:
    print("?")
elif maxValue==0:
    print("?")
else:
    print(chr(index+65))
